//package com.skypro.home.security;
//
//import com.skypro.home.service.UserService;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserFromDb implements UserDetailsService {
//
//    private final UserService userService;
//    private final SecurityUserMapperService mapperService;
//    private final SecurityUser userDetails;
//
//    public UserFromDb(UserService userService,
//                      SecurityUserMapperService mapperService,
//                      SecurityUser userDetails) {
//        this.userService = userService;
//        this.mapperService = mapperService;
//        this.userDetails = userDetails;
//    }
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        SecurityUserDto userDto = userService.findByUsername(username)
//                .map(mapperService::toSecurityUserDto)
//                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден."));
//        userDetails.setSecurityUserDto(userDto);
//        return userDetails;
//    }
//}
