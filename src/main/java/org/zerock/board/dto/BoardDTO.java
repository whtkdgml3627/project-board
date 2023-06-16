package org.zerock.board.dto;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BoardDTO {

  //변수
  private int bno;            //게시물번호 pk
  private String title;       //제목
  private String content;     //내용
  private String writer;      //작성자
  private String dueDate;     //등록일자
  private String updateDate;  //수정일자
  
}
