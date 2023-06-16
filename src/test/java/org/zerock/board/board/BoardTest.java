package org.zerock.board.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.mappers.BoardMapper;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardTest {

  @Autowired(required = false)
  private BoardMapper boardMapper;

  //리스트 테스트
  @Test
  public void boardListTest(){
    List<BoardDTO> list = boardMapper.BoardList();
    log.info("====================================");
    log.info("====================================");
    log.info(list);
  }
  
}
