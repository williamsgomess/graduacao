-- MySQL Script generated by MySQL Workbench
-- Sun Sep 29 03:02:58 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema graduacao_spring
-- -----------------------------------------------------


-- -----------------------------------------------------
-- Table `graduacao_spring`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `graduacao_spring`.`curso` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `graduacao_spring`.`aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `graduacao_spring`.`aluno` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `matricula` VARCHAR(45) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `curso_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`, `curso_id`),
  UNIQUE INDEX `matricula_UNIQUE` (`matricula` ASC) VISIBLE,
  INDEX `fk_aluno_curso1_idx` (`curso_id` ASC) VISIBLE,
  CONSTRAINT `fk_aluno_curso1`
    FOREIGN KEY (`curso_id`)
    REFERENCES `graduacao_spring`.`curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `graduacao_spring`.`diploma_aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `graduacao_spring`.`diploma_aluno` (
  `codigo` VARCHAR(255) NOT NULL,
  `descricao` VARCHAR(255) NOT NULL,
  `data_hora_criacao` DATETIME NULL,
  `data_criacao` DATE NULL,
  `hora_criacao` TIME NULL,
  `aluno_id` BIGINT NOT NULL,
  PRIMARY KEY (`codigo`, `aluno_id`),
  UNIQUE INDEX `codigo_UNIQUE` (`codigo` ASC) VISIBLE,
  INDEX `fk_diploma_aluno_aluno_idx` (`aluno_id` ASC) VISIBLE,
  CONSTRAINT `fk_diploma_aluno_aluno`
    FOREIGN KEY (`aluno_id`)
    REFERENCES `graduacao_spring`.`aluno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;