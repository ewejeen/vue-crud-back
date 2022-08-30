package com.example.board.service;

import com.example.board.mapper.BoardMapper;
import com.example.board.vo.BoardVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yoojinkim
 */
@Service
public class BoardService  {

    @Resource
    BoardMapper boardMapper;

    public int selectBoardListCnt(BoardVO vo) {
        return boardMapper.selectBoardListCnt(vo);
    }

    public List<BoardVO> selectBoardList(BoardVO vo) {
        return boardMapper.selectBoardList(vo);
    }

    /**
     * 게시판 상세
     */
    public BoardVO selectBoardDetail(BoardVO vo) {
        BoardVO board = boardMapper.selectBoardDetail(vo);

        if(vo.getPageIndex() != 0) {
            board.setPageIndex(vo.getPageIndex());
        }
        if(vo.getSearchKeyword() != null) {
            board.setSearchKeyword(vo.getSearchKeyword());
        }
        if(vo.getSearchCondition() != null) {
            board.setSearchCondition(vo.getSearchCondition());
        }

        return board;
    }

    /**
     * 게시글 등록
     */
    public void writeBoard(BoardVO vo) {
        vo.setIdxno(boardMapper.selectMaxIdxNo(vo) + 1);
        vo.setRegisterId(Integer.toString(49));
        vo.setRegisterName("개발자");

        boardMapper.writeBoard(vo);
    }

    /**
     * 게시글 수정
     */
    public int modifyBoard(BoardVO vo) {
        return boardMapper.modifyBoard(vo);
    }

    /**
     * 게시글 삭제
     */
    public int deleteBoard(BoardVO vo) {
        return boardMapper.deleteBoard(vo);
    }
}
