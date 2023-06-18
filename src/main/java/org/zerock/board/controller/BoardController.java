package org.zerock.board.controller;
/*
 * board Controller
 * Service 선언 후 주입
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.board.dto.BoardDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResponseDTO;
import org.zerock.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/board/")
@RequiredArgsConstructor
@Log4j2
public class BoardController {

  private final BoardService boardService;

  //게시판 목록
  //Model에 담아서 view에서 출력
  @GetMapping("list")
  public void boardList(PageRequestDTO pageRequestDTO, Model model) {
    log.info("get | list.........................");
    //list 생성
    PageResponseDTO<BoardDTO> list = boardService.boardList(pageRequestDTO);

    //model로 전달
    model.addAttribute("boardList", list);
  }

  //게시판 등록
  //get
  @GetMapping("add")
  public void boardAddGet() {
    log.info("get | add.........................");
  }

  //post
  @PostMapping("add")
  public String boardAddPost(BoardDTO boardDTO) {
    //등록
    boardService.boardAdd(boardDTO);
    return "redirect:/board/list";
  }
  // /게시판 등록

  //게시판 상세
  @GetMapping("detail/{bno}")
  public String boardDetail(
    @PathVariable("bno") long bno, Model model
  ) {
    log.info("get | detail.........................");
    //bno찾기
    BoardDTO dto = boardService.boardDetail(bno);
    //model로 전달
    model.addAttribute("boardDetail", dto);

    return "/board/detail";
  }
  
}
