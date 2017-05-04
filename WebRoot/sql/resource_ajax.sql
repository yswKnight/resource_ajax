--Apply（申请单）drop table apply
create table Apply 
(
   ApplyID            NUMBER(6)            not null,--申请单ID
   ApplyTypeID        number              not null,--申请单类型ID
   ApplyDate          DATE,--申请日期
   ApplyStatus        NUMBER,--申请单状态
   UserID             VARCHAR2(12),--申请人ID
   Approver           VARCHAR2(12),--审批人ID
   Assigner           VARCHAR2(12),--分配人ID
   Dealer             VARCHAR2(12),--处理人ID
   Phone              VARCHAR2(50),--联系电话
   ApplyTitle         VARCHAR2(50),--申请单标题
   ApplyReason        VARCHAR2(200),--申请单原因
   Enclosure          VARCHAR2(200),--附件
   Remark             VARCHAR2(500),--备注
   constraint PK_APPLY primary key (ApplyID)--申请单ID主鍵
);
begin
insert into apply values(100001,1,to_date('1991-10-10','yyyy-MM-dd'),0,'haha','piter','lisi','lisi','110','IP地址申请','新手上路','..','关系户，速度解决');
insert into apply values(100002,1,to_date('1991-10-10','yyyy-MM-dd'),1,'haha','piter','lisi','lisi','110','IP地址申请','新手上路','..','关系户，速度解决');
insert into apply values(100003,1,to_date('1991-10-10','yyyy-MM-dd'),2,'haha','piter','lisi','lisi','110','IP地址申请','新手上路','..','关系户，速度解决');
insert into apply values(100004,2,to_date('1991-10-10','yyyy-MM-dd'),3,'haha','piter','lisi','lisi','110','办公邮箱申请','新手上路','..','关系户，速度解决');
insert into apply values(100005,2,to_date('1991-10-10','yyyy-MM-dd'),4,'haha','piter','lisi','lisi','110','办公邮箱申请','新手上路','..','关系户，速度解决');
insert into apply values(100006,2,to_date('1991-10-10','yyyy-MM-dd'),3,'haha','piter','lisi','lisi','110','办公邮箱申请','新手上路','..','关系户，速度解决');
insert into apply values(100007,3,to_date('1991-10-10','yyyy-MM-dd'),0,'haha','piter','lisi','lisi','110','存储空间申请','新手上路','..','关系户，速度解决');
insert into apply values(100008,3,to_date('1991-10-10','yyyy-MM-dd'),1,'haha','piter','lisi','lisi','110','存储空间申请','新手上路','..','关系户，速度解决');
insert into apply values(100009,3,to_date('1991-10-10','yyyy-MM-dd'),2,'haha','piter','lisi','lisi','110','存储空间申请','新手上路','..','关系户，速度解决');
commit;
end;
select * from apply


--ApplyFlow（分配人设置表） drop table ApplyFlow
create table ApplyFlow 
(
   ApplyTypeID        NUMBER           not null,--申请单类型ID
   ApplyTypeName      VARCHAR2(50),        --申请单类型名称
   Assigner           VARCHAR2(12),                    --分配人
   constraint PK_APPLYFLOW primary key (ApplyTypeID) --申请单类型ID主鍵
);

--Department（部门表）drop table department
create table Department 
(
   DeptID             NUMBER(6)            not null,--部门ID
   DeptName           VARCHAR2(50),--部门名称
   Manager            VARCHAR2(12),--部门负责人
   DeptInfo           VARCHAR2(500),--备注信息
   constraint PK_DEPARTMENT primary key (DeptID)--部门ID主鍵
);


--IPAddressApply（IP地址申请单） drop table IPAddressApply
create table IPAddressApply 
(
   ApplyID            NUMBER              not null,--申请单ID
   Quantity           NUMBER,--申请数量
   Address            VARCHAR2(50),--使用地点
   PortNumber         VARCHAR2(50),--网口号码
   TimeLimit          DATE,--使用时间
   constraint PK_IPADDRESSAPPLY primary key (ApplyID)--申请单ID主鍵
);



