CREATE TABLE blog(
  id int NOT NULL AUTO_INCREMENT,
  author VARCHAR(50),
  title VARCHAR(255),
  word_count int,
  views int,
  PRIMARY KEY(id)
);

INSERT INTO blog(author,title,word_count,views)
VALUES
('Maria Charlotte', 'Best Paint Colors', 814, 14),
('Juan Perez', 'Small Space Decorating Tips', 1146, 221),
('Maria Charlotte', 'Hot Accessories', 986, 105),
('Maria Charlotte', 'Mixing Textures', 765, 22),
('Juan Perez', 'Kitchen Refresh', 1242, 307),
('Maria Charlotte', 'Homemade Art Hacks', 1002, 193),
('Gemma Alcocer', 'Refinishing Wood Floors', 1571, 7542);
