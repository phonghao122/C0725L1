package com.example.ss9.repository;

import com.example.ss9.entity.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBorrowRecordRepository extends JpaRepository<BorrowRecord, Integer> {
    Optional<BorrowRecord> findByBorrowCode(String code);
}
