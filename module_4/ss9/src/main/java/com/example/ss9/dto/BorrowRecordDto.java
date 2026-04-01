package com.example.ss9.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BorrowRecordDto {
    private Integer bookId;

    private String borrowCode;

    private String status;
}
