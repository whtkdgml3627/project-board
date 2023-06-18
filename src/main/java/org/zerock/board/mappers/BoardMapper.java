package org.zerock.board.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;

public interface BoardMapper {
  
  //게시판 목록
  //mapper에서 참조하기위해 Param으로 선언
  List<BoardDTO> boardList(
    @Param ("pr") PageRequestDTO pageRequestDTO
  );

  //total 가져오기
  long listCount(PageRequestDTO pageRequestDTO);

  // /게시판 목록

  //게시판 등록
  int boardAdd(BoardDTO boardDTO);

  //게시판 상세
  BoardDTO boardDetail(long bno);


}
