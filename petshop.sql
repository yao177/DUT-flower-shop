/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016-12-6 16:38:28                           */
/*==============================================================*/


drop table if exists account;

drop table if exists pet;

drop table if exists petOwner;

drop table if exists petStore;

/*==============================================================*/
/* Table: account                                               */
/*==============================================================*/
create table account
(
   id                   int not null auto_increment,
   pet_id               int,
   seller_id            int,
   deal_type            int,
   buyer_id             int,
   price                int,
   deal_time            timestamp,
   primary key (id)
);

/*==============================================================*/
/* Table: pet                                                   */
/*==============================================================*/
create table pet
(
   id                   int not null auto_increment,
   owner_id             int,
   store_id             int,
   name                 char(10),
   type_name            char(256),
   health               int,
   love                 int,
   birthday             timestamp,
   primary key (id)
);

/*==============================================================*/
/* Table: petOwner                                              */
/*==============================================================*/
create table petOwner
(
   id                   int not null auto_increment,
   name                 char(10),
   password             char(10),
   money                int,
   primary key (id)
);

/*==============================================================*/
/* Table: petStore                                              */
/*==============================================================*/
create table petStore
(
   id                   int not null auto_increment,
   name                 char(10),
   password             char(10),
   balance              int,
   primary key (id)
);

alter table account add constraint FK_account_pet foreign key (pet_id)
      references pet (id) on delete restrict on update restrict;

alter table account add constraint FK_account_petOwner foreign key (seller_id)
      references petOwner (id) on delete restrict on update restrict;

alter table pet add constraint FK_petOwner_pet foreign key (owner_id)
      references petOwner (id) on delete restrict on update restrict;

alter table pet add constraint FK_pet_petStore foreign key (store_id)
      references petStore (id) on delete restrict on update restrict;

