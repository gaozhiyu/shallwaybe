DROP TABLE IF EXISTS Profile;
create table Profile (
   UserIntID VARCHAR(64) NOT NULL,
   Email VARCHAR(128) NOT NULL,
   Password VARCHAR(128) NOT NULL,
   Nickname VARCHAR(32) NOT NULL,
   Gender VARCHAR(4),
   DateOfBirth Date,
   ProfilePhoto BOOLEAN,
   Country VARCHAR(128) NOT NULL,
   Province VARCHAR(128) NOT NULL,
   City VARCHAR(128) NOT NULL,
   GoogleCountry VARCHAR(128),
   GoogleProvince VARCHAR(128),
   GoogleCity VARCHAR(128),
   Longitude DOUBLE NOT NULL,
   Latitude DOUBLE NOT NULL,   
   LastUpdate TIMESTAMP,
   CreateTime TIMESTAMP,
   LastAddressUpdate TIMESTAMP,
   Signature VARCHAR(1024) default NULL,
   PRIMARY KEY (UserIntID),
   UNIQUE (Email)
)character set = utf8;

DROP TABLE IF EXISTS AddressHistory;
create table AddressHistory (
   UserIntID VARCHAR(64) NOT NULL,
   AddressSequenceID VARCHAR(64) NOT NULL,
   Country VARCHAR(128),
   Province VARCHAR(128),
   City VARCHAR(128),
   UpdateTime TIMESTAMP,
   PlaceType VARCHAR(1) NOT NULL,
   PRIMARY KEY (AddressSequenceID)
)character set = utf8;

DROP TABLE IF EXISTS ShallWay;
create table ShallWay (
   DateID VARCHAR(64) NOT NULL,	
   UserIntID VARCHAR(64) NOT NULL,
   Country VARCHAR(128) default NULL,
   Province VARCHAR(128) default NULL,
   City VARCHAR(128) default NULL,
   Place VARCHAR(128) default NULL,
   StartTime Date,
   EndTime Date,
   PostTime TIMESTAMP,
   CarPool BOOLEAN default NULL,
   FreeTour BOOLEAN default NULL,
   HotelShare BOOLEAN default NULL,
   FreeGuide BOOLEAN default NULL,
   Title VARCHAR(512) default NULL,
   Contact VARCHAR(128) default NULL,
   Description BLOB default NULL,
   PRIMARY KEY (DateID)
)character set = utf8;

DROP TABLE IF EXISTS LatestCoordinate;
create table LatestCoordinate (
   UserIntID VARCHAR(64) NOT NULL,
   Longitude DOUBLE NOT NULL,
   Latitude DOUBLE NOT NULL,
   LastShakeTime TIMESTAMP,
   Country VARCHAR(128),
   Province VARCHAR(128),
   City VARCHAR(128),
   LastAddressUpdate TIMESTAMP,
   PRIMARY KEY (UserIntID)
)character set = utf8;

CREATE OR REPLACE VIEW ShallWayView AS select b.Nickname, a.* from shallway a join profile b on a.userintid = b.userintid;

DROP TABLE IF EXISTS Follow;
create table Follow (
   ID VARCHAR(64) NOT NULL,
   DateID VARCHAR(64) NOT NULL,
   FollowerIntID VARCHAR(64) NOT NULL,
   FollowTime TIMESTAMP,
   PRIMARY KEY (ID)
)character set = utf8;

DROP TABLE IF EXISTS Reply;
create table Reply (
   ID VARCHAR(64) NOT NULL,
   DateID VARCHAR(64) NOT NULL,
   ReplierIntID VARCHAR(64) NOT NULL,
   ReplyTime TIMESTAMP,
   ReplyContents BLOB NOT NULL,
   PRIMARY KEY (ID)
)character set = utf8;

DROP TABLE IF EXISTS Message;
create table Message (
   MessageID VARCHAR(64) NOT NULL,
   MessageContents BLOB NOT NULL,
   SenderIntID VARCHAR(64) NOT NULL,
   ReceiverIntID VARCHAR(64) NOT NULL,
   SendTime TIMESTAMP,
   SendStatus BOOLEAN default false,
   PRIMARY KEY (MessageID)
)character set = utf8;

