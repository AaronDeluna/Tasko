package org.javaacademy.tasko.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorRes {
    private int status;
    private String errorCode;
    private String message;
}
