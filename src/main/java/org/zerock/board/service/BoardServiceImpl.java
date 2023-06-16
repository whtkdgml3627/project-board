package org.zerock.board.service;

/*
 * BoardService implements
 * Service 어노테이션
 */
import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.mappers.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

  //mapper
  private final BoardMapper boardMapper;

  //게시판 목록 List타입
  @Override
  public List<BoardDTO> boardList() {
    List<BoardDTO> boardList = boardMapper.BoardList();
    return boardList;
  }
  
}
