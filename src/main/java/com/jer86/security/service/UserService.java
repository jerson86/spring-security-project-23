package com.jer86.security.service;

import com.jer86.security.dto.UserResponse;
import com.jer86.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public List<UserResponse> allUsers(){
        var users = repository.findAll();
        return users.stream().map(
                user -> UserResponse
                        .builder()
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .email(user.getEmail())
                        .role(user.getRole().name())
                        .build()
        ).collect(Collectors.toList());
    }

}
