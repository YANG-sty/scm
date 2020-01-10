# drop database if exists scm;

# create database scm default character set utf8;

# use scm;

drop table if exists supplier;
drop table if exists account;
drop table if exists department;
drop table if exists goods;
drop table if exists store_house;
drop table if exists account_records;
drop table if exists buy_order;
drop table if exists buy_order_detail;
drop table if exists return_order;
drop table if exists return_order_detail;
drop table if exists sys_param;



/*============================*/
/* Table: 管理员表结构 		  */
/*============================*/
create table account
(
    /* 管理员编号,自动增长 */
    acc_id                  int not null auto_increment,
    /* 管理员登录名  */
    acc_login               varchar(20),
    /* 管理员姓名  */
    acc_name                varchar(20),
    /* 管理员密码 */
    acc_pass                varchar(20),
    /* 设置编号为主键 */
    primary key (acc_id)
);

/*==============================================================*/
/* Table: 供应商表	                                        */
/*==============================================================*/

# create table supplier
# (
#     sup_id               int not null auto_increment,
#     sup_name             varchar(20),
#     sup_linkman          varchar(20),
#     sup_phone            varchar(11),
#     sup_address          varchar(100),
#     sup_remark           varchar(200),
#     primary key (sup_id)
# );
create table supplier
(
    sup_id               int not null,
    sup_name             varchar(20),
    sup_linkman          varchar(20),
    sup_phone            varchar(11),
    sup_address          varchar(100),
    sup_remark           varchar(100),
    sup_pay              decimal(12,2),
    sup_type             varchar(10),
    primary key (sup_id)
);

/*==============================================================*/
/* Table: 部门表                                        */
/*==============================================================*/
create table department
(
    dept_id int not null auto_increment,
    dept_name varchar(20),
    dept_address varchar(200),
    primary key (dept_id)
);
/*==============================================================*/
/* Table: store_house                                           */
/*
   sh_id                仓库编号,
   sh_name              仓库名称,
   sh_responsible       责任人,
   sh_phone             联系电话,
   sh_address           联系地址,
   sh_type              仓库类型,
   sh_remark            备注,
*/
/*==============================================================*/
create table store_house
(
    sh_id                varchar(10) not null,
    sh_name              varchar(20),
    sh_responsible       varchar(20),
    sh_phone             varchar(11),
    sh_address           varchar(50),
    sh_type              varchar(10),
    sh_remark            varchar(100),
    primary key (sh_id)
);
/*==============================================================*/
/* Table: goods                                                 */
/*==============================================================*/
/*
goods_Id         商品编号
   goods_name           商品名称
   goods_unit          商品单位
   goods_type           类型
   goods_color          颜色,
   goods_store          商品仓库,
   goods_limit          库存下限,
   goods_commission     提成,
   goods_producer       生产商
   goods_remark         备注,
   goods_sel_price        售价
   goods_buy_price         进价
                                               */
