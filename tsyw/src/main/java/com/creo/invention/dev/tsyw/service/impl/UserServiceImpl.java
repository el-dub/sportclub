package com.creo.invention.dev.tsyw.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.creo.invention.dev.tsyw.dto.mapper.UserMapper;
import com.creo.invention.dev.tsyw.dto.user.CreateUserDto;
import com.creo.invention.dev.tsyw.dto.user.LoginUserDto;
import com.creo.invention.dev.tsyw.exception.WrongCredentialsException;
import com.creo.invention.dev.tsyw.model.Role;
import com.creo.invention.dev.tsyw.model.User;
import com.creo.invention.dev.tsyw.repository.RoleRepository;
import com.creo.invention.dev.tsyw.repository.UserRepository;
import com.creo.invention.dev.tsyw.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    public String validateUser(LoginUserDto dto) throws WrongCredentialsException {
        var userWithEmail = repository.findUserByEmail(dto.getEmail());
        if (userWithEmail == null)
            throw new WrongCredentialsException("");

        if (encoder.matches(dto.getPassword(), userWithEmail.getPasswordHash())) {
            // TODO: fix role not loading
            var role = new Role();
            role.setRoleId(1);
            role.setRoleName("user");
            userWithEmail.setRole(role);
            return generateJwtForUser(userWithEmail);
        }

        throw new WrongCredentialsException("");
    }

    @Override
    public User getUserFromToken(String token) throws WrongCredentialsException {
        // i know it's not supposed to be here but i'm too lazy to find a better place for it (not too lazy to write this comment tho)
        var validator = JWT.require(Algorithm.HMAC256(JWT_SECRET.getBytes()))
                .build();
        var decodedToken = validator.verify(token);

        var id = UUID.fromString(decodedToken.getClaim("uuid").toString());
        var user = repository.findUserByUserId(id);

        return user;
    }

    private String generateJwtForUser(User user) {
        return JWT.create()
                .withClaim("uuid", user.getUserId().toString())
                .withClaim("role", user.getRole().getRoleName())
                .withClaim("full_name", user.getFirstName() + " " + user.getLastName())
                .sign(Algorithm.HMAC256(JWT_SECRET.getBytes()));
    }

}
