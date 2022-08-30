package com.example.board.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper=false)
public class BoardVO extends BaseVO {
    private int section;
    private int idxno;
    private String title;
    private String contents;
    private String registerId;
    private String registerName;
    private Date registerDate;
    private String attach;
    private int refer;
    private int step;
    private int depth;
    private String delFlag;
    private String sDate;
    private String sDateYear;
    private String sDateMonth;
    private String sDateFormat;
    private int hitCount;
    private String ip;
    private String displayYn;
}
