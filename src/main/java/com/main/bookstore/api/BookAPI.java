package com.main.bookstore.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.main.bookstore.model.BookModel;
import com.main.bookstore.service.IBookService;

@RestController
public class BookAPI {
	@Autowired
	IBookService bookService;
	
	@GetMapping("/books")
	public List<BookModel> bookList(){
		return bookService.findAll();
	}
	
	@PostMapping("/addbook")
	public BookModel addBook(@RequestBody BookModel model) {
		return bookService.save(model);
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<BookModel> getBook(@PathVariable("id") String bookId) {	
		BookModel model = bookService.getBookById(bookId);
		if(model!=null) {
			return ResponseEntity.ok(model);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/namebooks")
	public ResponseEntity<List<BookModel>> findAllBooksByName(@RequestParam("bookname") String bookName) {
	    List<BookModel> books = bookService.findAllBooksByName(bookName);
	    if (!books.isEmpty()) {
	        return ResponseEntity.ok(books);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}
