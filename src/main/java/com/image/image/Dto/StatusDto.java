package com.image.image.Dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public interface StatusDto {
    Integer getCid();
    String getCname();
    String getStatus();
    String getProdName();
    Integer getBid();
    Timestamp getBookedTime();
}
