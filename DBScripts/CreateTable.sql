DROP TABLE IF EXISTS Profile;
create table Profile (
   ShallWayID VARCHAR(64) NOT NULL,
   Email VARCHAR(128) NOT NULL,
   Password VARCHAR(64) NOT NULL,
   NickName VARCHAR(32) NOT NULL,
   Gender VARCHAR(4) NOT NULL,
   DateOfBirth Date,
   Country VARCHAR(128) NOT NULL,
   City VARCHAR(128) NOT NULL,
   LastUpdate TIMESTAMP,
   CreateTime TIMESTAMP,
   LastAddressUpdate TIMESTAMP,
   Status VARCHAR(1024) default NULL,
   PRIMARY KEY (ShallWayID),
   UNIQUE (Email)
);

DROP TABLE IF EXISTS RegisterAddressHistory;
create table RegisterAddressHistory (
   ShallWayID VARCHAR(64) NOT NULL,
   AddressSequenceID VARCHAR(64) NOT NULL,
   Country VARCHAR(128) NOT NULL,
   City VARCHAR(128) NOT NULL,
   UpdateTime TIMESTAMP,
   PRIMARY KEY (AddressSequenceID)
);

DROP TABLE IF EXISTS ShallWay;
create table ShallWay (
   ID VARCHAR(64) NOT NULL,	
   ShallWayID VARCHAR(64) NOT NULL,
   Country VARCHAR(128) default NULL,
   City VARCHAR(128) default NULL,
   Place VARCHAR(128) default NULL,
   StartTime TIMESTAMP,
   EndTime TIMESTAMP,
   PostTime TIMESTAMP,
   CarPool BOOLEAN default NULL,
   FreeTour BOOLEAN default NULL,
   HotelShare BOOLEAN default NULL,
   FreeGuide BOOLEAN default NULL,
   Title VARCHAR(512) default NULL,
   Contact VARCHAR(128) default NULL,
   Description BLOB default NULL,
   PRIMARY KEY (ID)
);

DROP TABLE IF EXISTS LatestCoordinate;
create table LatestCoordinate (
   ShallWayID VARCHAR(64) NOT NULL,
   Longitude DOUBLE NOT NULL,
   Latitude DOUBLE NOT NULL,
   LastShakeTime TIMESTAMP,
   Country VARCHAR(128) NOT NULL,
   City VARCHAR(128) NOT NULL,
   LastAddressUpdate TIMESTAMP,
   PRIMARY KEY (ShallWayID)
);

