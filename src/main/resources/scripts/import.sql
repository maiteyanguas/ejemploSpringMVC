INSERT INTO `persona` (`id`,`nombre`,`apellido`,`fechaNacimiento`) VALUES (1,'Aimar','Olaizola','1977-10-15');
INSERT INTO `persona` (`id`,`nombre`,`apellido`,`fechaNacimiento`) VALUES (2,'Pablo','Berasaluze','1979-05-24');
INSERT INTO `persona` (`id`,`nombre`,`apellido`,`fechaNacimiento`) VALUES (3,'David','Merino','1989-02-21');
INSERT INTO `persona` (`id`,`nombre`,`apellido`,`fechaNacimiento`) VALUES (4,'Julian','Retegi','1972-12-13');
INSERT INTO `persona` (`id`,`nombre`,`apellido`,`fechaNacimiento`) VALUES (5,'Iñaki','Perurena','1987-12-05');

INSERT INTO `direccion` (`id`,`calle`,`portal`,`piso`,`letra`,`otros`,`codigo_postal`,`municipio`,`persona_id`) VALUES (1,'San Francisco Javier',15,NULL,NULL,'Katxalenea etxea',36301,'Iruñea',1);
INSERT INTO `direccion` (`id`,`calle`,`portal`,`piso`,`letra`,`otros`,`codigo_postal`,`municipio`,`persona_id`) VALUES (2,'Paseo Butrón',42,2,'D',NULL,20401,'Hondarribia',1);
INSERT INTO `direccion` (`id`,`calle`,`portal`,`piso`,`letra`,`otros`,`codigo_postal`,`municipio`,`persona_id`) VALUES (3,'Lezo',5,3,'B','',20301,'Leitza',2);
INSERT INTO `direccion` (`id`,`calle`,`portal`,`piso`,`letra`,`otros`,`codigo_postal`,`municipio`,`persona_id`) VALUES (4,'Bustitzuri',5,5,'C','',36301,'Iruñea',2);