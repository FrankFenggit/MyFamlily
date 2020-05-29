package com.frank.bumyfamily.controller;

import com.frank.bumyfamily.entity.AccoutTypePo;
import com.frank.bumyfamily.server.AccoutTypeServer;
import com.frank.bumyfamily.vo.AccoutTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccoutTypeController {

    @Autowired
    private AccoutTypeServer typeServer;

    @GetMapping("/accoutType")
    public List<AccoutTypeVo> getAccoutType() {
        return typeServer.getAccoutType();
    }
}
