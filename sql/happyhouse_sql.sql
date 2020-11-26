-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema happyhouse
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema happyhouse
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `happyhouse` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `happyhouse` ;

-- -----------------------------------------------------
-- Table `happyhouse`.`baseaddress`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`baseaddress` (
  `dongcode` VARCHAR(30) NOT NULL,
  `city` VARCHAR(30) NOT NULL,
  `gugun` VARCHAR(30) NOT NULL,
  `dong` VARCHAR(30) NOT NULL,
  `lat` VARCHAR(20) NULL DEFAULT NULL,
  `lng` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`dongcode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`covidtestcenter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`covidtestcenter` (
  `valid_date` DATE NOT NULL,
  `city` VARCHAR(30) NULL DEFAULT NULL,
  `gugun` VARCHAR(30) NULL DEFAULT NULL,
  `hospital_name` VARCHAR(100) NULL DEFAULT NULL,
  `address` VARCHAR(200) NULL DEFAULT NULL,
  `phone` VARCHAR(45) NULL DEFAULT NULL,
  `week_time` VARCHAR(50) NULL DEFAULT NULL,
  `saturday_time` VARCHAR(50) NULL DEFAULT NULL,
  `holiday_time` VARCHAR(50) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`dongcode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`dongcode` (
  `dongcode` VARCHAR(10) NOT NULL,
  `city` VARCHAR(30) NULL DEFAULT NULL,
  `gugun` VARCHAR(30) NULL DEFAULT NULL,
  `dong` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`dongcode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`guguncode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`guguncode` (
  `gugun_code` VARCHAR(10) NOT NULL,
  `gugun_name` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`gugun_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`houseinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`houseinfo` (
  `houseinfo_id` INT NOT NULL AUTO_INCREMENT,
  `dong` VARCHAR(30) NOT NULL,
  `AptName` VARCHAR(50) NOT NULL,
  `code` VARCHAR(30) NULL DEFAULT NULL,
  `buildYear` VARCHAR(30) NULL DEFAULT NULL,
  `jibun` VARCHAR(30) NULL DEFAULT NULL,
  `lat` VARCHAR(30) NULL DEFAULT NULL,
  `lng` VARCHAR(30) NULL DEFAULT NULL,
  `img` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`houseinfo_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5990
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `happyhouse`.`housedeal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`housedeal` (
  `deal_id` INT NOT NULL AUTO_INCREMENT,
  `dealAmount` VARCHAR(50) NOT NULL,
  `dealYear` VARCHAR(30) NULL DEFAULT NULL,
  `dealMonth` VARCHAR(30) NULL DEFAULT NULL,
  `dealDay` VARCHAR(30) NULL DEFAULT NULL,
  `area` VARCHAR(30) NULL DEFAULT NULL,
  `floor` VARCHAR(30) NULL DEFAULT NULL,
  `type` VARCHAR(30) NULL DEFAULT NULL,
  `rentMoney` VARCHAR(30) NULL DEFAULT NULL,
  `houseinfo_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`deal_id`),
  INDEX `housedeal_houseinfo_houseinfo_di_fk_idx` (`houseinfo_id` ASC) VISIBLE,
  CONSTRAINT `housedeal_houseinfo_houseinfo_di_fk`
    FOREIGN KEY (`houseinfo_id`)
    REFERENCES `happyhouse`.`houseinfo` (`houseinfo_id`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 68865
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `happyhouse`.`userinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`userinfo` (
  `userid` VARCHAR(20) NOT NULL,
  `userpw` VARCHAR(16) NOT NULL,
  `username` VARCHAR(10) NOT NULL,
  `useremail` VARCHAR(30) NOT NULL,
  `userphone` VARCHAR(20) NOT NULL,
  `role` INT NULL DEFAULT '0',
  PRIMARY KEY (`userid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`interest`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`interest` (
  `userid` VARCHAR(20) NOT NULL,
  `deal_id` INT NOT NULL,
  PRIMARY KEY (`userid`, `deal_id`),
  INDEX `deal_id` (`deal_id` ASC) VISIBLE,
  CONSTRAINT `interest_ibfk_1`
    FOREIGN KEY (`deal_id`)
    REFERENCES `happyhouse`.`housedeal` (`deal_id`),
  CONSTRAINT `interest_userinfo_userid_fk`
    FOREIGN KEY (`userid`)
    REFERENCES `happyhouse`.`userinfo` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`noticeboard`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`noticeboard` (
  `bnum` INT NOT NULL AUTO_INCREMENT,
  `btitle` VARCHAR(50) NULL DEFAULT 'no title',
  `userid` VARCHAR(20) NOT NULL,
  `bread_cnt` INT NOT NULL DEFAULT '0',
  `bwritedate` DATE NOT NULL,
  `bcontent` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`bnum`),
  INDEX `noticeboard_userinfo_user_id_fk_idx` (`userid` ASC) VISIBLE,
  CONSTRAINT `noticeboard_userinfo_user_id_fk`
    FOREIGN KEY (`userid`)
    REFERENCES `happyhouse`.`userinfo` (`userid`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 26
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`qna_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`qna_type` (
  `qna_type` INT NOT NULL AUTO_INCREMENT,
  `qna_description` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`qna_type`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`qna_board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`qna_board` (
  `qna_id` INT NOT NULL AUTO_INCREMENT,
  `qna_title` VARCHAR(50) NOT NULL,
  `qna_writer` VARCHAR(20) NULL DEFAULT NULL,
  `qna_content` TEXT NOT NULL,
  `qna_writedate` DATE NULL DEFAULT NULL,
  `qna_type` INT NULL DEFAULT NULL,
  PRIMARY KEY (`qna_id`),
  INDEX `qna_writer` (`qna_writer` ASC) VISIBLE,
  INDEX `qna_type` (`qna_type` ASC) VISIBLE,
  CONSTRAINT `qna_board_ibfk_1`
    FOREIGN KEY (`qna_writer`)
    REFERENCES `happyhouse`.`userinfo` (`userid`),
  CONSTRAINT `qna_board_ibfk_2`
    FOREIGN KEY (`qna_type`)
    REFERENCES `happyhouse`.`qna_type` (`qna_type`))
ENGINE = InnoDB
AUTO_INCREMENT = 26
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`qna_reply`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`qna_reply` (
  `qna_reply_id` INT NOT NULL AUTO_INCREMENT,
  `qna_reply_writer` VARCHAR(20) NULL DEFAULT NULL,
  `qna_reply_content` TEXT NOT NULL,
  `qna_reply_writedate` DATE NULL DEFAULT NULL,
  `qna_board_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`qna_reply_id`),
  INDEX `qna_reply_writer` (`qna_reply_writer` ASC) VISIBLE,
  INDEX `qna_board_id` (`qna_board_id` ASC) VISIBLE,
  CONSTRAINT `qna_reply_ibfk_1`
    FOREIGN KEY (`qna_reply_writer`)
    REFERENCES `happyhouse`.`userinfo` (`userid`),
  CONSTRAINT `qna_reply_ibfk_2`
    FOREIGN KEY (`qna_board_id`)
    REFERENCES `happyhouse`.`qna_board` (`qna_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`safetyhospital`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`safetyhospital` (
  `valid_date` DATE NOT NULL,
  `city` VARCHAR(30) NULL DEFAULT NULL,
  `gugun` VARCHAR(30) NULL DEFAULT NULL,
  `hospital_name` VARCHAR(100) NULL DEFAULT NULL,
  `address` VARCHAR(200) NULL DEFAULT NULL,
  `diagnosis_type` CHAR(1) NULL DEFAULT NULL,
  `phone` VARCHAR(45) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`school`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`school` (
  `schoolcode` VARCHAR(30) NOT NULL,
  `schoolname` VARCHAR(50) NOT NULL,
  `dongcode` VARCHAR(30) NULL DEFAULT NULL,
  `address` VARCHAR(100) NOT NULL,
  `lat` VARCHAR(20) NULL DEFAULT NULL,
  `lng` VARCHAR(20) NULL DEFAULT NULL,
  `studentperclass` INT NULL DEFAULT NULL,
  `studentperteacehr` INT NULL DEFAULT NULL,
  PRIMARY KEY (`schoolcode`),
  INDEX `dongcode` (`dongcode` ASC) VISIBLE,
  CONSTRAINT `school_ibfk_1`
    FOREIGN KEY (`dongcode`)
    REFERENCES `happyhouse`.`baseaddress` (`dongcode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`sidocode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`sidocode` (
  `sido_code` VARCHAR(10) NOT NULL,
  `sido_name` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `happyhouse`.`store`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `happyhouse`.`store` (
  `store_num` VARCHAR(20) NOT NULL,
  `store_name` VARCHAR(50) NOT NULL,
  `store_type` VARCHAR(20) NOT NULL,
  `store_address` VARCHAR(100) NOT NULL,
  `store_lat` VARCHAR(20) NULL DEFAULT NULL,
  `store_lng` VARCHAR(20) NULL DEFAULT NULL,
  `dongcode` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`store_num`),
  INDEX `dongcode` (`dongcode` ASC) VISIBLE,
  CONSTRAINT `store_ibfk_1`
    FOREIGN KEY (`dongcode`)
    REFERENCES `happyhouse`.`baseaddress` (`dongcode`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
