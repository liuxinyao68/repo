prompt PL/SQL Developer import file
prompt Created on 2019年10月31日 星期四 by Administrator
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
  is '账户表,用户主键, id';
comment on column ACCOUNTINFO.version
  is '版本号, 乐观锁';
comment on column ACCOUNTINFO.allquota
  is '总额度';
comment on column ACCOUNTINFO.canusequota
  is '可用额度';
comment on column ACCOUNTINFO.frozenquota
  is '冻结额度';
comment on column ACCOUNTINFO.monthsend
  is '每月应还金额';
comment on column ACCOUNTINFO.createtime
  is '创建时间';
comment on column ACCOUNTINFO.updatetime
  is '更新时间';
comment on column ACCOUNTINFO.temporaryquota
  is '临时额度';
comment on column ACCOUNTINFO.surplustemporaryquota
  is '剩余临时额度';
comment on column ACCOUNTINFO.if_delete
  is '是否删除';
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
  is '银行卡申请表具体信息主键';
comment on column APPLYINFO.marriage_id
  is '婚姻状况';
comment on column APPLYINFO.education_id
  is '学历状况';
comment on column APPLYINFO.contactstype
  is '常用联系人与本人关系';
comment on column APPLYINFO.contactname
  is '联系人名字';
comment on column APPLYINFO.contactphone
  is '联系人电话';
comment on column APPLYINFO.email
  is '邮箱';
comment on column APPLYINFO.homeprovince
  is '住宅所在省';
comment on column APPLYINFO.homecity
  is '住宅所在市';
comment on column APPLYINFO.homeregion
  is '住宅所在区/镇';
comment on column APPLYINFO.homeaddress
  is '住宅详细地址';
comment on column APPLYINFO.ifhave_room
  is '房产情况';
comment on column APPLYINFO.live_years
  is '居住年限';
comment on column APPLYINFO.carnumber
  is '自购车车牌号';
comment on column APPLYINFO.carbrand
  is '车辆品牌型号';
comment on column APPLYINFO.job
  is '职业';
comment on column APPLYINFO.creditcardstarttime
  is '信用卡有效起始时间';
comment on column APPLYINFO.creditcardendtime
  is '信用卡有效结束时间';
comment on column APPLYINFO.sendcardaddress
  is '寄卡地址,这里是用了数据字典';
comment on column APPLYINFO.unitname
  is '单位名称';
comment on column APPLYINFO.postname
  is '岗位名称';
comment on column APPLYINFO.work_years
  is '工作年数';
comment on column APPLYINFO.companyprovince
  is '单位所在省';
comment on column APPLYINFO.companycity
  is '单位所在市';
comment on column APPLYINFO.companyregion
  is '单位所在区/镇';
comment on column APPLYINFO.companyaddress
  is '单位详细地址';
comment on column APPLYINFO.companyphonetype
  is '单位电话类型:固定电话或移动电话';
comment on column APPLYINFO.companyphone
  is '电话号码';
comment on column APPLYINFO.createtime
  is '创建时间';
comment on column APPLYINFO.updatetime
  is '更新时间';
comment on column APPLYINFO.if_delete
  is '是否删除';
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
  is '银行卡管理表主键';
comment on column BANKCARD.cardnumber
  is '银行卡号';
comment on column BANKCARD.banktype
  is '银行类型,即哪个银行';
comment on column BANKCARD.cardtype
  is '银行卡类别,如储蓄卡, 借记卡';
comment on column BANKCARD.cradphone
  is '银行卡预留手机号';
comment on column BANKCARD.createtime
  is '创建时间';
comment on column BANKCARD.updatetime
  is '更新时间';
comment on column BANKCARD.if_delete
  is '是否删除';
comment on column BANKCARD.defaultcard
  is '是否是默认绑定的卡,  用于还款';
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
  is '序列主键';
comment on column BANKDB.realname
  is '真实姓名';
comment on column BANKDB.balance
  is '余额';
comment on column BANKDB.createtime
  is '创建时间';
comment on column BANKDB.updatetime
  is '更新时间';
comment on column BANKDB.if_delete
  is '是否删除';
comment on column BANKDB.idcard
  is '身份证号码';
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
  is '账单流水表';
comment on column BILL.version
  is '版本号, 乐观锁';
comment on column BILL.receivepeople
  is '收款用户';
comment on column BILL.receivemoney
  is '收款金额';
comment on column BILL.billtype
  is '流水类型, 如还款, 还是向他人转账';
comment on column BILL.sendcardtype
  is '付款卡类型,如信用卡还是银行卡';
comment on column BILL.sendcardid
  is '付款卡的id';
comment on column BILL.user_id
  is '用户id';
comment on column BILL.createtime
  is '创建时间';
comment on column BILL.updatetime
  is '更新时间';
comment on column BILL.if_delete
  is '是否删除';
comment on column BILL.bystages_id
  is '分期表id';

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
  is '分期表主键';
comment on column BYSTAGES.version
  is '版本号,乐观锁';
comment on column BYSTAGES.totalmoney
  is '分期总金额';
comment on column BYSTAGES.totalmonth
  is '分期月数';
comment on column BYSTAGES.rate
  is '利率';
comment on column BYSTAGES.monthsend
  is '每月应还';
comment on column BYSTAGES.endsend_monthnum
  is '已还月数';
comment on column BYSTAGES.if_end_send
  is '是否还完';
comment on column BYSTAGES.user_id
  is '用户id';
comment on column BYSTAGES.bill_id
  is '流水账单表id';
