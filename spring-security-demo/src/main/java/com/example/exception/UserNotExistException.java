package com.example.exception;

import com.example.dto.User;

public class UserNotExistException extends RuntimeException {
    private User user;

    public UserNotExistException(User user) {
        super("自定义异常程序报错了");
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
