package org.zerock.board.board;
/*
 * DAO 로직 테스트
 */

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.mappers.BoardMapper;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardTest {

  @Autowired(required = false)
  private BoardMapper boardMapper;

  //게시판 목록 테스트
  @Test
  public void boardListTest(){
    PageRequestDTO list = PageRequestDTO.builder().build(); // 0, 10 설정

    log.info("====================================");
    log.info("====================================");
    //PageRequestDTO로 가져온 값을 for문으로 출력
    boardMapper.boardList(list)
    .forEach(dto -> log.info(dto)); //람다식

    //total 가져오기
    boardMapper.listCount(list);
  }
  
}
