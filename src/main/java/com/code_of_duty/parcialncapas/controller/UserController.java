package com.code_of_duty.parcialncapas.controller;

import com.code_of_duty.parcialncapas.dtos.MessageDTO;
import com.code_of_duty.parcialncapas.dtos.RegisterReqDTO;
import com.code_of_duty.parcialncapas.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<MessageDTO> registerUser(@RequestBody RegisterReqDTO registerReqDTO){
        if(userService.existsByUsername(registerReqDTO.getUsername()) || userService.existsByEmail(registerReqDTO.getEmail())){
            return new ResponseEntity<>(new MessageDTO("El nombre de usuario ya existe"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new MessageDTO("Usuario registrado exitosamente"), HttpStatus.OK);

    }
}
