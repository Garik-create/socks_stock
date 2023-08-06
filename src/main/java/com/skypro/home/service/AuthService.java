//package com.skypro.home.service;
//
//import com.skypro.home.record.RegisrationRecord;
//import org.springframework.http.HttpHeaders;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthService {
//
//    private final UserDetailsService userDetailsService;
//    private final UserService userService;
//    private final RegistrationMapperService mapperService;
//
//    public AuthService(UserDetailsService userDetailsService,
//                       UserService userService,
//                       RegistrationMapperService mapperService) {
//        this.userDetailsService = userDetailsService;
//        this.userService = userService;
//        this.mapperService = mapperService;
//    }
//
//    public void registration(RegisrationRecord registration) {
//
//        userService.save(mapperService.toUserEntity(registration));
//    }
//}
