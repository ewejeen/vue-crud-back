package com.example.common.config;

public class PagingUtil {

	private int pageSize;		// 게시 글 수
	private int firstPageNo;	// 첫 번째 페이지 번호
	private int prevPageNo;		// 이전 페이지 번호
	private int startPageNo;	// 시작 페이지 (페이징 네비 기준)
	private int pageNo;			// 현재 페이지 번호

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getFirstPageNo() {
		return firstPageNo;
	}

	public void setFirstPageNo(int firstPageNo) {
		this.firstPageNo = firstPageNo;
	}

	public int getPrevPageNo() {
		return prevPageNo;
	}

	public void setPrevPageNo(int prevPageNo) {
		this.prevPageNo = prevPageNo;
	}

	public int getStartPageNo() {
		return startPageNo;
	}

	public void setStartPageNo(int startPageNo) {
		this.startPageNo = startPageNo;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	private int endPageNo;		// 끝 페이지 (페이징 네비 기준)
	private int nextPageNo;		// 다음 페이지 번호
	private int finalPageNo;	// 마지막 페이지 번호
	private int totalCount;		// 게시 글 전체 수
	
	public int getEndPageNo() {
		return endPageNo;
	}

	public void setEndPageNo(int endPageNo) {
		this.endPageNo = endPageNo;
	}

	public int getNextPageNo() {
		return nextPageNo;
	}

	public void setNextPageNo(int nextPageNo) {
		this.nextPageNo = nextPageNo;
	}

	public int getFinalPageNo() {
		return finalPageNo;
	}

	public void setFinalPageNo(int finalPageNo) {
		this.finalPageNo = finalPageNo;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.makePaging();
	}

	private int blockSize; 		// 페이지 번호 링크 개수
	private int startRowNum;	// 게시글 조회 쿼리에 들어갈 row 시작점
	private int endRowNum;		// 게시글 조회 쿼리에 들어갈 row 끝점
	
	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public int getStartRowNum() {
		return startRowNum;
	}

	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}

	public int getEndRowNum() {
		return endRowNum;
	}

	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}

	
	// 페이지 정보 계산
	public void makePaging() {
		if (totalCount == 0) {
			return; // 게시글 전체 수가 없는 경우
		}
		// pageNo가 0일 경우 기본값 1 설정
		if (pageNo == 0) {
			setPageNo(1);
		}
		// pageSize 가 0일 경우 기본값 설정
		if (pageSize == 0) {
			setPageSize(10);
		}

		if (blockSize == 0) {
			setBlockSize(10);
		}

		int finalPage = (totalCount + (pageSize - 1)) / pageSize; // 마지막 페이지 계산

		// 마지막 페이지 보다 현재 페이지번호가 클 경우 마지막 페이지 번호 설정
		if (pageNo > finalPage) {
			setPageNo(finalPage);
		}

		// 현재 페이지 유효성 체크
		if (pageNo < 0 || pageNo > finalPage) {
			pageNo = 1;
		}

		boolean isNowFirst = pageNo == 1 ? true : false;			// 시작 페이지 (전체)
		boolean isNowFinal = pageNo == finalPage ? true : false;	// 마지막 페이지 (전체)

		int startPage = ((pageNo - 1) / blockSize) * blockSize + 1; // 시작 페이지 (페이징 네비 기준)
		int endPage = startPage + blockSize - 1; // 끝 페이지 (페이징 네비 기준)

		// [마지막 페이지 (페이징 네비 기준) > 마지막 페이지]보다 큰 경우
		if (endPage > finalPage) {
			endPage = finalPage;
		}

		setFirstPageNo(1);	// 첫 번째 페이지 번호

		if (isNowFirst) {			//시작페이지 일 경우 이전 페이지 번호 초기
			setPrevPageNo(1);
		} else {
			setPrevPageNo(((pageNo - 1) < 1 ? 1 : (pageNo - 1))); // 이전 페이지 번호 계
		}

		setStartPageNo(startPage);	// 시작 페이지 (페이징 네비 기준)
		setEndPageNo(endPage);		// 끝 페이지 (페이징 네비 기준)

		if (isNowFinal) {
			setNextPageNo(finalPage); // 마지막 페이지번호 일 경우 마지막페이지 번호 설정
		} else {
			setNextPageNo(((pageNo + 1) > finalPage ? finalPage : (pageNo + 1))); // 다음 페이지 번호
		}

		setFinalPageNo(finalPage); // 마지막 페이지 번호

		//setEndRowNum(totalCount - ((pageNo-1) * pageSize));
		//setStartRowNum(endRowNum - (pageSize - 1) < 0 ? 0:endRowNum - (pageSize - 1));

		setEndRowNum(pageNo * pageSize);
		setStartRowNum(endRowNum - (pageSize - 1));
	}
}
