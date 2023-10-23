CREATE SCHEMA IF NOT EXISTS `atividadeloja` DEFAULT CHARACTER SET utf8 ;
USE `atividadeloja` ;

CREATE TABLE IF NOT EXISTS `atividadeloja`.`tb_fornecedores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `atividadeloja`.`tb_categorias` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `atividadeloja`.`tb_produtos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `preco` INT NOT NULL,
  `tb_fornecedores_id` INT NOT NULL,
  `tb_categorias_id` INT NOT NULL,
  PRIMARY KEY (`id`, `tb_fornecedores_id`, `tb_categorias_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_tb_produtos_tb_fornecedores_idx` (`tb_fornecedores_id` ASC) VISIBLE,
  INDEX `fk_tb_produtos_tb_categorias1_idx` (`tb_categorias_id` ASC) VISIBLE,
  CONSTRAINT `fk_tb_produtos_tb_fornecedores`
    FOREIGN KEY (`tb_fornecedores_id`)
    REFERENCES `atividadeloja`.`tb_fornecedores` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_produtos_tb_categorias1`
    FOREIGN KEY (`tb_categorias_id`)
    REFERENCES `atividadeloja`.`tb_categorias` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `atividadeloja`.`tb_clientes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `atividadeloja`.`tb_vendas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `data` DATETIME NOT NULL,
  `tb_clientes_id` INT NOT NULL,
  PRIMARY KEY (`id`, `tb_clientes_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_tb_vendas_tb_clientes1_idx` (`tb_clientes_id` ASC) VISIBLE,
  CONSTRAINT `fk_tb_vendas_tb_clientes1`
    FOREIGN KEY (`tb_clientes_id`)
    REFERENCES `atividadeloja`.`tb_clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `atividadeloja`.`tb_itensVenda` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quantidade` INT NOT NULL,
  `precoUnitario` INT NOT NULL,
  `tb_vendas_id` INT NOT NULL,
  `tb_produtos_id` INT NOT NULL,
  PRIMARY KEY (`id`, `tb_vendas_id`, `tb_produtos_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_tb_itensVenda_tb_vendas1_idx` (`tb_vendas_id` ASC) VISIBLE,
  INDEX `fk_tb_itensVenda_tb_produtos1_idx` (`tb_produtos_id` ASC) VISIBLE,
  CONSTRAINT `fk_tb_itensVenda_tb_vendas1`
    FOREIGN KEY (`tb_vendas_id`)
    REFERENCES `atividadeloja`.`tb_vendas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_itensVenda_tb_produtos1`
    FOREIGN KEY (`tb_produtos_id`)
    REFERENCES `atividadeloja`.`tb_produtos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


INSERT INTO tb_categorias (nome) VALUES ('Eletrônicos');
INSERT INTO tb_categorias (nome) VALUES ('Roupas');
INSERT INTO tb_categorias (nome) VALUES ('Alimentos');


INSERT INTO tb_fornecedores (nome) VALUES ('Fornecedor A');
INSERT INTO tb_fornecedores (nome) VALUES ('Fornecedor B');
INSERT INTO tb_fornecedores (nome) VALUES ('Fornecedor C');


INSERT INTO tb_clientes (nome) VALUES ('Iago');
INSERT INTO tb_clientes (nome) VALUES ('Joao');
INSERT INTO tb_clientes (nome) VALUES ('Marcia');


INSERT INTO tb_produtos (nome, tb_categorias_id, tb_fornecedores_id, Preco) VALUES ('mouse', 1, 1, 50.00);
INSERT INTO tb_produtos (nome, tb_categorias_id, tb_fornecedores_id, Preco) VALUES ('calça', 2, 2, 25.00);
INSERT INTO tb_produtos (nome, tb_categorias_id, tb_fornecedores_id, Preco) VALUES ('tomate', 3, 3, 10.00);


INSERT INTO tb_vendas (tb_clientes_id, Data) VALUES (1, '2023-10-20T10:53:58');
INSERT INTO tb_vendas (tb_clientes_id, Data) VALUES (2, '2023-10-21T13:45:10');
INSERT INTO tb_vendas (tb_clientes_id, Data) VALUES (3, '2023-10-22T18:11:58');


INSERT INTO tb_itensvenda (tb_vendas_id, tb_produtos_id, Quantidade, precoUnitario) VALUES (1, 1, 2, 50.00);
INSERT INTO tb_itensvenda (tb_vendas_id, tb_produtos_id, Quantidade, precoUnitario) VALUES (2, 2, 3, 25.00);
INSERT INTO tb_itensvenda (tb_vendas_id, tb_produtos_id, Quantidade, precoUnitario) VALUES (3, 3, 4, 10.00);


SELECT p.nome AS "Nome do Produto",
       iv.Quantidade AS "Quantidade Vendida",
       iv.precoUnitario AS "Valor Unitário"
FROM tb_itensvenda iv
INNER JOIN tb_produtos p ON iv.tb_produtos_id = p.ID;

SELECT v.Data AS "Data da Venda",
       c.nome AS "Nome do Cliente"
FROM tb_vendas v
INNER JOIN tb_clientes c ON v.tb_clientes_id = c.ID;

SELECT p.id AS "Código do Produto",
       p.nome AS "Nome do Produto",
       cat.nome AS "Nome da Categoria",
       f.nome AS "Nome do Fornecedor"
FROM tb_produtos p
INNER JOIN tb_categorias cat ON p.tb_categorias_id = cat.ID
INNER JOIN tb_fornecedores f ON p.tb_fornecedores_id = f.ID;

select * from 

