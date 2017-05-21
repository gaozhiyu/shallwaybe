DELIMITER $$

DROP FUNCTION IF EXISTS `calculateDistance`$$

CREATE  FUNCTION `calculateDistance`(lat1 double, lon1 double, lat2 double, lon2 double) RETURNS text CHARSET latin1
BEGIN
  DECLARE dLat double;
 DECLARE dLon double;
 DECLARE lat1r double;
 DECLARE lat2r double;
 DECLARE a double;
 DECLARE b double;
 DECLARE c double;
 
  SET dLat = radians(lat2-lat1);
  set dLon = radians(lon2-lon1);
  set lat1r = radians(lat1);
  set lat2r = radians(lat2);
  set a = sin(dLat/2) * sin(dLat/2) +
        sin(dLon/2) * sin(dLon/2) * cos(lat1r) * cos(lat2r); 
  set b = 2 * atan2(sqrt(a), sqrt(1-a)); 
  set c = 6371 * b;
  return c;
END$$

DELIMITER ;


DELIMITER $$

DROP FUNCTION IF EXISTS `shallway`.`calculateCorrelation`$$

CREATE FUNCTION `calculateCorrelation`(distance double, shaketime text) RETURNS text CHARSET latin1
BEGIN
 DECLARE a double;
 DECLARE b double;
  set a = TIME_TO_SEC(TIMEDIFF(shaketime, now()))/60;
  set b = 0.7 * pow(distance/100,2) + 0.3 * pow(a/1440,2);
  return b;
END$$

DELIMITER ;



DELIMITER $$

DROP FUNCTION IF EXISTS `shallway`.`getNickname`$$

CREATE FUNCTION `getNickname`(userID TEXT) RETURNS text CHARSET utf8
BEGIN
	DECLARE userNickname TEXT;
	select nickname into userNickname from profile where userintid = userID limit 1;
	RETURN userNickname;
END$$

DELIMITER ;