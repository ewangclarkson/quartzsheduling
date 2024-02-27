package com.ewangclarks.quartzsheduler.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private ErrorCode code;
    private String message;
    private String endPoint;
}
