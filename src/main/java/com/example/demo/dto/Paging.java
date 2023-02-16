package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paging {
    
    private int thisPage; // 현재 페이지 -> url 파라미터로 받아오기 원래는 앞단에서 클릭시 버튼에 있는 숫자 값을 form으로 넘겨받겠지만
    private int totalPage; // 전체 페이지 수
    private int boardNumToShow = 10; // 보여질 게시물 데이터 개수 -> 10개
    private int pageNumToShow; // 보여질 페이지 번호 개수
    private int totalRows; // 전체 데이터 개수
    private int startRowNumToShow; // 쿼리문에서 사용될 offset : 몇번째 row부터 보여줄지 -> 0, 10 ,20, 30 이렇게 갈거니까 현재 페이지 * 10

    public void setParamsPaging(int totalRows, int thisPage) {
        this.totalRows = totalRows;
        this.pageNumToShow = totalRows / boardNumToShow;
        if(totalRows % boardNumToShow != 0) {
            pageNumToShow += 1;
        }
        totalPage = pageNumToShow;
        this.thisPage = thisPage;
        if(thisPage > totalPage) {
            setThisPage(getTotalPage());
        }
        if(thisPage == 1 ) {
            setStartRowNumToShow(0);
        } else {
            setStartRowNumToShow(boardNumToShow * (thisPage - 1));
            if(startRowNumToShow > totalRows) {
                setStartRowNumToShow(boardNumToShow * (this.thisPage - 1));
            }
        }
    }
}
