
package com.example.service.impl;

import com.example.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String greeting(String name) {
        System.out.println("进入service");
        return name;
    }

}
