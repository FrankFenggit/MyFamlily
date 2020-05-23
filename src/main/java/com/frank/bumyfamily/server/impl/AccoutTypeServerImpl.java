package com.frank.bumyfamily.server.impl;

import com.frank.bumyfamily.dao.AccoutTypePoMapper;
import com.frank.bumyfamily.entity.AccoutTypePo;
import com.frank.bumyfamily.server.AccoutTypeServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "accoutType")
public class AccoutTypeServerImpl implements AccoutTypeServer {
    @Autowired
    private AccoutTypePoMapper typeMapper;

    @Override
    public List<AccoutTypePo> getAccoutType() {
        return typeMapper.selectAll();
    }
}
