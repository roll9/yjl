package com.mate.biz.controller;


import com.mate.biz.service.BarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bar")
public class BarController {


    private static final Logger logger = LoggerFactory.getLogger(BarController.class);

    @Autowired
    private BarService barService;

    /**
     *
     */



}
