package com.cybertek.education.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) //Not preferable!
public class ResponseWrapper {
    private boolean success;
    private String message;
    private Integer code;
    private Object data;
}
