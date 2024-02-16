package com.example.hr.exception;

public class NotFoundException extends BizException{

    public NotFoundException() {
        super("해당 데이터를 찾을 수 없습니다.");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
