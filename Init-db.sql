USE test;

DROP TABLE IF EXISTS product;
CREATE TABLE product
(
  id int PRIMARY KEY AUTO_INCREMENT,
  categories VARCHAR(100),
  name VARCHAR(100) NOT NULL,
  price int(8),
)

INSERT INTO `product` (`categories`,`name`,`price`)
VALUES
  ("Металлоштакетник", "Классик", 2.45),
  ("Металлоштакетник, "Юникс", 2.45),
  ("Металлоштакетник", "Версаль", 2.6),
  ("Забор-жалюзи", "Альфа", 3.1),
  ("Забор-жалюзи", "Сигма", 3.2),
  ("Забор-жалюзи", "Гамма", 3.3))

