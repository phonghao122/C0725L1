package com.example.ss9.service;

import com.example.ss9.dto.BookDto;
import com.example.ss9.entity.Book;
import com.example.ss9.repository.IBookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository bookRepository;
    @Override
    public boolean save(BookDto book) {
        if (book != null){
            Book newBook = new Book();
            BeanUtils.copyProperties(book, newBook);
            bookRepository.save(newBook);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteByid(Integer id) {
            Book book = bookRepository.findById(id).orElse(null);
            if (book != null){
                bookRepository.delete(book);
                return true;
            }
        return false;
    }

    @Override
    public boolean update(BookDto book, Integer id) {
        if (book != null){
            Book newBook = bookRepository.findById(id).orElse(null);
            if (newBook != null){
                BeanUtils.copyProperties(book, newBook);
                bookRepository.save(newBook);
                return true;
            }
        }
        return false;
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
