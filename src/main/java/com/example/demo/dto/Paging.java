package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paging {

    private int currentPage;
    private int totalPage;
    private int boardNumToShow;
    private int totalRows;
    private int startRowNumToShow;

    public void setParamsPaging(int totalRows) {
        if(currentPage == 0){ this.currentPage = 1; }
        this.boardNumToShow = 10;
        this.totalRows = totalRows;
        this.totalPage = totalRows % boardNumToShow == 0 ? totalRows / boardNumToShow : totalRows / boardNumToShow +1;
        this.startRowNumToShow = boardNumToShow * (currentPage-1);
    }
}