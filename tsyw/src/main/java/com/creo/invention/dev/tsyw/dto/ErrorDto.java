package com.creo.invention.dev.tsyw.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class ErrorDto {

    int code;
    String message;

}
