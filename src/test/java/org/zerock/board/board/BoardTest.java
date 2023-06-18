package org.zerock.board.board;
/*
 * DAO 로직 테스트
 */

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.dto.BoardDTO;
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
  public void boardListTest() {
    PageRequestDTO list = PageRequestDTO.builder().build(); // 0, 10 설정

    log.info("====================================");
    log.info("====================================");
    //PageRequestDTO로 가져온 값을 for문으로 출력
    boardMapper.boardList(list)
    .forEach(dto -> log.info(dto)); //람다식

    //total 가져오기
    boardMapper.listCount(list);
  }

  //게시판 등록 테스트
  @Test
  public void boardAddTest() {
    BoardDTO boardDTO = BoardDTO.builder()
    .title("게시판 등록 DAO테스트")
    .content("게시판 등록 상세 DAO테스트")
    .writer("게시판 등록 작성자 DAO테스트")
    .build();

    log.info("====================================");
    log.info("====================================");
    boardMapper.boardAdd(boardDTO);
  }

  //게시판 상세 테스트
  @Test
  public void boardDetailTest() {

    log.info("====================================");
    log.info("====================================");
    log.info(boardMapper.boardDetail(720811L));
  }

  //게시판 삭제 테스트
  @Test
  public void boardRemoveTest() {
    log.info("====================================");
    log.info("====================================");
    log.info(boardMapper.boardRemove(720884L));
  }
  
}
