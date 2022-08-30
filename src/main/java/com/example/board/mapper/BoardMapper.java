package com.example.board.mapper;

import com.example.board.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yoojinkim
 */
@Mapper
public interface BoardMapper {
    /**
     * 게시글 총 개수
     * @param vo 검색 조건
     * @return 게시글 총 개수
     */
    int selectBoardListCnt(BoardVO vo);

    /**
     * 게시글 목록
     * @param vo 검색 조건
     * @return 게시글 목록
     */
    List<BoardVO> selectBoardList(BoardVO vo);

    /**
     * 게시글 상세 정보
     * @param vo idx no 등 검색 조건
     * @return 게시글 상세 정보
     */
    BoardVO selectBoardDetail(BoardVO vo);

    /**
     * MAX IDX NO값 반환
     * @param vo vo
     * @return max idx
     */
    int selectMaxIdxNo(BoardVO vo);

    /**
     * 게시글 등록
     * @param vo 등록할 내용
     */
    void writeBoard(BoardVO vo);

    /**
     * 게시글 수정
     * @param vo 수정할 내용
     * @return 수정 결과
     */
    int modifyBoard(BoardVO vo);

    /**
     * 게시글 삭제
     * @param vo 삭제할 게시글 정보
     * @return 삭제 결과
     */
    int deleteBoard(BoardVO vo);
}
