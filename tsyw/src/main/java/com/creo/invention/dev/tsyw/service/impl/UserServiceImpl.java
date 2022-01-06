package com.creo.invention.dev.tsyw.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.creo.invention.dev.tsyw.dto.mapper.UserMapper;
import com.creo.invention.dev.tsyw.dto.user.CreateUserDto;
import com.creo.invention.dev.tsyw.model.Role;
import com.creo.invention.dev.tsyw.model.User;
import com.creo.invention.dev.tsyw.repository.RoleRepository;
import com.creo.invention.dev.tsyw.repository.UserRepository;
import com.creo.invention.dev.tsyw.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final BCryptPasswordEncoder encoder;
    private final UserRepository repository;
    private final RoleRepository roleRepository;

    @Value("${jwt.secret}")
    private String JWT_SECRET;

    @Override
    public String createUser(CreateUserDto dto) {
        var user = userMapper.fromCreateDto(dto);

        user.setPasswordHash(encoder.encode(dto.getPassword()));

        user = repository.save(user);

        // TODO: remove this kostyl
        var role = new Role();
        role.setRoleId(1);
        role.setRoleName("user");
        user.setRole(role);

        return generateJwtForUser(user);
    }

    private String generateJwtForUser(User user) {
        return JWT.create()
                .withClaim("uuid", user.getUserId().toString())
                .withClaim("role", user.getRole().getRoleName())
                .sign(Algorithm.HMAC256(JWT_SECRET.getBytes()));
    }

}
