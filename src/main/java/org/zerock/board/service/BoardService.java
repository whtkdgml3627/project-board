package org.zerock.board.service;

/*
 * 서비스 인터페이스 선언
 * 트랜잭션 처리 추가
 * 페이징 처리르 위해 List를 PageResponseDTO
 */

import org.springframework.transaction.annotation.Transactional;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResponseDTO;

@Transactional
public interface BoardService {
  
  //게시판 목록
  PageResponseDTO<BoardDTO> boardList(PageRequestDTO pageRequestDTO);

  //게시판 등록
  int boardAdd(BoardDTO boardDTO);

  //게시판 상세
  BoardDTO boardDetail(int bno);

  //게시판 삭제
  int boardRemove(int bno);

  //게시판 수정
  int boardModify(BoardDTO boardDTO, int bno);

}
