-- -----------------------------------------------------
-- Table "CATEGORIAS"
-- -----------------------------------------------------
CREATE TABLE  categorias (
  "id" SERIAL NOT NULL,
  "descripcion" VARCHAR(45) NOT NULL,
  "estado" BOOLEAN NOT NULL,
  PRIMARY KEY ("id"));


-- -----------------------------------------------------
-- Table "PRODUCTOS"
-- -----------------------------------------------------
CREATE TABLE  productos (
  "id" SERIAL NOT NULL,
  "nombre" VARCHAR(45) NULL,
  "id_categoria" INT NOT NULL,
  "codigo_barras" VARCHAR(150) NULL,
  "precio" DECIMAL(16,2) NULL,
  "cantidad" INT NOT NULL,
  "estado" BOOLEAN NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_productos_categorias"
    FOREIGN KEY ("id_categoria")
    REFERENCES categorias ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "CLIENTES"
-- -----------------------------------------------------
CREATE TABLE  clientes (
  "id" VARCHAR(20) NOT NULL,
  "nombre" VARCHAR(40) NULL,
  "apellido" VARCHAR(100) NULL,
  "telefono" NUMERIC NULL,
  "direccion" VARCHAR(80) NULL,
  "correo" VARCHAR(70) NULL,
  PRIMARY KEY ("id"));


-- -----------------------------------------------------
-- Table "COMPRAS"
-- -----------------------------------------------------
CREATE TABLE  compras (
  "id" SERIAL NOT NULL,
  "id_cliente" VARCHAR(20) NOT NULL,
  "fecha" TIMESTAMP NULL,
  "metodo_pago" CHAR(1) NULL,
  "comentario" VARCHAR(300) NULL,
  "estado" CHAR(1) NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_compras_clientes"
    FOREIGN KEY ("id_cliente")
    REFERENCES clientes ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "COMPRAS_PRODUCTOS"
-- -----------------------------------------------------
CREATE TABLE  compras_productos (
  "id_compra" INT NOT NULL,
  "id_producto" INT NOT NULL,
  "cantidad" INT NULL,
  "total" DECIMAL(16,2) NULL,
  "estado" BOOLEAN NULL,
  PRIMARY KEY ("id_compra", "id_producto"),
  CONSTRAINT "fk_compras_productos_productos"
    FOREIGN KEY ("id_producto")
    REFERENCES productos ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_compras_productos_compras"
    FOREIGN KEY ("id_compra")
    REFERENCES compras ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);