package com.main.bookstore.converter;

public interface Converter<E,M> {
	M toModel(E entity);
	E toEntity(M model);
}
