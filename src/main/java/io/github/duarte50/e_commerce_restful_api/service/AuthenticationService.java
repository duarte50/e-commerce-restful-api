package io.github.duarte50.e_commerce_restful_api.service;

import io.github.duarte50.e_commerce_restful_api.dto.LoginDTO;
import io.github.duarte50.e_commerce_restful_api.dto.AuthenticationDTO;
import io.github.duarte50.e_commerce_restful_api.dto.CreateUserDTO;

public interface AuthenticationService {
    AuthenticationDTO register(CreateUserDTO request);
    AuthenticationDTO authenticate(LoginDTO request);
}
