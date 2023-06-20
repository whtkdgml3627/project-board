create table tbl_reply (
	rno int auto_increment primary key,
	bno int not null,
	reply varchar(1000) not null,
	replyer varchar(100) not null,
	replyDate timestamp default now(),
	gno int default 0,
	foreign key (bno) references tbl_board(bno)
)
;

select * from tbl_reply where rno > 0 order by rno desc, gno asc;

##rno, gno 인덱스 설정
create index idx_tbl_reply1 on tbl_reply (bno desc, rno asc);