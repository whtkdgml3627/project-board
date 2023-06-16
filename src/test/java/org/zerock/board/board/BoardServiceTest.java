package org.zerock.board.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.service.BoardService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardServiceTest {

  @Autowired(required = false)
  private BoardService boardService;

  //게시판 목록 서비스
  @Test
  public void boardList(){
    List<BoardDTO> list = boardService.boardList();

    log.info("====================================");
    log.info("====================================");
    log.info(list);
  }
  
}
