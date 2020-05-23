package com.frank.bumyfamily.controller;

import com.frank.bumyfamily.entity.AccoutTypePo;
import com.frank.bumyfamily.server.AccoutTypeServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccoutTypeController {

    @Autowired
    private AccoutTypeServer typeServer;

    @GetMapping("/accoutType")
    public List<AccoutTypePo> getAccoutType() {
        return typeServer.getAccoutType();
    }
}
