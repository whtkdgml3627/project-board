package org.zerock.board.service;
/*
 * BoardService implements
 * Service 어노테이션
 */

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResponseDTO;
import org.zerock.board.mappers.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

  //mapper
  private final BoardMapper boardMapper;

  //게시판 목록 List타입
  @Override
  public PageResponseDTO<BoardDTO> boardList(PageRequestDTO pageRequestDTO) {
    //리스트 담아주기
    List<BoardDTO> boardList = boardMapper.boardList(pageRequestDTO);

    //total 담아주기
    long total = boardMapper.listCount(pageRequestDTO);
    
    //return타입을 선언해주고 build로 담아주기
    return PageResponseDTO.<BoardDTO>withAll()
      .list(boardList).total(total).build();
  }

  //게시판 등록
  @Override
  public int boardAdd(BoardDTO boardDTO) {
    //리턴에 바로 값 넘겨주기
    return boardMapper.boardAdd(boardDTO);
  }
  
}
