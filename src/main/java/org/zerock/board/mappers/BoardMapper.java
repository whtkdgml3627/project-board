package org.zerock.board.mappers;

import java.util.List;

import org.zerock.board.dto.BoardDTO;

public interface BoardMapper {
  
  //게시판 목록
  List<BoardDTO> BoardList();

}
