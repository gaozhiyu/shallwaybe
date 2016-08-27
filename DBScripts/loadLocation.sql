


DROP TABLE IF EXISTS location;
 
CREATE TABLE IF NOT EXISTS `location` (
  `geoname_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `locale_code` varchar(2) DEFAULT NULL,
  `continent_code` varchar(2) DEFAULT NULL,
  `continent_name` varchar(20) DEFAULT NULL,
  `country_iso_code` varchar(2) DEFAULT NULL,
  `country_name` varchar(45) DEFAULT NULL,
  `subdivision_1_iso_code` varchar(5) DEFAULT NULL,
  `subdivision_1_name` varchar(1000) DEFAULT NULL,
  `subdivision_2_iso_code` varchar(5) DEFAULT NULL,
  `subdivision_2_name` varchar(1000) DEFAULT NULL,
  `city_name` varchar(1000) DEFAULT NULL,
  `metro_code` varchar(15) DEFAULT NULL,
  `postalCode` varchar(40) DEFAULT NULL, 
  PRIMARY KEY (`geoname_id`),
  KEY `city_name` (`city_name`(767))
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;


load data infile 'shallway/GeoLiteCity-Location2.csv' into table `location` fields terminated by ',' optionally enclosed by '"' lines terminated by '\n' ignore 1 lines;
