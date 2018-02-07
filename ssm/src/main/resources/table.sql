create table USERINFO
(
  userid   VARCHAR2(50) default sys_guid() not null,
  username VARCHAR2(100) not null,
  password VARCHAR2(50) not null
)