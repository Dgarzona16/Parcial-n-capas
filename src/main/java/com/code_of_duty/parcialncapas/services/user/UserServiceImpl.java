package com.code_of_duty.parcialncapas.services.user;

import com.code_of_duty.parcialncapas.dtos.RegisterReqDTO;
import com.code_of_duty.parcialncapas.entities.User;
import com.code_of_duty.parcialncapas.repositories.UserRepository;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Boolean registerUser(RegisterReqDTO registerReqDTO) {
        if (existsByEmail(registerReqDTO.getEmail()) || existsByUsername(registerReqDTO.getUsername())) {
            return false;
        }
        if (!registerReqDTO.getPassword().equals(registerReqDTO.getConfirmPassword())) {
            return false;
        }
        User user = new User(
                registerReqDTO.getUsername(),
                registerReqDTO.getEmail(),
                registerReqDTO.getPassword()
        );
        try{
            userRepository.save(user);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean existsByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user != null;
    }

    @Override
    public Boolean existsByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user !=null;
    }
}
