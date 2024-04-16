-- -----------------------------------------------------
-- Table "CATEGORIAS"
-- -----------------------------------------------------
CREATE TABLE  categories (
  "id" SERIAL NOT NULL,
  "description" VARCHAR(45) NOT NULL,
  "status" BOOLEAN NOT NULL,
  PRIMARY KEY ("id"));


-- -----------------------------------------------------
-- Table "PRODUCTOS"
-- -----------------------------------------------------
CREATE TABLE  products (
  "id" SERIAL NOT NULL,
  "name" VARCHAR(45) NULL,
  "id_category" INT NOT NULL,
  "barcode" VARCHAR(150) NULL,
  "price" DECIMAL(16,2) NULL,
  "stock" INT NOT NULL,
  "status" BOOLEAN NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_products_categories"
    FOREIGN KEY ("id_category")
    REFERENCES categories ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "CLIENTES"
-- -----------------------------------------------------
CREATE TABLE  customers (
  "id" VARCHAR(20) NOT NULL,
  "name" VARCHAR(40) NULL,
  "last_name" VARCHAR(100) NULL,
  "phone" NUMERIC NULL,
  "address" VARCHAR(80) NULL,
  "email" VARCHAR(70) NULL,
  PRIMARY KEY ("id"));


-- -----------------------------------------------------
-- Table "COMPRAS"
-- -----------------------------------------------------
CREATE TABLE  buys (
  "id" SERIAL NOT NULL,
  "customer_id" VARCHAR(20) NOT NULL,
  "date" TIMESTAMP NULL,
  "payment_method" CHAR(1) NULL,
  "comment" VARCHAR(300) NULL,
  "status" CHAR(1) NULL,
  PRIMARY KEY ("id"),
  CONSTRAINT "fk_buys_customers"
    FOREIGN KEY ("customer_id")
    REFERENCES customers ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table "COMPRAS_PRODUCTOS"
-- -----------------------------------------------------
CREATE TABLE  buys_products (
  "buy_id" INT NOT NULL,
  "product_id" INT NOT NULL,
  "amount" INT NULL,
  "total" DECIMAL(16,2) NULL,
  "status" BOOLEAN NULL,
  PRIMARY KEY ("buy_id", "product_id"),
  CONSTRAINT "fk_buys_products_products"
    FOREIGN KEY ("product_id")
    REFERENCES products ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_buys_products_buys"
    FOREIGN KEY ("buy_id")
    REFERENCES buys ("id")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);