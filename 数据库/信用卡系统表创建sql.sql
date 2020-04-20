prompt PL/SQL Developer import file
prompt Created on 2019��10��31�� ������ by Administrator
set feedback off
set define off
prompt Creating ACCOUNTINFO...
create table ACCOUNTINFO
(
  id                    NUMBER(10) not null,
  version               NUMBER(10),
  allquota              NUMBER(20,2),
  canusequota           NUMBER(20,2),
  frozenquota           NUMBER(20,2),
  monthsend             NUMBER(20,2),
  createtime            DATE not null,
  updatetime            DATE not null,
  temporaryquota        NUMBER(20,2) default 0,
  surplustemporaryquota NUMBER(20,2) default 0,
  if_delete             as (0)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on column ACCOUNTINFO.id
  is '�˻���,�û�����, id';
comment on column ACCOUNTINFO.version
  is '�汾��, �ֹ���';
comment on column ACCOUNTINFO.allquota
  is '�ܶ��';
comment on column ACCOUNTINFO.canusequota
  is '���ö��';
comment on column ACCOUNTINFO.frozenquota
  is '������';
comment on column ACCOUNTINFO.monthsend
  is 'ÿ��Ӧ�����';
comment on column ACCOUNTINFO.createtime
  is '����ʱ��';
comment on column ACCOUNTINFO.updatetime
  is '����ʱ��';
comment on column ACCOUNTINFO.temporaryquota
  is '��ʱ���';
comment on column ACCOUNTINFO.surplustemporaryquota
  is 'ʣ����ʱ���';
comment on column ACCOUNTINFO.if_delete
  is '�Ƿ�ɾ��';
alter table ACCOUNTINFO
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

  

prompt Creating APPLYINFO...
create table APPLYINFO
(
  id                  NUMBER(10) not null,
  marriage_id         NUMBER(10),
  education_id        NUMBER(10),
  contactstype        NUMBER(10),
  contactname         VARCHAR2(20),
  contactphone        NUMBER(11),
  email               VARCHAR2(40),
  homeprovince        VARCHAR2(40),
  homecity            VARCHAR2(40),
  homeregion          VARCHAR2(40),
  homeaddress         VARCHAR2(100),
  ifhave_room         NUMBER(10),
  live_years          NUMBER(10),
  carnumber           VARCHAR2(40),
  carbrand            VARCHAR2(40),
  job                 NUMBER(10),
  creditcardstarttime DATE,
  creditcardendtime   DATE,
  sendcardaddress     NUMBER(10),
  unitname            VARCHAR2(40),
  postname            VARCHAR2(40),
  work_years          NUMBER(10),
  companyprovince     VARCHAR2(40),
  companycity         VARCHAR2(40),
  companyregion       VARCHAR2(40),
  companyaddress      VARCHAR2(100),
  companyphonetype    NUMBER(10),
  companyphone        VARCHAR2(20),
  createtime          DATE not null,
  updatetime          DATE not null,
  if_delete           NUMBER(1) default 0
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on column APPLYINFO.id
  is '���п�����������Ϣ����';
comment on column APPLYINFO.marriage_id
  is '����״��';
comment on column APPLYINFO.education_id
  is 'ѧ��״��';
comment on column APPLYINFO.contactstype
  is '������ϵ���뱾�˹�ϵ';
comment on column APPLYINFO.contactname
  is '��ϵ������';
comment on column APPLYINFO.contactphone
  is '��ϵ�˵绰';
comment on column APPLYINFO.email
  is '����';
comment on column APPLYINFO.homeprovince
  is 'סլ����ʡ';
comment on column APPLYINFO.homecity
  is 'סլ������';
comment on column APPLYINFO.homeregion
  is 'סլ������/��';
comment on column APPLYINFO.homeaddress
  is 'סլ��ϸ��ַ';
comment on column APPLYINFO.ifhave_room
  is '�������';
comment on column APPLYINFO.live_years
  is '��ס����';
comment on column APPLYINFO.carnumber
  is '�Թ������ƺ�';
comment on column APPLYINFO.carbrand
  is '����Ʒ���ͺ�';
comment on column APPLYINFO.job
  is 'ְҵ';
comment on column APPLYINFO.creditcardstarttime
  is '���ÿ���Ч��ʼʱ��';
comment on column APPLYINFO.creditcardendtime
  is '���ÿ���Ч����ʱ��';
comment on column APPLYINFO.sendcardaddress
  is '�Ŀ���ַ,���������������ֵ�';
comment on column APPLYINFO.unitname
  is '��λ����';
comment on column APPLYINFO.postname
  is '��λ����';
comment on column APPLYINFO.work_years
  is '��������';
comment on column APPLYINFO.companyprovince
  is '��λ����ʡ';
comment on column APPLYINFO.companycity
  is '��λ������';
comment on column APPLYINFO.companyregion
  is '��λ������/��';
comment on column APPLYINFO.companyaddress
  is '��λ��ϸ��ַ';
comment on column APPLYINFO.companyphonetype
  is '��λ�绰����:�̶��绰���ƶ��绰';
comment on column APPLYINFO.companyphone
  is '�绰����';
comment on column APPLYINFO.createtime
  is '����ʱ��';
comment on column APPLYINFO.updatetime
  is '����ʱ��';
comment on column APPLYINFO.if_delete
  is '�Ƿ�ɾ��';
alter table APPLYINFO
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Creating BANKCARD...
create table BANKCARD
(
  id          NUMBER(10) not null,
  cardnumber  NUMBER(19) not null,
  banktype    VARCHAR2(40),
  cardtype    VARCHAR2(20),
  cradphone   NUMBER(11),
  createtime  DATE not null,
  updatetime  DATE not null,
  if_delete   NUMBER(1) default 0,
  defaultcard NUMBER(1) default 0
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on column BANKCARD.id
  is '���п����������';
comment on column BANKCARD.cardnumber
  is '���п���';
comment on column BANKCARD.banktype
  is '��������,���ĸ�����';
comment on column BANKCARD.cardtype
  is '���п����,�索�, ��ǿ�';
comment on column BANKCARD.cradphone
  is '���п�Ԥ���ֻ���';
comment on column BANKCARD.createtime
  is '����ʱ��';
comment on column BANKCARD.updatetime
  is '����ʱ��';
comment on column BANKCARD.if_delete
  is '�Ƿ�ɾ��';
comment on column BANKCARD.defaultcard
  is '�Ƿ���Ĭ�ϰ󶨵Ŀ�,  ���ڻ���';
alter table BANKCARD
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Creating BANKDB...
create table BANKDB
(
  id         NUMBER(10) not null,
  realname   VARCHAR2(20),
  balance    NUMBER(20,2),
  createtime DATE not null,
  updatetime DATE not null,
  if_delete  NUMBER(1) default 0,
  idcard     NUMBER(18)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on column BANKDB.id
  is '��������';
comment on column BANKDB.realname
  is '��ʵ����';
comment on column BANKDB.balance
  is '���';
comment on column BANKDB.createtime
  is '����ʱ��';
comment on column BANKDB.updatetime
  is '����ʱ��';
comment on column BANKDB.if_delete
  is '�Ƿ�ɾ��';
comment on column BANKDB.idcard
  is '���֤����';
alter table BANKDB
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Creating BILL...
create table BILL
(
  id            NUMBER(10),
  version       NUMBER(10),
  receivepeople VARCHAR2(40),
  receivemoney  NUMBER(20,2),
  billtype      NUMBER(10),
  sendcardtype  NUMBER(10),
  sendcardid    NUMBER(10),
  user_id       NUMBER(10),
  createtime    DATE not null,
  updatetime    DATE not null,
  if_delete     NUMBER(1) default 0,
  bystages_id   NUMBER(10)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on column BILL.id
  is '�˵���ˮ��';
comment on column BILL.version
  is '�汾��, �ֹ���';
comment on column BILL.receivepeople
  is '�տ��û�';
comment on column BILL.receivemoney
  is '�տ���';
comment on column BILL.billtype
  is '��ˮ����, �绹��, ����������ת��';
comment on column BILL.sendcardtype
  is '�������,�����ÿ��������п�';
comment on column BILL.sendcardid
  is '�����id';
comment on column BILL.user_id
  is '�û�id';
comment on column BILL.createtime
  is '����ʱ��';
comment on column BILL.updatetime
  is '����ʱ��';
comment on column BILL.if_delete
  is '�Ƿ�ɾ��';
comment on column BILL.bystages_id
  is '���ڱ�id';

prompt Creating BYSTAGES...
create table BYSTAGES
(
  id                     NUMBER(10) not null,
  version                NUMBER(10) default 1,
  totalmoney             NUMBER(20,2),
  totalmonth             NUMBER(10),
  rate                   NUMBER(10,6),
  monthsend              NUMBER(20,2),
  endsend_monthnum       NUMBER(10),
  if_end_send            NUMBER(10),
  user_id                NUMBER(10),
  bill_id                NUMBER(10),
  iftime_overflow        NUMBER(10) default 0,
  remindnum              NUMBER(10),
  createtime             DATE not null,
  updatetime             DATE not null,
  if_delete              NUMBER(1) default 0,
  monthsendprincipal     NUMBER(20,2),
  monthsendservicecharge NUMBER(20,2)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on column BYSTAGES.id
  is '���ڱ�����';
comment on column BYSTAGES.version
  is '�汾��,�ֹ���';
comment on column BYSTAGES.totalmoney
  is '�����ܽ��';
comment on column BYSTAGES.totalmonth
  is '��������';
comment on column BYSTAGES.rate
  is '����';
comment on column BYSTAGES.monthsend
  is 'ÿ��Ӧ��';
comment on column BYSTAGES.endsend_monthnum
  is '�ѻ�����';
comment on column BYSTAGES.if_end_send
  is '�Ƿ���';
comment on column BYSTAGES.user_id
  is '�û�id';
comment on column BYSTAGES.bill_id
  is '��ˮ�˵���id';
comment on column BYSTAGES.iftime_overflow
  is '�Ƿ�����';
comment on column BYSTAGES.remindnum
  is '���Ѵ���';
comment on column BYSTAGES.createtime
  is '����ʱ��';
comment on column BYSTAGES.updatetime
  is '����ʱ��';
comment on column BYSTAGES.if_delete
  is '�Ƿ�ɾ��';
comment on column BYSTAGES.monthsendprincipal
  is 'ÿ��Ӧ������';
comment on column BYSTAGES.monthsendservicecharge
  is 'ÿ��Ӧ��������';
alter table BYSTAGES
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Creating CREDITCARD...
create table CREDITCARD
(
  id                NUMBER(10) not null,
  cardnumber        NUMBER(16),
  if_main           NUMBER(10),
  state             NUMBER(10),
  user_id           NUMBER(10),
  replacecardnumber NUMBER(16),
  createtime        DATE not null,
  updatetime        DATE not null,
  if_delete         NUMBER(1) default 0,
  totalquota        NUMBER(20,2) default 0,
  surplusquota      NUMBER(20,2) default 0,
  usedquota         NUMBER(20,2) default 0,
  paypassword       VARCHAR2(20),
  enablestarttime   DATE,
  if_activation     NUMBER(1) default 0,
  enableendtime     DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on column CREDITCARD.id
  is '���ÿ������, ����id';
comment on column CREDITCARD.cardnumber
  is '���ÿ�����';
comment on column CREDITCARD.if_main
  is '�Ƿ�������';
comment on column CREDITCARD.state
  is '��ǰ����״̬, ��ע��, ������';
comment on column CREDITCARD.user_id
  is '�û�id';
comment on column CREDITCARD.replacecardnumber
  is '�ɵı��̳б�ע���Ŀ�';
comment on column CREDITCARD.createtime
  is '����ʱ��';
comment on column CREDITCARD.updatetime
  is '����ʱ��';
comment on column CREDITCARD.if_delete
  is '�Ƿ�ɾ��';
comment on column CREDITCARD.totalquota
  is '�ÿ����';
comment on column CREDITCARD.surplusquota
  is 'ʣ����';
comment on column CREDITCARD.usedquota
  is '���ö��';
comment on column CREDITCARD.paypassword
  is '֧������';
comment on column CREDITCARD.enablestarttime
  is '��Ч�ڿ�ʼ����';
comment on column CREDITCARD.if_activation
  is '�Ƿ񼤻�';
comment on column CREDITCARD.enableendtime
  is '��Ч�ڽ�������';
alter table CREDITCARD
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Creating IPLOG...
create table IPLOG
(
  id            NUMBER(10) not null,
  ip            VARCHAR2(50),
  loginstatenow NUMBER(10),
  loginuser_id  NUMBER(10),
  loginusertype NUMBER(10),
  logintime     DATE,
  createtime    DATE,
  updatetime    DATE,
  if_delete     NUMBER(1) default 0
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on column IPLOG.id
  is 'ip��¼��,����';
comment on column IPLOG.ip
  is 'ip��ַ';
comment on column IPLOG.loginstatenow
  is '�û���ǰ��¼״̬, �Ƿ��¼��';
comment on column IPLOG.loginuser_id
  is '��¼���û���id,��������Ա���û�';
comment on column IPLOG.loginusertype
  is '��¼���û�������,�����Ա';
comment on column IPLOG.logintime
  is '��¼ʱ��';
comment on column IPLOG.createtime
  is '����ʱ��';
comment on column IPLOG.updatetime
  is '����ʱ��';
comment on column IPLOG.if_delete
  is '�Ƿ�ɾ��';
alter table IPLOG
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Creating LOGININFO...
create table LOGININFO
(
  id         NUMBER(10) not null,
  phone      NUMBER(11) not null,
  password   VARCHAR2(32) not null,
  state      NUMBER(1) default 1 not null,
  usertype   NUMBER(1) default 1 not null,
  createtime DATE not null,
  updatetime DATE not null,
  if_delete  NUMBER(1) default 0
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on column LOGININFO.id
  is '��¼��,�û�id,����';
comment on column LOGININFO.phone
  is '�绰����,����¼���û���';
comment on column LOGININFO.password
  is '����';
comment on column LOGININFO.state
  is '�û�״̬,������,�����';
comment on column LOGININFO.usertype
  is '�û�����';
comment on column LOGININFO.createtime
  is '����ʱ��';
comment on column LOGININFO.updatetime
  is '����ʱ��';
comment on column LOGININFO.if_delete
  is '�Ƿ�ɾ��,0��ɾ,1Ϊɾ';
alter table LOGININFO
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Creating OVERFLOWS...
create table OVERFLOWS
(
  id            NUMBER(10) not null,
  version       NUMBER(10),
  totalmoney    NUMBER(20,2),
  totalinterest NUMBER(20,2),
  username      VARCHAR2(20),
  idcard        NUMBER(18),
  phone         NUMBER(11),
  address       VARCHAR2(100),
  repay         NUMBER(20,2),
  needpay       NUMBER(20,2),
  createtime    DATE not null,
  updatetime    DATE not null,
  if_delete     NUMBER(1) default 0
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
alter table OVERFLOWS
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Creating SYSDICTIONARY...
create table SYSDICTIONARY
(
  id         NUMBER(10) not null,
  name       VARCHAR2(40) not null,
  note       VARCHAR2(200),
  createtime DATE not null,
  updatetime DATE not null,
  if_delete  NUMBER(1) default 0
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on column SYSDICTIONARY.id
  is '�ֵ����ͱ�,����';
comment on column SYSDICTIONARY.name
  is '����,��ѧ��״��';
comment on column SYSDICTIONARY.note
  is '˵��,�����ĸ������';
comment on column SYSDICTIONARY.createtime
  is '����ʱ��';
comment on column SYSDICTIONARY.updatetime
  is '����ʱ��';
comment on column SYSDICTIONARY.if_delete
  is '�Ƿ�ɾ��';
alter table SYSDICTIONARY
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Creating SYSDICTIONARYITEM...
create table SYSDICTIONARYITEM
(
  id         NUMBER(10) not null,
  parentid   NUMBER(10) not null,
  name       VARCHAR2(100) not null,
  sequence   NUMBER(10),
  createtime DATE not null,
  updatetime DATE not null,
  if_delete  NUMBER(1) default 0
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on column SYSDICTIONARYITEM.id
  is '�ֵ�������ϸ��,����';
comment on column SYSDICTIONARYITEM.parentid
  is '�ֵ����ͱ�����';
comment on column SYSDICTIONARYITEM.name
  is '����, ���ר, ����';
comment on column SYSDICTIONARYITEM.sequence
  is '����, ���������б�չʾ��';
comment on column SYSDICTIONARYITEM.createtime
  is '����ʱ��';
comment on column SYSDICTIONARYITEM.updatetime
  is '����ʱ��';
comment on column SYSDICTIONARYITEM.if_delete
  is '�Ƿ�ɾ��';
alter table SYSDICTIONARYITEM
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Creating USERFILE...
create table USERFILE
(
  id          NUMBER(10) not null,
  state       NUMBER(10) default 0,
  remark      VARCHAR2(255) not null,
  applier_id  NUMBER(16) not null,
  applytime   DATE not null,
  auditor_id  NUMBER(20),
  audittime   DATE,
  authscore   NUMBER(10) default 0,
  fileroute   VARCHAR2(255) not null,
  filetype_id NUMBER(10) not null,
  createtime  DATE not null,
  updatetime  DATE not null,
  if_delete   NUMBER(1) default 0
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on column USERFILE.id
  is '�û��ϴ����ļ������,�û�id,����';
comment on column USERFILE.state
  is '��ǰ�ļ�״̬:������';
comment on column USERFILE.remark
  is '������';
comment on column USERFILE.applier_id
  is '������id,���û�id';
comment on column USERFILE.applytime
  is '����ʱ��';
comment on column USERFILE.auditor_id
  is '�����Աid';
comment on column USERFILE.audittime
  is '���ʱ��';
comment on column USERFILE.authscore
  is '��˷������';
comment on column USERFILE.fileroute
  is '�ļ�·��';
comment on column USERFILE.filetype_id
  is '�ļ�����';
comment on column USERFILE.createtime
  is '����ʱ��';
comment on column USERFILE.updatetime
  is '����ʱ��';
comment on column USERFILE.if_delete
  is '�Ƿ�ɾ��';
alter table USERFILE
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Creating USERINFO...
create table USERINFO
(
  id           NUMBER(10) not null,
  version      NUMBER(10) default 1,
  bitstate     NUMBER(10) default 0,
  authscore    NUMBER(3) default 0,
  authgrade    NUMBER(2) default 0,
  realname     VARCHAR2(20) not null,
  idcardnumber VARCHAR2(18) not null,
  phone        NUMBER(11) not null,
  createtime   DATE not null,
  updatetime   DATE not null,
  if_delete    NUMBER(1) default 0,
  citynow      VARCHAR2(200) not null,
  applyinfo_id NUMBER(10) default 0,
  applystate   NUMBER(10) default 0,
  if_blackname NUMBER(1) default 0
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255;
comment on column USERINFO.id
  is '�û�������Ϣ��,id,����';
comment on column USERINFO.version
  is '�汾, �����ֹ���';
comment on column USERINFO.bitstate
  is 'λ״̬,���ڼ�¼��֤����Щ';
comment on column USERINFO.authscore
  is '��֤���÷���';
comment on column USERINFO.authgrade
  is '��֤���õȼ�,���A,���H';
comment on column USERINFO.realname
  is '��ʵ����';
comment on column USERINFO.idcardnumber
  is '���֤����';
comment on column USERINFO.phone
  is '�绰';
comment on column USERINFO.createtime
  is '����ʱ��';
comment on column USERINFO.updatetime
  is '����ʱ��';
comment on column USERINFO.if_delete
  is '�Ƿ�ɾ��';
comment on column USERINFO.citynow
  is '��ǰ���ڳ���';
comment on column USERINFO.applyinfo_id
  is '����ľ�����Ϣ���id';
comment on column USERINFO.applystate
  is '��ǰ���ϵ�����״̬,������, ���ͨ����';
comment on column USERINFO.if_blackname
  is '�Ƿ���������';
alter table USERINFO
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;

prompt Disabling triggers for ACCOUNTINFO...
alter table ACCOUNTINFO disable all triggers;
prompt Disabling triggers for APPLYINFO...
alter table APPLYINFO disable all triggers;
prompt Disabling triggers for BANKCARD...
alter table BANKCARD disable all triggers;
prompt Disabling triggers for BANKDB...
alter table BANKDB disable all triggers;
prompt Disabling triggers for BILL...
alter table BILL disable all triggers;
prompt Disabling triggers for BYSTAGES...
alter table BYSTAGES disable all triggers;
prompt Disabling triggers for CREDITCARD...
alter table CREDITCARD disable all triggers;
prompt Disabling triggers for IPLOG...
alter table IPLOG disable all triggers;
prompt Disabling triggers for LOGININFO...
alter table LOGININFO disable all triggers;
prompt Disabling triggers for OVERFLOWS...
alter table OVERFLOWS disable all triggers;
prompt Disabling triggers for SYSDICTIONARY...
alter table SYSDICTIONARY disable all triggers;
prompt Disabling triggers for SYSDICTIONARYITEM...
alter table SYSDICTIONARYITEM disable all triggers;
prompt Disabling triggers for USERFILE...
alter table USERFILE disable all triggers;
prompt Disabling triggers for USERINFO...
alter table USERINFO disable all triggers;
prompt Loading ACCOUNTINFO...
prompt Table is empty
prompt Loading APPLYINFO...
prompt Table is empty
prompt Loading BANKCARD...
prompt Table is empty
prompt Loading BANKDB...
prompt Table is empty
prompt Loading BILL...
prompt Table is empty
prompt Loading BYSTAGES...
prompt Table is empty
prompt Loading CREDITCARD...
prompt Table is empty
prompt Loading IPLOG...
prompt Table is empty
prompt Loading LOGININFO...
prompt Table is empty
prompt Loading OVERFLOWS...
prompt Table is empty
prompt Loading SYSDICTIONARY...
prompt Table is empty
prompt Loading SYSDICTIONARYITEM...
prompt Table is empty
prompt Loading USERFILE...
prompt Table is empty
prompt Loading USERINFO...
prompt Table is empty
prompt Enabling triggers for ACCOUNTINFO...
alter table ACCOUNTINFO enable all triggers;
prompt Enabling triggers for APPLYINFO...
alter table APPLYINFO enable all triggers;
prompt Enabling triggers for BANKCARD...
alter table BANKCARD enable all triggers;
prompt Enabling triggers for BANKDB...
alter table BANKDB enable all triggers;
prompt Enabling triggers for BILL...
alter table BILL enable all triggers;
prompt Enabling triggers for BYSTAGES...
alter table BYSTAGES enable all triggers;
prompt Enabling triggers for CREDITCARD...
alter table CREDITCARD enable all triggers;
prompt Enabling triggers for IPLOG...
alter table IPLOG enable all triggers;
prompt Enabling triggers for LOGININFO...
alter table LOGININFO enable all triggers;
prompt Enabling triggers for OVERFLOWS...
alter table OVERFLOWS enable all triggers;
prompt Enabling triggers for SYSDICTIONARY...
alter table SYSDICTIONARY enable all triggers;
prompt Enabling triggers for SYSDICTIONARYITEM...
alter table SYSDICTIONARYITEM enable all triggers;
prompt Enabling triggers for USERFILE...
alter table USERFILE enable all triggers;
prompt Enabling triggers for USERINFO...
alter table USERINFO enable all triggers;
set feedback on
set define on
prompt Done.
