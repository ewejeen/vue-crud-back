package com.example.board.vo;

import lombok.Data;

@Data
public class BaseVO {

    /** 검색조건 */
    private String searchCondition;

    /** 검색Keyword */
    private String searchKeyword;

    /** 검색사용여부 */
    private String searchUseYn;

    /** 검색조건(select)*/
    private String searchValue;

    /** 검색조건(select)*/
    private String searchValue2;

    /** 검색조건(select)*/
    private String searchValue3;

    /** 현재페이지 */
    private int pageIndex = 1;

    /** 페이지갯수 */
    private int pageUnit = 10;

    /** 페이지사이즈 */
    private int pageSize = 10;

    /** firstIndex */
    private int firstIndex = 1;

    /** lastIndex */
    private int lastIndex = 1;

    /** recordCountPerPage */
    private int recordCountPerPage = 10;

}
