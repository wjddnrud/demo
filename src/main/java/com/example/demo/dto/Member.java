package com.example.demo.dto;

import java.time.LocalDateTime;

public class Member {

    private Integer mmSeq;
    private String mmName;
    private Integer mmGender;
    private LocalDateTime mmCreateDate;

    public Integer getMmSeq() {
        return mmSeq;
    }

    public void setMmSeq(Integer mmSeq) {
        this.mmSeq = mmSeq;
    }

    public String getMmName() {
        return mmName;
    }

    public void setMmName(String mmName) {
        this.mmName = mmName;
    }

    public Integer getMmGender() {
        return mmGender;
    }

    public void setMmGender(Integer mmGender) {
        this.mmGender = mmGender;
    }

    public LocalDateTime getMmCreateDate() {
        return mmCreateDate;
    }

    public void setMmCreateDate(LocalDateTime mmCreateDate) {
        this.mmCreateDate = mmCreateDate;
    }
}
