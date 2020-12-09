CREATE TABLE IF NOT EXISTS Price (
  vehicle_id INT PRIMARY KEY auto_increment,
  currency VARCHAR(3),
  price DOUBLE
);

INSERT IGNORE INTO Price (vehicle_id, currency, price) VALUES (1, 'EUR', 1000.0);
INSERT IGNORE INTO Price (vehicle_id, currency, price) VALUES (2, 'EUR', 2000.0);
INSERT IGNORE INTO Price (vehicle_id, currency, price) VALUES (3, 'EUR', 3000.0);
INSERT IGNORE INTO Price (vehicle_id, currency, price) VALUES (4, 'EUR', 4000.0);
INSERT IGNORE INTO Price (vehicle_id, currency, price) VALUES (5, 'EUR', 5000.0);

