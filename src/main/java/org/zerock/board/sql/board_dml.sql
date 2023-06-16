create table tbl_board (
	bno int auto_increment primary key,
	title varchar(200) not null,
	content varchar(1000) not null,
	writer varchar(100) not null,
	dueDate timestamp default now(),
	updateDate timestamp default now()
)
;

## 조회
select * from tbl_board where bno > 0 order by bno desc
;

select count(*) from tbl_board
;

insert into tbl_board (title, content, writer)
values ('게시판 테스트 제목', '게시판 테스트 상세 내용', '조상희')
;

## 더이데이터 생성
insert into tbl_board (title, content, writer)
select title, content, writer from tbl_board
;

## 더미데이터 수정
update tbl_board
set
	title = concat(title, bno),
	content = concat(content, bno),
	writer = concat(writer, mod(bno, 100))
where bno > 0
;