create table tbl_board (
	bno int auto_increment primary key,
	title varchar(200) not null,
	content varchar(1000) not null,
	writer varchar(100) not null,
	dueDate timestamp default now(),
	updateDate timestamp default now()
)
;

##삭제컬럼추가
alter table tbl_board add `status` boolean default true after `updateDate`
;

##댓글 갯수컬럼 추가
alter table tbl_board add column (replycnt int default 0)
;

##조회
select * from tbl_board where bno > 0 order by bno desc limit 10
;

select count(*) from tbl_board
;

insert into tbl_board (title, content, writer)
values ('게시판 테스트 제목', '게시판 테스트 상세 내용', '조상희')
;

##더이데이터 생성
insert into tbl_board (title, content, writer)
select title, content, writer from tbl_board
;

##더미데이터 수정
update tbl_board
set
	title = concat(title, bno),
	content = concat(content, bno),
	writer = concat(writer, mod(bno, 100))
where bno > 0
;

##게시판 리스트
select title, content, writer, dueDate
from tbl_board
where bno > 0
order by bno desc
limit 0, 10
;

##다음페이지를 위한 count
select count(*)
from
(select bno from tbl_board
where bno > 0
limit 101) board
;

##게시판 등록
insert into tbl_board
(title, content, writer, dueDate)
values ('등록테스트', '등록테스트 상세 내용', '등록테스트 작성자', now())
;

##게시판 상세
select title, content, writer, updateDate
from tbl_board
where bno = 720811
;

##게시판 삭제
update tbl_board
set
	title = '', content = '', writer = '', dueDate = null, updateDate = now(), remove = false
where bno = 720885
;

##게시판 수정
update tbl_board
set
	title = '게시판 수정', content = '게시판 내용 수정', writer = '작성자 수정', updateDate = now()
where bno = 720887
;




