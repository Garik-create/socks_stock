//package com.skypro.home.service;
//
//import com.skypro.home.model.User;
//import com.skypro.home.record.RegisrationRecord;
//import com.skypro.home.record.Role;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class RegistrationMapperService {
//
//    private final PasswordEncoder encoder;
//
//    public RegistrationMapperService(PasswordEncoder encoder) {
//        this.encoder = encoder;
//    }
//
//    public User toUserEntity(RegisrationRecord userRecord) {
//
//        User user = new User();
//        user.setUserName(userRecord.getUserName());
//        user.setRole(Role.STOCKMAN);
//        user.setPassword(encoder.encode(userRecord.getPassword()));
//        return user;
//    }
//}
