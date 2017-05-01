DELIMITER $$

DROP FUNCTION IF EXISTS `shallway`.`getNickname`$$

CREATE DEFINER=`root`@`localhost` FUNCTION `getNickname`(userID TEXT) RETURNS text CHARSET utf8
BEGIN
	DECLARE userNickname TEXT;
	select nickname into userNickname from profile where userintid = userID limit 1;
	RETURN userNickname;
END$$

DELIMITER ;