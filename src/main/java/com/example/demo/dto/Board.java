package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class Board {

    private Integer boardSeq;
    @NotBlank(message = "제목 값이 비어있습니다.")
    private String writer;
    @NotBlank(message = "")
    private String title;
    @NotBlank(message = "")
    private String contents;
    @NotBlank(message = "")
    private String createDate;
}
