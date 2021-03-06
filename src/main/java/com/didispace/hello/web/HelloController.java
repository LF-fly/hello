package com.didispace.hello.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author liufei
 * @date 2018/8/20
 * Copyright Hanboard
 * Created by liufei on 2018/7/30.
 */

@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(getClass());

    private final DiscoveryClient client;

    @Autowired
    public HelloController(DiscoveryClient client) {
        this.client = client;
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index(){
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello,host:"+instance.getHost()+",service_id:"+instance.getServiceId());
        return "Hello World";
    }
}
