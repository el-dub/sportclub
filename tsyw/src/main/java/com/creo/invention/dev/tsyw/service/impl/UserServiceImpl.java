package com.creo.invention.dev.tsyw.service.impl;

import com.creo.invention.dev.tsyw.dto.mapper.UserMapper;
import com.creo.invention.dev.tsyw.dto.user.CreateUserDto;
import com.creo.invention.dev.tsyw.model.Role;
import com.creo.invention.dev.tsyw.model.User;
import com.creo.invention.dev.tsyw.repository.RoleRepository;
import com.creo.invention.dev.tsyw.repository.UserRepository;
import com.creo.invention.dev.tsyw.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final BCryptPasswordEncoder encoder;
    private final UserRepository repository;
    private final RoleRepository roleRepository;

    @Override
    public String createUser(CreateUserDto dto) {
        var user = userMapper.fromCreateDto(dto);

        user.setPasswordHash(encoder.encode(dto.getPassword()));

        user = repository.save(user);

        return generateJwtForUser(user);
    }

    private String generateJwtForUser(User user) {
        return "todo";
    }

}
