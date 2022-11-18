
CREATE DATABASE thuman0503 default CHARACTER SET UTF8

select @@global.time_zone, @@session.time_zone,@@system_time_zone
select now()
select DATE_SUB(now(), INTERVAL 9 HOUR)

--alter table thuman0503.freeBoardJYY modify boardPwd varchar(50)
--alter table thuman0503.t_freeCommentJYY modify commentPwd varchar(50)

drop table thuman0503.goodAndBadJYY
drop table thuman0503.guestBookJYY
drop table thuman0503.t_freeCommentJYY
drop table thuman0503.t_commentJYY
drop table thuman0503.t_imageFileJYY
drop table thuman0503.freeBoardJYY
drop table thuman0503.boardJYY
drop table thuman0503.memberJYY

create table thuman0503.memberJYY(
id varchar(20) primary key,
pwd varchar(20) not null,
role varchar(10) default 'member',
signUpDate TIMESTAMP default  CURRENT_TIMESTAMP()
)

--add cascade 
create table thuman0503.boardJYY(
boardID varchar(20),
boardNum int(20) primary key,
boardCount int(20) default 0,
boardDate TIMESTAMP default CURRENT_TIMESTAMP(),
boardContent longtext not null,
fileName varchar(50),
boardTitle varchar(100),
commentCount int(20),
upCount int(20) default 0,
constraint boardID_fk foreign key(boardID)
references memberJYY(id) ON DELETE CASCADE
)


create table thuman0503.freeBoardJYY(
boardID varchar(20) default 'guest',
boardPwd varchar(50) not null,
boardNum int(20) primary key,
boardCount int(20) default 0,
boardDate TIMESTAMP default CURRENT_TIMESTAMP(),
boardContent longtext not null,
fileName varchar(50),
boardTitle varchar(100),
commentCount int(20)
)


insert into thuman0503.memberJYY values('admin' , 'admin123' , 'admin',CURRENT_TIMESTAMP());
insert into thuman0503.boardJYY values('admin' , 1 , 0,CURRENT_TIMESTAMP(),'안녕하세요',null,'관리자입니다',0,0);
insert into thuman0503.freeBoardJYY values('guest' ,1234 ,1 , 0,CURRENT_TIMESTAMP(),'안녕하세요1',null,'익명게시판1',0);
insert into thuman0503.freeBoardJYY values('guest' ,1234 ,2 , 0,CURRENT_TIMESTAMP(),'안녕하세요2',null,'익명게시판2',0);
insert into thuman0503.freeBoardJYY values('guest' ,1234 ,3 , 0,CURRENT_TIMESTAMP(),'안녕하세요3',null,'익명게시판3',0);
insert into thuman0503.freeBoardJYY values('guest' ,1234 ,4 , 0,CURRENT_TIMESTAMP(),'안녕하세요4',null,'익명게시판4',0);
insert into thuman0503.freeBoardJYY values('guest' ,1234 ,5 , 0,CURRENT_TIMESTAMP(),'안녕하세요5',null,'익명게시판5',0);
insert into thuman0503.freeBoardJYY values('guest' ,1234 ,6 , 0,CURRENT_TIMESTAMP(),'안녕하세요6',null,'익명게시판6',0);
insert into thuman0503.freeBoardJYY values('guest' ,1234 ,7 , 0,CURRENT_TIMESTAMP(),'안녕하세요7',null,'익명게시판7',0);
insert into thuman0503.freeBoardJYY values('guest' ,1234 ,8 , 0,CURRENT_TIMESTAMP(),'안녕하세요8',null,'익명게시판8',0);
insert into thuman0503.freeBoardJYY values('guest' ,1234 ,9 , 0,CURRENT_TIMESTAMP(),'안녕하세요9',null,'익명게시판9',0);

select * from thuman0503.freeBoardJYY

create table thuman0503.t_imageFileJYY(
imageFileNo int,
imageFileName varchar(50),
regDate TIMESTAMP default CURRENT_TIMESTAMP(),
contentNum int,
constraint contentNum_fk foreign key(contentNum)
references boardJYY(boardNum) on delete cascade
)

-- SQLINES LICENSE FOR EVALUATION USE ONLY
create table thuman0503.t_commentJYY(
commentID varchar(20) not null,
commentContent varchar(2000) not null,
commentDate TIMESTAMP default CURRENT_TIMESTAMP(),
commentGroup bigint not null,
commentHir bigint default 0,
commentNum bigint default 0,
boardNum int(20),
CONSTRAINT boardNum_fk foreign key(boardNum)
REFERENCES boardJYY(boardNum) on DELETE CASCADE
)

