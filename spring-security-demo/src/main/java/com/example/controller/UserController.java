package com.example.controller;

import com.example.dto.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/official")
public class UserController {
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> query(@RequestParam(value = "username") String nickname) {
        System.out.println(nickname);
        List<User> userList = new ArrayList<>();
        userList.add(new User("user1", "pwd1"));
        userList.add(new User("user2", "pwd2"));
        userList.add(new User("user3", "pwd3"));
        return userList;
    }
}
