package com.example.demo.controllers.dto;

import java.time.OffsetDateTime;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DateRangeRequest {
    @NotNull
    private OffsetDateTime from;
    @NotNull
    private OffsetDateTime to;
}