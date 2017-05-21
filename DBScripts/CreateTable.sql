drop table if exists profile;
create table profile (
   userintid varchar(64) not null,
   email varchar(128) not null,
   password varchar(128) not null,
   nickname varchar(32) not null,
   gender varchar(4),
   dateofbirth date,
   profilephoto timestamp null default null,
   wrongtrypwd integer default 0,
   otp varchar(128),
   otpexpirytime timestamp null default null,
   wrongtryotp integer default 0,
   country varchar(128) not null,
   province varchar(128) not null,
   city varchar(128) not null,
   googlecountry varchar(128),
   googleprovince varchar(128),
   googlecity varchar(128),
   longitude double not null,
   latitude double not null,   
   lastupdate timestamp default current_timestamp,
   createtime timestamp default current_timestamp,
   lastaddressupdate timestamp default current_timestamp,
   signature varchar(1024) default null,
   primary key (userintid),
   unique (email)
)character set = utf8;

drop table if exists addresshistory;
create table addresshistory (
   userintid varchar(64) not null,
   addresssequenceid varchar(64) not null,
   country varchar(128),
   province varchar(128),
   city varchar(128),
   updatetime timestamp default current_timestamp,
   placetype varchar(1) not null,
   primary key (addresssequenceid)
)character set = utf8;

drop table if exists shallway;
create table shallway (
   sequenceid bigint unsigned not null auto_increment,
   dateid varchar(64) not null,	
   userintid varchar(64) not null,
   country varchar(128) default null,
   province varchar(128) default null,
   city varchar(128) default null,
   place varchar(128) default null,
   starttime date,
   endtime date,
   posttime timestamp default current_timestamp,
   carpool boolean default null,
   freetour boolean default null,
   hotelshare boolean default null,
   freeguide boolean default null,
   title varchar(512) default null,
   contact varchar(128) default null,
   description blob default null,
   deletestatus boolean default false,
   primary key (sequenceid),
   unique (dateid)
)character set = utf8;

drop table if exists latestcoordinate;
create table latestcoordinate (
   userintid varchar(64) not null,
   longitude double not null,
   latitude double not null,
   lastshaketime timestamp,
   country varchar(128),
   province varchar(128),
   city varchar(128),
   lastaddressupdate timestamp default current_timestamp,
   primary key (userintid)
)character set = utf8;

create or replace view shallwayview as select b.nickname, a.* from shallway a join profile b on a.userintid = b.userintid;

drop table if exists follow;
create table follow (
   sequenceid bigint unsigned not null auto_increment,
   id varchar(64) not null,
   dateid varchar(64) not null,
   followerintid varchar(64) not null,
   followtime timestamp default current_timestamp,
   deletestatus boolean default false,
   primary key (sequenceid),
   unique (id)
)character set = utf8;

drop table if exists reply;
create table reply (
   sequenceid bigint unsigned not null auto_increment,
   id varchar(64) not null,
   dateid varchar(64) not null,
   srcreplyid varchar(64),
   sourceuserintid varchar(64) not null,
   replierintid varchar(64) not null,
   replytime timestamp default current_timestamp,
   replycontents blob not null,
   deletestatus boolean default false,
   primary key (sequenceid),
   unique (id)
)character set = utf8;

drop table if exists message;
create table message (
   messageid varchar(64) not null,
   messagecontents blob not null,
   senderintid varchar(64) not null,
   sendernickname varchar(32) not null,
   receiverintid varchar(64) not null,
   sendtime timestamp default current_timestamp,
   sendstatus boolean default false,
   primary key (messageid)
)character set = utf8;

drop table if exists blacklist;
create table blacklist (
   entryid varchar(64) not null,
   userintid varchar(64) not null,
   blockuserintid varchar(64) not null,
   deletestatus boolean default false,
   createtime timestamp default current_timestamp,
   updatetime timestamp default current_timestamp,
   primary key (entryid)
)character set = utf8;
