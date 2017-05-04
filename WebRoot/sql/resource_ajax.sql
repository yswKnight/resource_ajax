--Apply�����뵥��drop table apply
create table Apply 
(
   ApplyID            NUMBER(6)            not null,--���뵥ID
   ApplyTypeID        number              not null,--���뵥����ID
   ApplyDate          DATE,--��������
   ApplyStatus        NUMBER,--���뵥״̬
   UserID             VARCHAR2(12),--������ID
   Approver           VARCHAR2(12),--������ID
   Assigner           VARCHAR2(12),--������ID
   Dealer             VARCHAR2(12),--������ID
   Phone              VARCHAR2(50),--��ϵ�绰
   ApplyTitle         VARCHAR2(50),--���뵥����
   ApplyReason        VARCHAR2(200),--���뵥ԭ��
   Enclosure          VARCHAR2(200),--����
   Remark             VARCHAR2(500),--��ע
   constraint PK_APPLY primary key (ApplyID)--���뵥ID���I
);
begin
insert into apply values(100001,1,to_date('1991-10-10','yyyy-MM-dd'),0,'haha','piter','lisi','lisi','110','IP��ַ����','������·','..','��ϵ�����ٶȽ��');
insert into apply values(100002,1,to_date('1991-10-10','yyyy-MM-dd'),1,'haha','piter','lisi','lisi','110','IP��ַ����','������·','..','��ϵ�����ٶȽ��');
insert into apply values(100003,1,to_date('1991-10-10','yyyy-MM-dd'),2,'haha','piter','lisi','lisi','110','IP��ַ����','������·','..','��ϵ�����ٶȽ��');
insert into apply values(100004,2,to_date('1991-10-10','yyyy-MM-dd'),3,'haha','piter','lisi','lisi','110','�칫��������','������·','..','��ϵ�����ٶȽ��');
insert into apply values(100005,2,to_date('1991-10-10','yyyy-MM-dd'),4,'haha','piter','lisi','lisi','110','�칫��������','������·','..','��ϵ�����ٶȽ��');
insert into apply values(100006,2,to_date('1991-10-10','yyyy-MM-dd'),3,'haha','piter','lisi','lisi','110','�칫��������','������·','..','��ϵ�����ٶȽ��');
insert into apply values(100007,3,to_date('1991-10-10','yyyy-MM-dd'),0,'haha','piter','lisi','lisi','110','�洢�ռ�����','������·','..','��ϵ�����ٶȽ��');
insert into apply values(100008,3,to_date('1991-10-10','yyyy-MM-dd'),1,'haha','piter','lisi','lisi','110','�洢�ռ�����','������·','..','��ϵ�����ٶȽ��');
insert into apply values(100009,3,to_date('1991-10-10','yyyy-MM-dd'),2,'haha','piter','lisi','lisi','110','�洢�ռ�����','������·','..','��ϵ�����ٶȽ��');
commit;
end;
select * from apply


--ApplyFlow�����������ñ� drop table ApplyFlow
create table ApplyFlow 
(
   ApplyTypeID        NUMBER           not null,--���뵥����ID
   ApplyTypeName      VARCHAR2(50),        --���뵥��������
   Assigner           VARCHAR2(12),                    --������
   constraint PK_APPLYFLOW primary key (ApplyTypeID) --���뵥����ID���I
);

--Department�����ű�drop table department
create table Department 
(
   DeptID             NUMBER(6)            not null,--����ID
   DeptName           VARCHAR2(50),--��������
   Manager            VARCHAR2(12),--���Ÿ�����
   DeptInfo           VARCHAR2(500),--��ע��Ϣ
   constraint PK_DEPARTMENT primary key (DeptID)--����ID���I
);


--IPAddressApply��IP��ַ���뵥�� drop table IPAddressApply
create table IPAddressApply 
(
   ApplyID            NUMBER              not null,--���뵥ID
   Quantity           NUMBER,--��������
   Address            VARCHAR2(50),--ʹ�õص�
   PortNumber         VARCHAR2(50),--���ں���
   TimeLimit          DATE,--ʹ��ʱ��
   constraint PK_IPADDRESSAPPLY primary key (ApplyID)--���뵥ID���I
);



--OfficeEmailApply���칫�������뵥��drop table OfficeEmailApply
create table OfficeEmailApply 
(
   ApplyID            NUMBER              not null,--���뵥ID
   Zone               NUMBER,--�ռ�
   OfficePlace        VARCHAR2(50),--�칫�ص�
   UserName           VARCHAR2(50),--ʹ��������
   FullName           VARCHAR2(50),--����ȫƴ
   constraint PK_OFFICEEMAILAPPLY primary key (ApplyID)
);

--OperateLog�����뵥���̲�����¼��drop table OperateLog
create table OperateLog 
(
   ID                   NUMBER(6)            not null,--������¼ID
   ApplyID            number             not null,--���뵥ID
   OperateType        VARCHAR2(20),--��������
   OperateDate        DATE,--��������
   UserID             VARCHAR2(12),--������
   Describe           VARCHAR2(100),--����˵��
   Result             VARCHAR2(20),--�������
   constraint PK_OPERATELOG primary key (ID)--������¼ID���I
);

--StorageSpaceApply���洢�ռ����뵥��drop table StorageSpaceApply
create table StorageSpaceApply 
(
   ApplyID            NUMBER              not null,--���뵥ID
   Zone               NUMBER,--�ռ�
   InterfaceMan       VARCHAR2(50),--�ӿ���
   Right              VARCHAR2(50),--Ȩ��
   TimeLimit          DATE,--ʹ������
   constraint PK_STORAGESPACEAPPLY primary key (ApplyID)--���뵥ID���I
);

--UserInfo(�û���Ϣ��drop table userinfo
create table UserInfo 
(
   UserID             VARCHAR2(12)             not null,--�û�ID
   Name               VARCHAR2(50),--�û�����
   Password           VARCHAR2(50),--����
   Email              VARCHAR2(50),--�����ʼ�
   Telephone          VARCHAR2(50),--�绰
   Type               NUMBER,--�û�����
   DeptID             NUMBER,--����ID
   constraint PK_USER primary key (UserID)--�û�ID���I
);


begin
insert into userinfo values('admin','����Ա','123','123113131@163.com','911',0,'10');
insert into userinfo values('zhangsan','����','123','123113131@163.com','911',1,'40');
insert into userinfo values('lisi','����','123','123113131@163.com','911',1,'20');
insert into userinfo values('haha','����','123','123113131@163.com','911',1,'20');
insert into userinfo values('piter','Ƥ��','123','123113131@163.com','911',1,'30');
insert into userinfo values('wangwu','����','123','123113131@163.com','911',1,'30');
commit;
end;

begin
insert into Department values('10','IT����','admin','12121465');
insert into Department values('20','IT֧�ֲ�','lisi','12121465');
insert into Department values('30','�ͷ���','piter','12121465');
insert into Department values('40','������','zhangsan','12121465');
commit;
end;

begin
insert into ApplyFlow values(1,	'IP��ַ���뵥','	lisi');
insert into ApplyFlow values(2	,'�칫�������뵥',	'lisi');
insert into ApplyFlow values(3	,'�洢�ռ����뵥'	,'lisi');
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