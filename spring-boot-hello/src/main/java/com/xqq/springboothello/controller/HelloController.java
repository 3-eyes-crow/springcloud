package com.xqq.springboothello.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: xqq
 * @Date: 2018/10/4 16:44
 * @Description:
 */
@RestController
@Slf4j
public class HelloController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        client.getServices().forEach(id ->
                client.getInstances(id).forEach(instance -> log.info("/hello, host:" + instance.getHost() + ", service_id:" +
                        instance.getServiceId())));
        return "hello";
    }
}
