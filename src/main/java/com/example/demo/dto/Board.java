package com.example.demo.dto;

import java.time.LocalDateTime;

public class Board {

    private Integer bdSeq;
    private String bdWriter;
    private String bdTitle;
    private String bdContents;
    private String bdCreateDate;


    public Integer getBdSeq() {
        return bdSeq;
    }

    public void setBdSeq(Integer bdSeq) {
        this.bdSeq = bdSeq;
    }

    public String getBdWriter() {
        return bdWriter;
    }

    public void setBdWriter(String bdWriter) {
        this.bdWriter = bdWriter;
    }

    public String getBdTitle() {
        return bdTitle;
    }

    public void setBdTitle(String bdTitle) {
        this.bdTitle = bdTitle;
    }

    public String getBdContents() {
        return bdContents;
    }

    public void setBdContents(String bdContents) {
        this.bdContents = bdContents;
    }

    public String getBdCreateDate() {
        return bdCreateDate;
    }

    public void setBdCreateDate(String bdCreateDate) {
        this.bdCreateDate = bdCreateDate;
    }
}
