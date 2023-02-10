package com.example.demo.dto;

public class Comments {

    private Integer cmSeq;
    private Integer cm_mmSeq;
    private Integer cm_bdSeq;
    private String cmContents;
    private String cmCreatDate;


    public Integer getCmSeq() {
        return cmSeq;
    }

    public void setCmSeq(Integer cmSeq) {
        this.cmSeq = cmSeq;
    }

    public Integer getCm_mmSeq() {
        return cm_mmSeq;
    }

    public void setCm_mmSeq(Integer cm_mmSeq) {
        this.cm_mmSeq = cm_mmSeq;
    }

    public String getCmContents() {
        return cmContents;
    }

    public void setCmContents(String cmContents) {
        this.cmContents = cmContents;
    }

    public String getCmCreatDate() {
        return cmCreatDate;
    }

    public void setCmCreatDate(String cmCreatDate) {
        this.cmCreatDate = cmCreatDate;
    }

    public Integer getCm_bdSeq() {
        return cm_bdSeq;
    }

    public void setCm_bdSeq(Integer cm_bdSeq) {
        this.cm_bdSeq = cm_bdSeq;
    }
}
