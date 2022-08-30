package com.example.board.controller;

import com.example.board.service.BoardService;
import com.example.board.vo.BoardVO;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.common.config.PaginationInfo;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yoojinkim
 */
@RestController
public class BoardController {

    @Resource
    BoardService boardService;

    /**
     * 게시글 목록 조회
     */
    @GetMapping(value="/board/getList")
    public @ResponseBody JSONObject selectBoardList(BoardVO boardVO) {
        boardVO.setSection(7);
        boardVO.setPageUnit(10);
        boardVO.setPageSize(10);

        PaginationInfo paginationInfo = new PaginationInfo();

        paginationInfo.setCurrentPageNo(boardVO.getPageIndex());
        paginationInfo.setRecordCountPerPage(boardVO.getPageUnit());
        paginationInfo.setPageSize(boardVO.getPageSize());

        boardVO.setFirstIndex(paginationInfo.getFirstRecordIndex()+1);
        boardVO.setLastIndex(paginationInfo.getLastRecordIndex());
        boardVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

        List<BoardVO> list = boardService.selectBoardList(boardVO);
        int totalCnt = boardService.selectBoardListCnt(boardVO);

        paginationInfo.setTotalRecordCount(totalCnt);

        JSONObject json = new JSONObject();
        json.put("list",list);
        json.put("paging",paginationInfo);
        json.put("boardVO",boardVO);
        return json;
    }

    /**
     * 게시글 상세 조회
     */
    @RequestMapping("/board/view")
    public BoardVO boardDetail(BoardVO vo) {
        return boardService.selectBoardDetail(vo);
    }

    /**
     * 등록 페이지로 이동
     */
    @RequestMapping("/board/write")
    public String goWrite() {
        return "/write";
    }

    /**
     * 게시글 등록
     */
    @RequestMapping("/board/insert")
    public @ResponseBody int writeBoard(BoardVO vo)  {
        boardService.writeBoard(vo);
        return 1;
    }

    /**
     * 수정 페이지로 이동
     */
    @RequestMapping("/board/modify")
    public String goModify(BoardVO vo, Model model) {
        model.addAttribute("board", boardService.selectBoardDetail(vo));
        return "/write";
    }

    /**
     * 게시글 수정
     */
    @RequestMapping("/board/update")
    public @ResponseBody int modifyBoard(BoardVO vo) {
        return boardService.modifyBoard(vo);
    }

    /**
     * 게시글 삭제
     */
    @RequestMapping("/board/delete")
    public @ResponseBody int deleteBoard(BoardVO vo) {
        return boardService.deleteBoard(vo);
    }
}
