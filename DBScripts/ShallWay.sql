DELIMITER $$

DROP FUNCTION IF EXISTS `calculateDistance`$$

CREATE DEFINER=`root`@`localhost` FUNCTION `calculateDistance`(lat1 double, lon1 double, lat2 double, lon2 double) RETURNS text CHARSET latin1
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