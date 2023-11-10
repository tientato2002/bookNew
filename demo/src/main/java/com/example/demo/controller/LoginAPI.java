//package com.example.demo.controller;
//
//import com.example.demo.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/")
//public class LoginAPI {
//    @Autowired
//    AuthenticationManager authenticationManager;
//    @Autowired
//    UserService userService;
//
//
////    @PostMapping("/login")
////    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
////        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
////        // refreshToken = UUID.randomUUID().toString();
////        // save refresh token - table(refresh_token)(username, refreshtoken,expired)
////        // class TokenDTO(refreshToken,accesstoken)
////        return jwtTokenService.createToken(username);
////    }
//}
