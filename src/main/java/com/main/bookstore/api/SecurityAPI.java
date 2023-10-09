package com.main.bookstore.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.bookstore.converter.UserConverter;
import com.main.bookstore.entity.RefreshToken;
import com.main.bookstore.jwt.JwtResponse;
import com.main.bookstore.jwt.JwtUtility;
import com.main.bookstore.jwt.RefreshTokenRequest;
import com.main.bookstore.model.UserModel;
import com.main.bookstore.payload.LoginRequest;
import com.main.bookstore.repository.RefreshTokenRepository;
import com.main.bookstore.service.IUserService;
import com.main.bookstore.service.impl.RefreshTokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SecurityAPI {
	@Autowired
	private JwtUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserConverter converter;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
    private RefreshTokenService refreshTokenService;
	
	@Autowired
	private RefreshTokenRepository refreshTokenRepository;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticationUser(@Valid @RequestBody LoginRequest loginRequest){
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtility.generateToken(loginRequest.getUsername());
		
		RefreshToken refreshToken = refreshTokenService.createRefreshToken(loginRequest.getUsername());
		
		 return ResponseEntity.ok(
	                new JwtResponse(
	                        jwt,
	                        refreshToken.getToken())
	        );
	}
	
	@PostMapping("/signup")
    public String addNewUser(@RequestBody UserModel userInfo) {
        return userService.addUser(converter.toEntity(userInfo));
    }
	
	@GetMapping("/hello")
	@PreAuthorize("hasAuthority('User')")
	public String sayHello ()
    { return "Hello User" ;}
	
	@PostMapping("/refreshToken")
	public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
	    RefreshToken refreshToken = refreshTokenService.findByToken(refreshTokenRequest.getToken());
	    
	    String jwt = jwtUtility.generateToken(refreshTokenService.verifyExpiration(refreshToken).getUser().getUserName());
	    
	    return ResponseEntity.ok(
                new JwtResponse(
                        jwt,
                        refreshToken.getToken())
        );
	}
	
	@PostMapping("/logout/{userName}")
	public ResponseEntity<?> logout(@PathVariable String userName) {
		refreshTokenService.removeFromInstance((refreshTokenRepository.findByUser(userService.findUserByUserName(userName))));
		return ResponseEntity.ok("Logout successful!");
	}
}
