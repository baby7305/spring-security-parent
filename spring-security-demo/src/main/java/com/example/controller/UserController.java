package com.example.controller;

import com.example.dto.User;
import com.example.dto.UserQueryCondition;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/official/user")
public class UserController {

    @PostMapping
    public User create(@RequestBody User user) {
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id) {
        System.out.println(id);
    }

    @GetMapping
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

    @GetMapping("/{id:\\d+}")
    public User getInfo(@PathVariable(name = "id") Long idxxx) {
        System.out.println("进入getInfo服务");
        System.out.println(idxxx);
        User user = new User();
        user.setUsername("tom");
        System.out.println(user);
        return user;
    }
}
