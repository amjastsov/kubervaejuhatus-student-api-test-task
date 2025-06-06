package com.apitask.studentapi.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentCreateRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String studentNumber;
}