--OfficeEmailApply（办公邮箱申请单）drop table OfficeEmailApply
create table OfficeEmailApply 
(
   ApplyID            NUMBER              not null,--申请单ID
   Zone               NUMBER,--空间
   OfficePlace        VARCHAR2(50),--办公地点
   UserName           VARCHAR2(50),--使用者姓名
   FullName           VARCHAR2(50),--姓名全拼
   constraint PK_OFFICEEMAILAPPLY primary key (ApplyID)
);

--OperateLog（申请单流程操作记录表）drop table OperateLog
create table OperateLog 
(
   ID                   NUMBER(6)            not null,--操作记录ID
   ApplyID            number             not null,--申请单ID
   OperateType        VARCHAR2(20),--操作类型
   OperateDate        DATE,--操作日期
   UserID             VARCHAR2(12),--操作人
   Describe           VARCHAR2(100),--操作说明
   Result             VARCHAR2(20),--操作结果
   constraint PK_OPERATELOG primary key (ID)--操作记录ID主鍵
);

--StorageSpaceApply（存储空间申请单）drop table StorageSpaceApply
create table StorageSpaceApply 
(
   ApplyID            NUMBER              not null,--申请单ID
   Zone               NUMBER,--空间
   InterfaceMan       VARCHAR2(50),--接口人
   Right              VARCHAR2(50),--权限
   TimeLimit          DATE,--使用期限
   constraint PK_STORAGESPACEAPPLY primary key (ApplyID)--申请单ID主鍵
);

--UserInfo(用户信息表）drop table userinfo
create table UserInfo 
(
   UserID             VARCHAR2(12)             not null,--用户ID
   Name               VARCHAR2(50),--用户名称
   Password           VARCHAR2(50),--密码
   Email              VARCHAR2(50),--电子邮件
   Telephone          VARCHAR2(50),--电话
   Type               NUMBER,--用户类型
   DeptID             NUMBER,--部门ID
   constraint PK_USER primary key (UserID)--用户ID主鍵
);


begin
insert into userinfo values('admin','管理员','123','123113131@163.com','911',0,'10');
insert into userinfo values('zhangsan','张三','123','123113131@163.com','911',1,'40');
insert into userinfo values('lisi','李四','123','123113131@163.com','911',1,'20');
insert into userinfo values('haha','哈哈','123','123113131@163.com','911',1,'20');
insert into userinfo values('piter','皮特','123','123113131@163.com','911',1,'30');
insert into userinfo values('wangwu','王五','123','123113131@163.com','911',1,'30');
commit;
end;

begin
insert into Department values('10','IT管理部','admin','12121465');
insert into Department values('20','IT支持部','lisi','12121465');
insert into Department values('30','客服部','piter','12121465');
insert into Department values('40','技术部','zhangsan','12121465');
commit;
end;

begin
insert into ApplyFlow values(1,	'IP地址申请单','	lisi');
insert into ApplyFlow values(2	,'办公邮箱申请单',	'lisi');
insert into ApplyFlow values(3	,'存储空间申请单'	,'lisi');
commit;
end;

select * from department
select userid,name from userinfo where deptid=20;

select * from ApplyFlow where rownum<=5
select * from
update userinfo set name='lisi';

select u.name,u.userid from UserInfo u where u.DeptID=20
select applyflow0_.applyTypeID as applyTyp1_1_, applyflow0_.applyTypeName as applyTyp2_1_, applyflow0_.assigner as assigner1_ from ApplyFlow applyflow0_

select * from department;
select * from userinfo for update
select password from userinfo where userid='lisi'
update userInfo u set u.password='123' where u.userID='haha'
update userInfo set password='123' where userID='lisi'
select * from officeEmailApply

select * from operateLog