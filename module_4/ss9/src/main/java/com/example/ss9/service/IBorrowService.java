package com.example.ss9.service;

public interface IBorrowService {
    String borrowBook(Integer bookId);
    void returnBook(String code);
}
