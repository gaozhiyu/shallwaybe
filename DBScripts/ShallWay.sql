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
