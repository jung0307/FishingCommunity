drop table goodAndBad
drop table guestBook
drop table t_freeComment
drop table t_comment
drop table t_imageFile
drop table freeBoard
drop table board
drop table member


create table member(
id varchar2(20) primary key,
pwd varchar2(20) not null,
role varchar2(10) default 'member',
signUpDate date default sysdate
)

create table board(
boardID varchar2(20),
boardNum number(20) primary key,
boardCount number(20) default 0,
boardDate date default sysdate,
boardContent long not null,
fileName varchar2(50),
boardTitle varchar2(100),
commentCount number(20),
upCount number(20) default 0,
constraint boardID_fk foreign key(boardID)
references member(id)
)

alter table board add upCount number(20) default 0

create table freeBoard(
boardID varchar2(20) default 'guest',
boardPwd number not null,
boardNum number(20) primary key,
boardCount number(20) default 0,
boardDate date default sysdate,
boardContent long not null,
fileName varchar2(50),
boardTitle varchar2(100),
commentCount number(20)
)

insert into member values('admin' , 'admin123' , 'admin',sysdate)
insert into board values('admin' , 1 , 0,sysdate,'안녕하세요',null,'관리자입니다',0,0)
insert into freeboard values('guest' ,1234 ,1 , 0,sysdate,'안녕하세요',null,'익명게시판',0)

insert into freeboard values('guest' ,1234 ,5 , 0,sysdate,'안녕하세요5',null,'익명게시판5',0)
insert into freeboard values('guest' ,1234 ,6 , 0,sysdate,'안녕하세요6',null,'익명게시판6',0)
insert into freeboard values('guest' ,1234 ,7 , 0,sysdate,'안녕하세요7',null,'익명게시판7',0)
insert into freeboard values('guest' ,1234 ,8 , 0,sysdate,'안녕하세요8',null,'익명게시판8',0)
insert into freeboard values('guest' ,1234 ,9 , 0,sysdate,'안녕하세요9',null,'익명게시판9',0)
insert into freeboard values('guest' ,1234 ,10 , 0,sysdate,'안녕하세요10',null,'익명게시판10',0)
insert into freeboard values('guest' ,1234 ,11 , 0,sysdate,'안녕하세요11',null,'익명게시판11',0)

create table t_imageFile(
imageFileNo number,
imageFileName varchar2(50),
regDate date default sysdate,
contentNum number,
constraint contentNum_fk foreign key(contentNum)
references board(boardNum) on delete cascade
)

create table t_comment(
commentID varchar2(20) not null,
commentContent varchar2(2000) not null,
commentDate date default sysdate,
commentGroup number(10) not null,
commentHir number(10) default 0,
commentNum number(10) default 0,
boardNum number(20),
CONSTRAINT boardNum_fk foreign key(boardNum)
REFERENCES board(boardNum) on DELETE CASCADE
)

create table t_freeComment(
commentID varchar2(20) default 'guest',
commentContent varchar2(2000) not null,
commentDate date default sysdate,
commentGroup number(10) not null,
commentHir number(10) default 0,
commentNum number(10) default 0,
boardNum number(20),
commentPwd number(20) not null,
CONSTRAINT freeBoardNum_fk foreign key(boardNum)
REFERENCES freeBoard(boardNum) on DELETE CASCADE
)

create table guestBook(
id varchar2(20),
guestID varchar2(20) not null,
message varchar2(200) not null,
role varchar2(10) default 'member',
classColor varchar2(50) not null,
constraint id_fk foreign key(id)
references member(id)
)

create table goodAndBad(
boardNum number(20) not null,
id varchar2(20),
up number(20) default 0,
down number(20) default 0,
constraint id_goodAndBad_fk foreign key(id)
references member(id)
)

select * from member

select * from board

select * from t_comment

select * from guestBook

select * from t_freeComment

select * from t_imageFile order by contentnum desc

select * from freeBoard

select * from goodAndBad






