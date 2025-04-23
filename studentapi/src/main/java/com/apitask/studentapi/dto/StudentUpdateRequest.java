package com.apitask.studentapi.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentUpdateRequest {
    private String firstName;
    private String lastName;
    private String email;
}
