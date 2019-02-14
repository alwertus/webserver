database H2
For this example, we start the H2 server with:
$ java -jar bin/h2-1.4.196.jar -baseDir ~/tmp/h2dbs

localhost:8082

ALTER USER sa SET PASSWORD 's$cret'

CREATE TABLE IF NOT EXISTS cars(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(150), price INT);
INSERT INTO cars(name, price) VALUES('Audi', 52642);
INSERT INTO cars(name, price) VALUES('Mercedes', 57127);
INSERT INTO cars(name, price) VALUES('Skoda', 9000);
INSERT INTO cars(name, price) VALUES('Volvo', 29000);
INSERT INTO cars(name, price) VALUES('Bentley', 350000);
INSERT INTO cars(name, price) VALUES('Citroen', 21000);
INSERT INTO cars(name, price) VALUES('Hummer', 41400);
INSERT INTO cars(name, price) VALUES('Volkswagen', 21600);

"jdbc:h2:tcp://localhost:9092/testdb"
jdbc:h2:tcp://localhost:9095/mem:test_database;MODE=MySQL
jdbc:h2:mem:testdb