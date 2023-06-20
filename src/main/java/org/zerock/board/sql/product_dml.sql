create table tbl_product (
	pno int auto_increment primary key,
	pname varchar(500) not null,
	price int default 0,
	status boolean default true,
	regDate timestamp default now(),
	modDate timestamp default now()
)
;

insert into tbl_product (pname, price) values ('상품', 1000)
;

select * from tbl_product
where pno > 0
order by pno desc
limit 50
;

insert into tbl_product (pname, price)
(select pname, price from tbl_product)
;

select count(*) from tbl_product;

update tbl_product
set
	pname = concat(pname, pno)	
where pno > 0
;

update tbl_product
set
	price = price * mod(pno,10)
where pno > 0
;

##1652, 1651, 1650, 1649, 1648

create table tbl_product_image (
	uuid varchar(50) primary key,
	filename varchar(200) not null,
	pno int not null,
	ord int default 0
)
;

select * from tbl_product_image;

select uuid();

insert into tbl_product_image (uuid, filename, pno, ord) values (uuid(), 'f1.jpg', 1652, 0);
insert into tbl_product_image (uuid, filename, pno, ord) values (uuid(), 'f2.jpg', 1652, 1);

insert into tbl_product_image (uuid, filename, pno, ord) values (uuid(), 'f1.jpg', 1651, 0);
insert into tbl_product_image (uuid, filename, pno, ord) values (uuid(), 'f2.jpg', 1651, 1);


##리스트
##컬럼은 한줄에 5개씩 선언
select
	p.pno, p.pname, p.price, p.status, concat(pi.uuid,'_',pi.filename) fileName
from tbl_product p
left outer join tbl_product_image pi on pi.pno = p.pno
where pi.ord = 0 or pi.ord is null
order by p.pno desc
limit 0, 10
;

select *
from
	(select * from tbl_product p where p.pno > 0 order by p.pno desc limit 0, 10) p1
left outer join tbl_product_image pi on pi.pno = p1.pno
where pi.ord = 0 or pi.ord is null
order by p1.pno desc
limit 0, 10
;

##조회
##테이블중 많은 컬럼이 있는 테이블을 앞에 사용해서 select join 해준다
select *
from tbl_product p

create index idx_product_image1 on tbl_product_image (pno desc, ord asc);

select * from tbl_product_image where pno = 2036;


