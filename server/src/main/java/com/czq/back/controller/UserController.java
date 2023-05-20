package com.czq.back.controller;

import com.czq.back.dto.ListRet;
import com.czq.back.dto.LoginDTO;
import com.czq.back.dto.PageDTO;
import com.czq.back.dto.QueryIdDTO;
import com.czq.back.entity.User;
import com.czq.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("/list")
    public ListRet getAllusers(@RequestBody PageDTO pageDTO) {
        pageDTO.setPage(pageDTO.getPage()-1);
        return userService.getAllusers(pageDTO);
    }


    @PostMapping("/one")
    public User getuserById(@RequestBody QueryIdDTO queryIdDTO) {
        return userService.getuserById(queryIdDTO.getId());
    }

    @PostMapping("/update")
    public User updateUser(@RequestBody User userDetails) {
        User user = userService.saveUser(userDetails);
        return user;
    }

    @PostMapping("/del")
    public ResponseEntity<?> deleteuser(@RequestBody QueryIdDTO queryIdDTO) {
        userService.deleteuserById(queryIdDTO.getId());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginDTO loginDTO) {
        System.out.println("loginDTO"+loginDTO);
        return userService.login(loginDTO);
    }

}
