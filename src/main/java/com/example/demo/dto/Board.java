package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class Board {

    private Integer boardSeq;
    private String writer;
    private String title;
    private String contents;
    private String createDate;
}
