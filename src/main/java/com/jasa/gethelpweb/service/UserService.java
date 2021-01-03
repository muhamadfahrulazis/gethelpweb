package com.jasa.gethelpweb.service;

import com.jasa.gethelpweb.dto.UserRegistrationDto;
import com.jasa.gethelpweb.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
