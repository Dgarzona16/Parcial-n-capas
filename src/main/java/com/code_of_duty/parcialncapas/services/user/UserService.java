package com.code_of_duty.parcialncapas.services.user;

import com.code_of_duty.parcialncapas.dtos.RegisterReqDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Boolean registerUser(RegisterReqDTO registerReqDTO);
}
