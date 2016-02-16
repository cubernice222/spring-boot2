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
  RESOURCENAME varchar(255),
  RESOURCETYPE varchar(255),
  RESOURCE varchar(255),
  description VARCHAR(255),
  PRIMARY  key(ID)
);

create table if not EXISTS ROLES_RESOURCES(
  ROLE_ID VARCHAR(36),
  RESOURCE_ID VARCHAR(255)
);
TRUNCATE table RESOURCES;
TRUNCATE table ROLES_RESOURCES;
insert into RESOURCES(ID, RESOURCENAME, RESOURCETYPE, RESOURCE,description) VALUES ('resources1','autoSecurityPage','page','/autopage.htm','自动权限管理');
insert into ROLES_RESOURCES(ROLE_ID,RESOURCE_ID) VALUES ('ROLE_ADMIN','resources1');
