package com.example.hr.dto.openapi;

import java.time.LocalDateTime;

public record OpenApiDataRequest (int page, int display, LocalDateTime date){
    private static final int DEFAULT_DISPLAY = 10;

    public OpenApiDataRequest(LocalDateTime date){
        this(1, DEFAULT_DISPLAY, date);
    }

}
