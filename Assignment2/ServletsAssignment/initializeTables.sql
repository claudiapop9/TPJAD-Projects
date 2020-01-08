CREATE TABLE tpjad_assig2_ejb.City (
	id BIGINT NOT NULL,
	name varchar(100) NULL,
	region varchar(100) NULL,
	country varchar(100) NULL
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

CREATE TABLE `tpjad_assig2_ejb`.`person` (
  `id` BIGINT NOT NULL,
  `cnp` VARCHAR(100) NULL,
  `firstName` VARCHAR(100) NULL,
  `lastName` VARCHAR(100) NULL,
  `city` BIGINT NULL,
  PRIMARY KEY (`id`),
  INDEX `idx_city_id` (`city` ASC) VISIBLE,
  CONSTRAINT `person_fk`
    FOREIGN KEY (`city`)
    REFERENCES `tpjad_assig2_ejb`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO tpjad_assig2_ejb.city (id, name, region, country) VALUES (1 , "Mexico City", "Mexico", "Mexico");
INSERT INTO tpjad_assig2_ejb.city (id, name, region, country) VALUES (2 , "Lagos", "Nigeria", "Nigeria");
INSERT INTO tpjad_assig2_ejb.city (id, name, region, country) VALUES (3 , "Baia Mare", "MM", "Romania");
INSERT INTO tpjad_assig2_ejb.city (id, name, region, country) VALUES (4 , "Satu Mare", "SM", "Romania");
INSERT INTO tpjad_assig2_ejb.city (id, name, region, country) VALUES (5 , "Baia Sprie", "MM", "Romania");
INSERT INTO tpjad_assig2_ejb.city (id, name, region, country) VALUES (6 , "Apa", "SM", "Romania");

INSERT INTO tpjad_assig2_ejb.person (id, cnp, firstName, lastName, city) VALUES (1 , "19852631456", "Marius","Popescu",2);
INSERT INTO tpjad_assig2_ejb.person (id, cnp, firstName, lastName, city) VALUES (2 , "29852631456", "Maria","Pop",1);
INSERT INTO tpjad_assig2_ejb.person (id, cnp, firstName, lastName, city) VALUES (3 , "19702065456", "Cornel","Escu",6);
INSERT INTO tpjad_assig2_ejb.person (id, cnp, firstName, lastName, city) VALUES (4 , "29705126356", "Andreea","Andreescu",4);
INSERT INTO tpjad_assig2_ejb.person (id, cnp, firstName, lastName, city) VALUES (5 , "19807226316", "Marius","Covaci",5);
INSERT INTO tpjad_assig2_ejb.person (id, cnp, firstName, lastName, city) VALUES (6 , "17109263145", "Alex","Nadajde",6);


