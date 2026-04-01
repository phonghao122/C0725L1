package com.example.ss9.service;

import com.example.ss9.entity.Book;
import com.example.ss9.entity.BorrowRecord;
import com.example.ss9.repository.IBookRepository;
import com.example.ss9.repository.IBorrowRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class BorrowService implements IBorrowService{
    @Autowired
    private IBookRepository bookRepo;

    @Autowired
    private IBorrowRecordRepository recordRepo;

    // ================== BORROW ==================
    @Override
    @Transactional
    public String borrowBook(Integer bookId) {

        Book book = bookRepo.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getQuantity() <= 0) {
            throw new RuntimeException("Book is out of stock!");
        }

        // giảm số lượng
        book.setQuantity(book.getQuantity() - 1);
        bookRepo.save(book);

        // tạo mã 5 số
        String code = generateCode();

        BorrowRecord record = new BorrowRecord();
        record.setBorrowCode(code);
        record.setBook(book);

        recordRepo.save(record);

        return code;
    }

    // ================== RETURN ==================
    @Override
    @Transactional
    public void returnBook(String code) {

        BorrowRecord record = recordRepo.findByBorrowCode(code)
                .orElseThrow(() -> new RuntimeException("Invalid borrow code!"));

        Book book = record.getBook();

        // tăng số lượng
        book.setQuantity(book.getQuantity() + 1);
        bookRepo.save(book);

        // xoá record
        recordRepo.delete(record);
    }

    // ================== RANDOM CODE ==================
    private String generateCode() {
        Random random = new Random();
        int number = 10000 + random.nextInt(90000); // 5 chữ số
        return String.valueOf(number);
    }
}
