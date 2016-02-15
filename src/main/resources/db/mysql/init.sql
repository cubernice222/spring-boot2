create table If NOT EXISTS SINGLE_MESSAGE(
    ID varchar(255),
    MESSAGE varchar(255),
    primary key (ID)
);
create table if not EXISTS IDENTITY_STRATAGY(
  INSTANCE_NAME varchar(255),
  LAST_UPDATE_TIME TIMESTAMP,
  LAST_UPDATE_VALUE INTEGER,
  PRIMARY  key(INSTANCE_NAME)
);
create table if not EXISTS RESOURCES(
  ID varchar(36),
  RESOUCENAME varchar(255),
  RESOUCETYPE varchar(255),
  RESOUCE varchar(255),
  description VARCHAR(255),
  PRIMARY  key(ID)
);

create table if not EXISTS ROLES_RESOUCES(
  ROLE_ID VARCHAR(36),
  RESOUCE_ID VARCHAR(255)
);
TRUNCATE table RESOURCES;
TRUNCATE table ROLES_RESOUCES;
insert into RESOURCES(ID, RESOUCENAME, RESOUCETYPE, RESOUCEMATCH,description) VALUES ('resouces1','autoSecurityPage','page','/autopage.htm','自动权限管理');
insert into ROLES_RESOUCES(ROLE_ID,RESOUCE_ID) VALUES ('ROLE_ADMIN','resouces1');
