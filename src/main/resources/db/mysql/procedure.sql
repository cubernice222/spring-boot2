create PROCEDURE  P_GETID(in instanceName VARCHAR(255), OUT id varchar(255))
 BEGIN
  START TRANSACTION;
	update
		identity_stratagy
	set
		last_update_value = CASE
		when date(last_update_time)= date(sysdate()) then last_update_value + 1
		else 1 end ,
		last_update_time = SYSDATE()
	where instance_name = instanceName;
  select CONCAT(DATE_FORMAT(SYSDATE(),'%Y%m%d%H%i%s'),LPAD(last_update_value,4,'0')) into  id from identity_stratagy where instance_name = instanceName;
	commit;
 end;