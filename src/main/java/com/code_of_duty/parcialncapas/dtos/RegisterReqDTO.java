package com.code_of_duty.parcialncapas.dtos;

import lombok.Data;

@Data
public class RegisterReqDTO {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
}
