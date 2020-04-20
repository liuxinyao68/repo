DECLARE
  tid NUMBER(10) :=1000000001;
  phone VARCHAR2(11) :=16600000000;
  createtime DATE :=SYSDATE;
  i NUMBER := 0;
BEGIN
  WHILE(i<5000000)   LOOP
       i :=i+1;
       tid := tid+1;
       phone :=phone+1;
       INSERT INTO LOGININFO(ID,PHONE,CREATETIME,UPDATETIME) VALUES(tid,phone,createtime,createtime);
 
  END LOOP;

END;