-- SQLINES LICENSE FOR EVALUATION USE ONLY
create table thuman0503.t_freeCommentJYY(
commentID varchar(20) default 'guest',
commentContent varchar(2000) not null,
commentDate TIMESTAMP default CURRENT_TIMESTAMP(),
commentGroup bigint not null,
commentHir bigint default 0,
commentNum bigint default 0,
boardNum int(20),
commentPwd varchar(50) not null,
CONSTRAINT freeBoardNum_fk foreign key(boardNum)
REFERENCES freeBoardJYY(boardNum) on DELETE CASCADE
)

-- SQLINES LICENSE FOR EVALUATION USE ONLY
-- add cascade
create table thuman0503.guestBookJYY(
id varchar(20),
guestID varchar(20) not null,
message varchar(200) not null,
role varchar(10) default 'member',
classColor varchar(50) not null,
constraint id_fk foreign key(id)
references memberJYY(id)
)


-- SQLINES LICENSE FOR EVALUATION USE ONLY
-- remove foreign key
create table thuman0503.goodAndBadJYY(
boardNum int(20) not null,
id varchar(20),
up int(20) default 0,
down int(20) default 0
--, constraint id_goodAndBad_fk foreign key(id)
--references memberJYY(id)
)

--ALTER TABLE thuman0503.goodAndBadJYY DROP FOREIGN KEY id_goodAndBad_fk


create table thuman0503.fishInfoJYY(
fishImage longtext not null ,
fishName varchar(100) not null ,
fishExplanation varchar(1000) not null ,
fishLocation varchar(500) not null ,
fishTime varchar(100) not null ,
fishWeather varchar(100) not null ,
fishNum int(20) NOT NULL AUTO_INCREMENT PRIMARY KEY
)

select * from thuman0503.memberJYY;

select * from thuman0503.boardJYY;

select * from thuman0503.freeBoardJYY order by boardNum desc;

select * from thuman0503.t_freeCommentJYY;

select * from thuman0503.t_imageFileJYY;

select * from thuman0503.fishInfoJYY;

select tb2.*  from
(select tb.* , @ROWNUM:=@ROWNUM+1 as rNum from
(select * from thuman0503.freeBoardJYY order by boardNum desc) tb , (SELECT @ROWNUM:=0) R) tb2 where rNum between 1 and 100
 ORDER BY boardNum desc;


   					select tb2.*  from
					(select tb.* , @ROWNUM:=@ROWNUM+1 as rNum from
						(select * from thuman0503.freeBoardJYY order by boardNum desc) tb , (SELECT @ROWNUM:=0) R ) tb2 
							where rNum between 1 and 10 order by boardNum desc
							
						select tb2.*  from(
							select tb.* , @ROWNUM:=@ROWNUM+1 as rNum from
						((select * from thuman0503.freeBoardJYY order by boardNum desc) tb , (SELECT @ROWNUM:=0) R) order by boardNum desc
								) tb2 where rNum between 1 and 10

									select count(*) from thuman0503.fishInfoJYY

									
									
													select tb2.*  from (
					(select tb.* , @ROWNUM:=@ROWNUM+1 as rNum from
						(select 
								*
				 from thuman0503.fishInfoJYY
   
   				 order by fishNum desc) tb , (SELECT @ROWNUM:=0) R) order by fishNum desc)tb2 
							where rNum between 11 and 20
							
							
													select tb2.*  from(
							select tb.* , @ROWNUM:=@ROWNUM+1 as rNum from
						((select 
							boardID ,boardNum,boardCount, 
							boardContent, date_format(boardDate , '%Y-%m-%d') as boardDate, 
							fileName,boardTitle,commentCount
					 from thuman0503.boardJYY order by boardNum desc) tb , (SELECT @ROWNUM:=0) R) order by boardNum desc
								) tb2 where rNum between 1 and 10
								
								
								
								
								
											select tb2.*  from (
					(select tb.* , @ROWNUM:=@ROWNUM+1 as rNum from
						(select 
												boardID ,boardNum,boardCount, 
							boardContent, date_format(boardDate , '%Y-%m-%d') as boardDate, 
							fileName,boardTitle,commentCount
				 from thuman0503.boardJYY  
   		
   				 order by boardNum desc) tb , (SELECT @ROWNUM:=0) R) order by boardNum desc) tb2 
							where rNum between 0 and 100
