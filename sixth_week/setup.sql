-- Setup

SET foreign_key_checks = 0;
DROP TABLE IF EXISTS customers,flights,main;
SET foreign_key_checks = 1;

CREATE TABLE IF NOT EXISTS customers(
  id int NOT NULL AUTO_INCREMENT,
  customer_name VARCHAR(50),
  customer_status VARCHAR(50),
  customer_mileage INT,
  PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS flights(
  flight_number VARCHAR(50),
  aircraft VARCHAR(50),
  flight_mileage int,
  aircraft_seats SMALLINT,
  PRIMARY KEY(flight_number)
);

CREATE TABLE IF NOT EXISTS main(
  id int NOT NULL AUTO_INCREMENT,
  flight_number VARCHAR(50),
  customer_id int,
  PRIMARY KEY(id),
  FOREIGN KEY(flight_number) REFERENCES flights(flight_number),
  FOREIGN KEY(customer_id) REFERENCES customers(id)
);

INSERT INTO customers (customer_name, customer_status, customer_mileage)
VALUES
('Agustine Riviera', 'Silver', 115235),
('Alaina Sepulvida', 'None', 6008),
('Tom Jones', 'Gold', 205767),
('Sam Rio', 'None', 2653),
('Jessica James', 'Silver', 127656),
('Ana Janco', 'Silver', 136773),
('Jennifer Cortez', 'Gold', 300582),
('Christian Janco', 'Silver', 14642);

INSERT INTO flights (flight_number, aircraft, flight_mileage, aircraft_seats)
VALUES
('DL143', 'Boeing 747', 135 , 400),
('DL122', 'Airbus A330',4370, 236),
('DL53', 'Boeing 777', 2078,264),
('DL222', 'Boeing 777', 1765,264),
('DL37', 'Boeing 747', 531,400);

INSERT INTO main (flight_number, customer_id)
VALUES
('DL143', 1),
('DL122', 1),
('DL122', 2),
('DL122', 3),
('DL53', 4),
('DL143', 4),
('DL222', 3),
('DL143', 5),
('DL222', 7),
('DL122', 5),
('DL37', 4),
('DL222', 8);

