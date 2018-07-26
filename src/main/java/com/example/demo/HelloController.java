package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by zm on 2018/7/26.
 */
@RestController
public class HelloController {

    private Logger logger = LogManager.getLogger(HelloController.class.getName());

    @GetMapping("/hello")
    public String hello(){
        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");
        logger.fatal("fatal level");
        return "hello world";
    }

}
