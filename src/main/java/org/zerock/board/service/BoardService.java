package org.zerock.board.service;

/*
 * 서비스 인터페이스 선언
 * 트랜잭션 처리 추가
 */
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.zerock.board.dto.BoardDTO;

@Transactional
public interface BoardService {
  
  //게시판 목록
  List<BoardDTO> boardList();

}
