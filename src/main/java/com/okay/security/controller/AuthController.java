package com.okay.security.controller;

import com.okay.security.constant.RoleConstants;
import com.okay.security.model.UserDto;
import com.okay.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    //    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<UserDto> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        UserDto userDto = userService.login(username, password);
        if (userDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }
    }

    //    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.register(userDto), HttpStatus.OK);
    }

    @Secured({RoleConstants.ROLE_A})
    @RequestMapping(value = "/testA", method = RequestMethod.GET)
    public ResponseEntity<String> testA() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) authentication.getPrincipal();
        return new ResponseEntity<>("Başarılı response: Test A", HttpStatus.OK);
    }

    @Secured({RoleConstants.ROLE_B})
    @RequestMapping(value = "/testB", method = RequestMethod.GET)
    public ResponseEntity<String> testB() {
        return new ResponseEntity<>("Başarılı response: Test B", HttpStatus.OK);
    }

    @Secured({RoleConstants.ROLE_C})
    @RequestMapping(value = "/testC", method = RequestMethod.GET)
    public ResponseEntity<String> testC() {
        return new ResponseEntity<>("Başarılı response: Test C", HttpStatus.OK);
    }
}