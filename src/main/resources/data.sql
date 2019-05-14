INSERT INTO menus( discount_percent) VALUES(10);
INSERT INTO menus( discount_percent) VALUES(15);
INSERT INTO menus( discount_percent) VALUES(0);
INSERT INTO menus( discount_percent) VALUES(0);
INSERT INTO menus( discount_percent) VALUES(5);

INSERT INTO restaurants(name, menu_id, image_url) VALUES ('McBurgers',1,'imagine1');
INSERT INTO restaurants(name, menu_id, image_url) VALUES ('Dominoes',2,'imagine2');
INSERT INTO restaurants(name, menu_id, image_url) VALUES ('cv',3,'imagine3');
INSERT INTO restaurants(name, menu_id, image_url) VALUES ('asdasdas',4,'imagine4');
INSERT INTO restaurants(name, menu_id, image_url) VALUES ('McBergbvbncbvncnbvers',5,'imagine5');

INSERT INTO dishes(name,cost,menu_id) VALUES('bla',23,1);
INSERT INTO dishes(name,cost,menu_id) VALUES('bla1',31.50,1);
INSERT INTO dishes(name,cost,menu_id) VALUES('bla2',19.75,1);
INSERT INTO dishes(name,cost,menu_id) VALUES('bla3',12.50,1);
INSERT INTO dishes(name,cost,menu_id) VALUES('bla4',14,1);

INSERT INTO dishes(name,cost,menu_id) VALUES('bla5',26.30,2);
INSERT INTO dishes(name,cost,menu_id) VALUES('bla6',55,2);
INSERT INTO dishes(name,cost,menu_id) VALUES('bla7',22.50,2);
INSERT INTO dishes(name,cost,menu_id) VALUES('bla8',21.25,2);
INSERT INTO dishes(name,cost,menu_id) VALUES('bla9',31.50,2);

INSERT INTO dishes(name,cost,menu_id) VALUES('bla5',35.50,3);
INSERT INTO dishes(name,cost,menu_id) VALUES('bla6',55,3);
INSERT INTO dishes(name,cost,menu_id) VALUES('bla7',72.50,3);
INSERT INTO dishes(name,cost,menu_id) VALUES('bla8',74,3);
INSERT INTO dishes(name,cost,menu_id) VALUES('bla9',78,3);

INSERT INTO dishes(name,cost,menu_id) VALUES('bla5',56,4);
INSERT INTO dishes(name,cost,menu_id) VALUES('bla6',55,4);
INSERT INTO dishes(name,cost,menu_id) VALUES('bla7',25.75,4);
INSERT INTO dishes(name,cost,menu_id) VALUES('bla8',39.25,4);
INSERT INTO dishes(name,cost,menu_id) VALUES('bla9',31.50,4);

INSERT INTO dishes(name,cost,menu_id) VALUES('bla5',66.50,5);
INSERT INTO dishes(name,cost,menu_id) VALUES('bla6',50.50,5);
INSERT INTO dishes(name,cost,menu_id) VALUES('bla7',22.25,5);
INSERT INTO dishes(name,cost,menu_id) VALUES('bla8',26.75,5);
INSERT INTO dishes(name,cost,menu_id) VALUES('bla9',9.50,5);

INSERT INTO customers(email,first_name,last_name,token) VALUES('customerTest.1@genericmail.com','john','doe','dG9rZW4x');
INSERT INTO customers(email,first_name,last_name,token) VALUES('customerTest.2@genericmail.com','jake','paul','dG9rZW4y');
INSERT INTO customers(email,first_name,last_name,token) VALUES('customerTest.3@genericmail.com','gigi','becali','dG9rZW4z');
INSERT INTO customers(email,first_name,last_name,token) VALUES('customerTest.4@genericmail.com','costel','fantastic','dG9rZW40');
INSERT INTO customers(email,first_name,last_name,token) VALUES('customerTest.5@genericmail.com','customers','customerescu','dG9rZW41');

INSERT INTO purchases(date,customer_id, extra_fees) VALUES (now(),1, 7.22);
INSERT INTO purchases(date,customer_id, extra_fees) VALUES (now(),1, 3.46);
INSERT INTO purchases(date,customer_id, extra_fees) VALUES (now(),2, 0.00);
INSERT INTO purchases(date,customer_id, extra_fees) VALUES (now(),2, 23.05);
INSERT INTO purchases(date,customer_id, extra_fees) VALUES (now(),3, 0);
INSERT INTO purchases(date,customer_id, extra_fees) VALUES (now(),3, 10);
INSERT INTO purchases(date,customer_id, extra_fees) VALUES (now(),4, 3);
INSERT INTO purchases(date,customer_id, extra_fees) VALUES (now(),4, 23);
INSERT INTO purchases(date,customer_id, extra_fees) VALUES (now(),5, 24.54);
INSERT INTO purchases(date,customer_id, extra_fees) VALUES (now(),5, 23.33);
INSERT INTO purchases(date,customer_id, extra_fees) VALUES (now(),null, 99.99);
INSERT INTO purchases(date,customer_id, extra_fees) VALUES (now(),null, 100.1);

INSERT INTO order_items(quantity, dish_id, purchase_id) VALUES(2,3,1);
INSERT INTO order_items(quantity, dish_id, purchase_id) VALUES(2,1,2);
INSERT INTO order_items(quantity, dish_id, purchase_id) VALUES(2,2,3);
INSERT INTO order_items(quantity, dish_id, purchase_id) VALUES(2,4,4);
INSERT INTO order_items(quantity, dish_id, purchase_id) VALUES(2,4,5);
INSERT INTO order_items(quantity, dish_id, purchase_id) VALUES(2,5,6);
INSERT INTO order_items(quantity, dish_id, purchase_id) VALUES(2,3,7);
INSERT INTO order_items(quantity, dish_id, purchase_id) VALUES(2,2,8);
INSERT INTO order_items(quantity, dish_id, purchase_id) VALUES(2,1,9);
INSERT INTO order_items(quantity, dish_id, purchase_id) VALUES(2,3,10);
INSERT INTO order_items(quantity, dish_id, purchase_id) VALUES(3,3,11);
INSERT INTO order_items(quantity, dish_id, purchase_id) VALUES(1,5,12);

