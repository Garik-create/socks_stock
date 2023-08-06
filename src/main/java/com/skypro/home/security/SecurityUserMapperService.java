package com.skypro.home.security;

import com.skypro.home.model.User;
import org.springframework.stereotype.Component;

@Component
public class SecurityUserMapperService {

    public SecurityUserDto toSecurityUserDto(User entity) {

        SecurityUserDto dto = new SecurityUserDto();
        dto.setUserName(entity.getUserName());
        dto.setPassword(entity.getPassword());
        dto.setRole(entity.getRole());
        return dto;
    }
}
