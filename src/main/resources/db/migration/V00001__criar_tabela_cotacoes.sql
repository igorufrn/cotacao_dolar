CREATE TABLE `bancodados`.`cotacao` (
  `id_cotacao` INT NOT NULL AUTO_INCREMENT,
  `cotacao_compra` DOUBLE NOT NULL,
  `cotacao_venda` DOUBLE NOT NULL,
  `dt_requisicao` TIMESTAMP NOT NULL,
  `dt_cotacao` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id_cotacao`),
  UNIQUE INDEX `id_cotacao_UNIQUE` (`id_cotacao` ASC) VISIBLE);
