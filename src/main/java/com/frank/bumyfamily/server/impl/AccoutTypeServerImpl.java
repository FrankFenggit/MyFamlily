package com.frank.bumyfamily.server.impl;

import com.frank.bumyfamily.dao.AccoutTypePoMapper;
import com.frank.bumyfamily.entity.AccoutTypePo;
import com.frank.bumyfamily.server.AccoutTypeServer;
import com.frank.bumyfamily.vo.AccoutTypeVo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;
import org.slf4j.Logger;
import java.util.stream.Collectors;

@Service(value = "accoutType")
public class AccoutTypeServerImpl implements AccoutTypeServer {
    @Autowired
    private AccoutTypePoMapper typeMapper;
    // 数据库查出来的
    private List<AccoutTypePo> accoutTypePos;
    //  List<AccoutTypePo> 位置映射 便于查找
    private HashMap<Integer, Integer> accoutTypeVoHashMap;
    // 分级菜单
    private List<AccoutTypeVo> m_treelist;

    private  static final Logger logger = LoggerFactory.getLogger(AccoutTypeServerImpl.class);

    @Override
    public List<AccoutTypeVo> getAccoutType() {
        logger.info("getAccoutType beg");
        if(m_treelist != null) { // 使用缓存
            logger.info("m_treelist != null");
            logger.info("getAccoutType end");
            return  m_treelist;
        }

        logger.info("m_treelist == null");
        accoutTypePos = typeMapper.selectAll();
        accoutTypeVoHashMap = new HashMap<Integer, Integer>();
        // 一级分类
        HashMap<Integer, Integer> headHashMap = new HashMap<Integer, Integer>();
        int count = -1; // 从0开始
        for (AccoutTypePo item : accoutTypePos) {
            count++;
            if (item.getKeyId() < 100) {
                if (!headHashMap.containsKey(item.getKeyId())) {
                    headHashMap.put(item.getKeyId(), count);
                }
            }

            if (accoutTypeVoHashMap.containsKey(item.getKeyId())) {
                continue;
            }
            accoutTypeVoHashMap.put(item.getKeyId(), count);
        }

        // 构建treelist
        m_treelist = new ArrayList<>();
        headHashMap.forEach((key, value) -> {
            AccoutTypeVo accoutTypeVo = new AccoutTypeVo();
            accoutTypeVo.setKeyId(key);
            accoutTypeVo.setType(accoutTypePos.get(value).getType());
            findChild(accoutTypeVo);
            m_treelist.add(accoutTypeVo);
        });

        logger.info("getAccoutType end");

        return m_treelist;
    }

    private void findChild(AccoutTypeVo accoutTypeVo) {
        Integer pos = accoutTypeVoHashMap.get(accoutTypeVo.getKeyId());
        if(pos == null) {
            return;
        }
        String sonId = accoutTypePos.get(pos).getSonId();
        if (sonId == null || sonId.isEmpty()) {
            accoutTypeVo.setClild(new ArrayList<>());
            return;
        }
        // clild 还是要初始化的
        if(accoutTypeVo.getClild() == null) {
            accoutTypeVo.setClild(new ArrayList<>());
        }
        List<Integer> sonIDLst = Arrays.asList(sonId.split(",")).stream().
                map(s -> Integer.parseInt(s.trim())).
                collect(Collectors.toList());
        sonIDLst.forEach(item -> {
            Integer postmp = accoutTypeVoHashMap.get(item);
            if (postmp == null) {
                return;
            }
            AccoutTypePo accoutTypePo = accoutTypePos.get(postmp);
            if (accoutTypePo != null) {
                AccoutTypeVo accoutTypeVo1 = new AccoutTypeVo();
                accoutTypeVo1.setKeyId(accoutTypePo.getKeyId());
                accoutTypeVo1.setType(accoutTypePo.getType());
                findChild(accoutTypeVo1);
                accoutTypeVo.getClild().add(accoutTypeVo1);
            }
        });
    }

}
