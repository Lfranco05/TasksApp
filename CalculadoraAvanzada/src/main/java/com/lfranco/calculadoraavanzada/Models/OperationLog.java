package com.lfranco.calculadoraavanzada.Models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OperationLog implements Serializable {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private final String description;
    private final Double result;

    public OperationLog(String description, Double result) {
        this.description = description;
        this.result = result;
    }

    public String getWhen() {
        return timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    public String getDescription() { return description; }
    public Double getResult() { return result; }
}