package com.example.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class AsyncController {
    private Logger logger = LoggerFactory.getLogger(AsyncController.class);

    @GetMapping
    public String order() {
        logger.info("主线程开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("主线程结束");
        return "success";
    }

}
