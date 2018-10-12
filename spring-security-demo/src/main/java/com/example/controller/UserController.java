package com.example.controller;

import com.example.dto.User;
import com.example.dto.UserQueryCondition;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/official")
public class UserController {
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> query(UserQueryCondition userQueryCondition, @PageableDefault(page = 2, size = 17, sort = {
            "username" }, direction = Sort.Direction.DESC) Pageable pageable) {
        System.out.println(userQueryCondition);
        System.out.println(pageable);
        List<User> userList = new ArrayList<>();
        userList.add(new User("user1", "pwd1"));
        userList.add(new User("user2", "pwd2"));
        userList.add(new User("user3", "pwd3"));
        return userList;
    }
}
