package com.example.ss9.service;

import com.example.ss9.dto.BorrowRecordDto;
import com.example.ss9.entity.BorrowRecord;

import java.util.List;

public interface IBorrowRecordService {
    boolean save(BorrowRecordDto borrowRecord);
    boolean deleteById(Integer id);
    boolean update(BorrowRecordDto borrowRecord, Integer id);
    BorrowRecord findById(Integer id);
    List<BorrowRecord> findAll();
}
