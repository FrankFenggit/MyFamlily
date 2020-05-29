package com.frank.bumyfamily.vo;

import lombok.Data;

import java.util.List;

@Data
public class AccoutTypeVo {
    private Integer keyId;

    private String type;

    List<AccoutTypeVo> clild;
}
