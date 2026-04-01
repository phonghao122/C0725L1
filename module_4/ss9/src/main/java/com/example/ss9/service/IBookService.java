package com.example.ss9.service;

import com.example.ss9.dto.BookDto;
import com.example.ss9.entity.Book;

import java.util.List;

public interface IBookService {
    boolean save(BookDto book);
    boolean deleteByid(Integer id);
    boolean update(BookDto book, Integer id);
    Book findById(Integer id);
    List<Book> findAll();
}