/*==============================================================*/
create table goods
(
    goods_Id             varchar(36) not null,
    goods_name           varchar(20),
    goods_unit           varchar(10),
    goods_type           varchar(10),
    goods_color          varchar(10),
    goods_store          int,
    goods_limit          int,
    goods_commission     decimal(12,2),
    goods_producer       varchar(50),
    goods_remark         varchar(100),
    goods_sel_price      decimal(12,2),
    goods_buy_price      decimal(12,2),
    primary key (goods_Id)
);
/* 添加管理员数据, */
insert into account (acc_login,acc_pass) values ('admin','admin');
insert into account (acc_login,acc_pass) values ('admin2','admin2');
/* 添加供应商数据, */
insert into supplier (sup_id,sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values (1,'苹果供应商','小张','12388888887','广州花都','普通供应商',1000,1);
insert into supplier (sup_id,sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values (2,'三星供应商','小王','12388888888','广州增城','普通供应商',200000,1);
insert into supplier (sup_id,sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values (3,'华为供应商','小王','12388888889','广东深圳','一级供应商',30000,2);
insert into supplier (sup_id,sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values (4,'TCL供应商','小王','12388888666','广州增城','普通供应商',400,1);
insert into supplier (sup_id,sup_name,sup_linkman,sup_phone,sup_address,sup_remark,sup_pay,sup_type) values (5,'Nokia供应商','小王','12388888777','广东深圳','一级供应商',5000000,2);
/*添加商品信息*/
insert into goods (goods_Id,goods_name,goods_unit,goods_color,goods_remark,goods_sel_price,goods_buy_price)
values('1','note4','部','1','red note4',2500.00,2000.00);
insert into goods (goods_Id,goods_name,goods_unit,goods_color,goods_remark,goods_sel_price,goods_buy_price)
values('2','note5','部','5','red note5',3500.00,3000.00);
insert into goods (goods_Id,goods_name,goods_unit,goods_color,goods_remark,goods_sel_price,goods_buy_price)
values('3','note6','部','6','blue note5',4500.00,4000.00);
/*添加仓库信息*/
insert into store_house(sh_id,sh_name,sh_address) values('1','主仓库','广东省广州市');
insert into store_house(sh_id,sh_name,sh_address) values('2','深圳分仓库','广东省深圳市');
/**添加部门数据*/
insert into department(dept_id, dept_name, dept_address) values (1,'人力部','test人力部');
insert into department(dept_id, dept_name, dept_address) values (2,'财务部','test财务部');

select * from account;
select * from supplier;
select * from department;

/*=================================进化模块===================================*/


/*==============================================================*/
/* Table: account_records
编号		ar_id,
供货商编号	sup_id，
日期		ar_date，
单号(不同类型单号不一样）ad_order_id，
类型(业务类型）ar_bus_type，
应付		ar_payable，
实付		ar_paid，
欠款		ar_arrears，
优惠金额	ar_discount，
经办人		ar_attn，
操作员		ar_operator。
备注		ar_remark
                                    */
/*==============================================================*/
create table account_records
(
    ar_id                varchar(36) not null,
    sup_id               int,
    ar_date              date,
    ar_order_id          varchar(36),
    ar_bus_type          varchar(10),
    ar_payable           decimal(12,2),
    ar_paid              decimal(12,2),
    ar_arrears           decimal(12,2),
    ar_discount          decimal(12,2),
    ar_attn              varchar(20),
    ar_operator          int,
    ar_remark            varchar(100),
    primary key (ar_id)
);

/*==============================================================*/
/* Table: buy_order
单号     	bo_id，
供货商  	sup_id，
仓库      	sh_id，
收货日期  	bo_date，
应付（实付+欠款+优惠）bo_payable，
实付      	bo_paid，
欠款		bo_Arrears，
原始单号	bo_original_id，
备注		bo_remark，
经办人		bo_attn，
操作员		operator

                                           */
/*==============================================================*/
create table buy_order
(
    bo_id                varchar(36) not null,
    sup_id               int,
    sh_id                varchar(10),
    bo_date              date,
    bo_payable           decimal(12,2),
    bo_paid              decimal(12,2),
    bo_arrears           decimal(12,2),
    bo_original          varchar(20),
    bo_remark            varchar(100),
    bo_attn              varchar(20),
    bo_operator          int,
    primary key (bo_id)
);

/*==============================================================*/
/* Table: buy_order_detail
编号		bod_id：
商品ID	goods_id，备用
 goods_name           varchar(20),
   goods_type           varchar(10),
   goods_color          varchar(10),
单位		goods_unit，
数量 		bod_amount，
进价		bod_buy_price，
总金额（可无）bod_total_price，
 采购单号	bo_id，
手机串号列表（##分隔）bod_IMEI_list
                                 */
/*==============================================================*/
create table buy_order_detail
(
    bod_id               varchar(36) not null,
    goods_id             varchar(36),
    goods_name           varchar(20),
    goods_unit           varchar(10),
    goods_type           varchar(10),
    goods_color          varchar(10),
    bod_amount           int,
    bod_buy_price        decimal(12,2),
    bod_total_price     decimal(12,2),
    bo_id                varchar(36),
    bod_imei_list        text,
    primary key (bod_id)
);

/*==============================================================*/
/* Table: return_order
单号		roId，
供货商	sup_id，
仓库		sh_id，
退货日期	ro_date，
应退金额	ro_payable，
实退金额	ro_Paid，
备注，	ro_remark,
经办人	ro_attn，
操作员	ro_operator


                                       */
/*==============================================================*/
create table return_order
(
    ro_id                varchar(36) not null,
    sup_id               int,
    sh_id                varchar(10),
    ro_date              date,
    ro_payable           decimal(12,2),
    ro_paid              decimal(12,2),
    ro_remark            varchar(100),
    ro_attn              varchar(20),
    ro_operator          int,
    primary key (ro_id)
);

/*==============================================================*/
/* Table: return_order_deatil
编号		rod_id：
商品		goods_id，//备用
 goods_name           varchar(20),
   goods_type           varchar(10),
   goods_color          varchar(10),
单位		goods_unit，
数量		rod_amount，
退货单价	rod_return_price，
总金额（可无）rod_total_price，
 手机串号列表（##分隔）rod_imei_list
                             */
/*==============================================================*/
create table return_order_detail
(
    rod_id              varchar(36) not null,
    goods_id             varchar(36),
    goods_unit           varchar(10),
    goods_name           varchar(20),
    goods_type           varchar(10),
    goods_color          varchar(10),
    rod_amount           int,
    rod_return_price     decimal(12,2),
    rod_total_price      decimal(12,2),
    rod_imei_list        text,
    ro_id                varchar(36),
    primary key (rod_id)
);

/*====================================系统参数表==============================*/
/*==============================================================*/
/* Table: sys_param                                             */
/*==============================================================*/
create table sys_param
(
    sys_param_id         bigint  auto_increment,
    sys_param_field      varchar(50),
    sys_param_value      varchar(500),
    sys_param_text       varchar(50),
    sys_param_type       varchar(2),
    primary key (sys_param_id)
);
insert into sys_param(sys_param_field,sys_param_value,sys_param_type) values('shId','select s.sh_id as sys_param_value,s.sh_name as sys_param_text from store_house s','1');


insert into sys_param(sys_param_field,sys_param_value,sys_param_text) values('supType','1','一级供应商');
insert into sys_param(sys_param_field,sys_param_value,sys_param_text) values('supType','2','二级供应商');
insert into sys_param(sys_param_field,sys_param_value,sys_param_text) values('supType','3','普通供应商');
insert into sys_param(sys_param_field,sys_param_value,sys_param_text) values('goodsColor','1','红色');
insert into sys_param(sys_param_field,sys_param_value,sys_param_text) values('goodsColor','2','绿色');
insert into sys_param(sys_param_field,sys_param_value,sys_param_text) values('goodsColor','3','蓝色');
select * from sys_param;

