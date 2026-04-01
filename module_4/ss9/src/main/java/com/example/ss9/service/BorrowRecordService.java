package com.example.ss9.service;

import com.example.ss9.dto.BorrowRecordDto;
import com.example.ss9.entity.BorrowRecord;
import com.example.ss9.repository.IBorrowRecordRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowRecordService implements IBorrowRecordService{
    @Autowired
    private IBorrowRecordRepository borrowRecordRepository;
    @Override
    public boolean save(BorrowRecordDto borrowRecord) {
        if (borrowRecord != null){
            BorrowRecord newBorrowRecord = new BorrowRecord();
            BeanUtils.copyProperties(borrowRecord,newBorrowRecord);
            borrowRecordRepository.save(newBorrowRecord);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
            BorrowRecord borrowRecord = borrowRecordRepository.findById(id).orElse(null);
            if (borrowRecord != null){
                borrowRecordRepository.delete(borrowRecord);
                return true;
            }
        return false;
    }

    @Override
    public boolean update(BorrowRecordDto borrowRecord, Integer id) {
        if (borrowRecord != null){
            BorrowRecord newBorrowRecord = borrowRecordRepository.findById(id).orElse(null);
            if (newBorrowRecord != null){
                BeanUtils.copyProperties(borrowRecord, newBorrowRecord);
                borrowRecordRepository.save(newBorrowRecord);
                return true;
            }
        }
        return false;
    }

    @Override
    public BorrowRecord findById(Integer id) {
        return borrowRecordRepository.findById(id).orElse(null);
    }

    @Override
    public List<BorrowRecord> findAll() {
        return borrowRecordRepository.findAll();
    }
}
