package com.example.demo.dto;

import java.time.LocalDateTime;

public class Board {

    private Integer board_seq;
    private String writer;
    private String contents;
    private LocalDateTime createDate;

    public Integer getBoard_seq() {
        return board_seq;
    }

    public void setBoard_seq(Integer board_seq) {
        this.board_seq = board_seq;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}
