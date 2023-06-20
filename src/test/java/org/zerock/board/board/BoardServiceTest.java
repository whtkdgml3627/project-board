package org.zerock.board.board;
/*
 * Service 로직 테스트
 */

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.service.BoardService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardServiceTest {

  @Autowired(required = false)
  private BoardService boardService;

  //게시판 목록 서비스
  @Test
  public void boardListServiceTest() {
    PageRequestDTO prList = PageRequestDTO.builder().build();

    log.info("====================================");
    log.info("====================================");
    log.info(boardService.boardList(prList));
  }

  //게시판 등록 서비스
  @Test
  public void boardAddServiceTest() {
    BoardDTO boardDTO = BoardDTO.builder()
    .title("등록 서비스 테스트")
    .content("등록 상세 서비스 테스트")
    .writer("등록 작성자 서비스 테스트")
    .build();

    log.info("====================================");
    log.info("====================================");
    boardService.boardAdd(boardDTO);
  }

  //게시판 상세 서비스
  @Test
  public void boardDetailServiceTest() {
    log.info("====================================");
    log.info("====================================");
    log.info(boardService.boardDetail(720881));
  }

  //게시판 삭제 테스트
  @Test
  public void boardRemoveServiceTest() {
    log.info("====================================");
    log.info("====================================");
    log.info(boardService.boardRemove(720883));
  }

  //게시판 수정 테스트
  @Test
  public void boardModifyServiceTest() {
    BoardDTO boardDTO = BoardDTO.builder()
    .title("수정 서비스")
    .content("서비스 수정")
    .writer("작성자 서비스")
    .build();

    log.info("====================================");
    log.info("====================================");
    log.info(boardService.boardModify(boardDTO, 720887));

  }
  
}