comment on column BYSTAGES.iftime_overflow
  is '是否逾期';
comment on column BYSTAGES.remindnum
  is '提醒次数';
comment on column BYSTAGES.createtime
  is '创建时间';
comment on column BYSTAGES.updatetime
  is '更新时间';
comment on column BYSTAGES.if_delete
  is '是否删除';
comment on column BYSTAGES.monthsendprincipal
  is '每月应还本金';
comment on column BYSTAGES.monthsendservicecharge
  is '每月应还手续费';
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
  is '信用卡管理表, 主键id';
comment on column CREDITCARD.cardnumber
  is '信用卡卡号';
comment on column CREDITCARD.if_main
  is '是否是主卡';
comment on column CREDITCARD.state
  is '当前卡的状态, 如注销, 正常等';
comment on column CREDITCARD.user_id
  is '用户id';
comment on column CREDITCARD.replacecardnumber
  is '旧的被继承被注销的卡';
comment on column CREDITCARD.createtime
  is '创建时间';
comment on column CREDITCARD.updatetime
  is '更新时间';
comment on column CREDITCARD.if_delete
  is '是否删除';
comment on column CREDITCARD.totalquota
  is '该卡额度';
comment on column CREDITCARD.surplusquota
  is '剩余额度';
comment on column CREDITCARD.usedquota
  is '可用额度';
comment on column CREDITCARD.paypassword
  is '支付密码';
comment on column CREDITCARD.enablestarttime
  is '有效期开始日期';
comment on column CREDITCARD.if_activation
  is '是否激活';
comment on column CREDITCARD.enableendtime
  is '有效期结束日期';
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
  is 'ip记录表,主键';
comment on column IPLOG.ip
  is 'ip地址';
comment on column IPLOG.loginstatenow
  is '用户当前登录状态, 是否登录了';
comment on column IPLOG.loginuser_id
  is '登录的用户的id,包括管理员和用户';
comment on column IPLOG.loginusertype
  is '登录的用户的类型,如管理员';
comment on column IPLOG.logintime
  is '登录时间';
comment on column IPLOG.createtime
  is '创建时间';
comment on column IPLOG.updatetime
  is '更新时间';
comment on column IPLOG.if_delete
  is '是否删除';
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
  is '登录表,用户id,主键';
comment on column LOGININFO.phone
  is '电话号码,即登录的用户名';
comment on column LOGININFO.password
  is '密码';
comment on column LOGININFO.state
  is '用户状态,如正常,冻结等';
comment on column LOGININFO.usertype
  is '用户类型';
comment on column LOGININFO.createtime
  is '创建时间';
comment on column LOGININFO.updatetime
  is '更新时间';
comment on column LOGININFO.if_delete
  is '是否删除,0不删,1为删';
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
  is '字典类型表,主键';
comment on column SYSDICTIONARY.name
  is '名称,如学历状况';
comment on column SYSDICTIONARY.note
  is '说明,用于哪个情况下';
comment on column SYSDICTIONARY.createtime
  is '创建时间';
comment on column SYSDICTIONARY.updatetime
  is '更新时间';
comment on column SYSDICTIONARY.if_delete
  is '是否删除';
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
  is '字典类型明细表,主键';
comment on column SYSDICTIONARYITEM.parentid
  is '字典类型表主键';
comment on column SYSDICTIONARYITEM.name
  is '名称, 如大专, 本科';
comment on column SYSDICTIONARYITEM.sequence
  is '序列, 用于下拉列表展示用';
comment on column SYSDICTIONARYITEM.createtime
  is '创建时间';
comment on column SYSDICTIONARYITEM.updatetime
  is '更新时间';
comment on column SYSDICTIONARYITEM.if_delete
  is '是否删除';
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
  is '用户上传的文件管理表,用户id,主键';
comment on column USERFILE.state
  is '当前文件状态:如待审核';
comment on column USERFILE.remark
  is '审核意见';
comment on column USERFILE.applier_id
  is '申请者id,即用户id';
comment on column USERFILE.applytime
  is '申请时间';
comment on column USERFILE.auditor_id
  is '审核人员id';
comment on column USERFILE.audittime
  is '审核时间';
comment on column USERFILE.authscore
  is '审核分数结果';
comment on column USERFILE.fileroute
  is '文件路径';
comment on column USERFILE.filetype_id
  is '文件类型';
comment on column USERFILE.createtime
  is '创建时间';
comment on column USERFILE.updatetime
  is '更新时间';
comment on column USERFILE.if_delete
  is '是否删除';
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
  is '用户基本信息表,id,主键';
comment on column USERINFO.version
  is '版本, 用于乐观锁';
comment on column USERINFO.bitstate
  is '位状态,用于记录认证了哪些';
comment on column USERINFO.authscore
  is '认证信用分数';
comment on column USERINFO.authgrade
  is '认证信用等级,最高A,最低H';
comment on column USERINFO.realname
  is '真实姓名';
comment on column USERINFO.idcardnumber
  is '身份证号码';
comment on column USERINFO.phone
  is '电话';
comment on column USERINFO.createtime
  is '创建时间';
comment on column USERINFO.updatetime
  is '更新时间';
comment on column USERINFO.if_delete
  is '是否删除';
comment on column USERINFO.citynow
  is '当前所在城市';
comment on column USERINFO.applyinfo_id
  is '申请的具体信息表的id';
comment on column USERINFO.applystate
  is '当前资料的申请状态,如待审核, 审核通过等';
comment on column USERINFO.if_blackname
  is '是否加入黑名单';
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
