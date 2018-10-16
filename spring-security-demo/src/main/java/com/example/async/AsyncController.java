package com.example.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
@RequestMapping("/order")
public class AsyncController implements Callable<String> {
    private Logger logger = LoggerFactory.getLogger(AsyncController.class);

    @GetMapping
    public String order() {
        logger.info("主线程开始");
        try {
            this.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("主线程结束");
        return "success";
    }

    @Override
    public String call() throws Exception {
        logger.info("副线程开始");
        Thread.sleep(1000);
        logger.info("副线程返回");
        return "success";
    }
}
