package com.frank.bumyfamily.entity;

import java.util.Date;

public class AccoutTypePo {
    private Integer id;

    private Integer keyId;

    private String type;

    private String sonId;

    private Date submissionData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getSonId() {
        return sonId;
    }

    public void setSonId(String sonId) {
        this.sonId = sonId == null ? null : sonId.trim();
    }

    public Date getSubmissionData() {
        return submissionData;
    }

    public void setSubmissionData(Date submissionData) {
        this.submissionData = submissionData;
    }
}