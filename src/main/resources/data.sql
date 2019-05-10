INSERT INTO restaurant(name, menu_id, image_url) VALUES ('McBurgers',1,'imagine1');
INSERT INTO restaurant(name, menu_id, image_url) VALUES ('Dominoes',2,'imagine2');
INSERT INTO restaurant(name, menu_id, image_url) VALUES ('cv',3,'imagine3');
INSERT INTO restaurant(name, menu_id, image_url) VALUES ('asdasdas',4,'imagine4');
INSERT INTO restaurant(name, menu_id, image_url) VALUES ('McBergbvbncbvncnbvers',5,'imagine5');

INSERT INTO dish(name,cost,menu_id) VALUES('bla',232,1);
INSERT INTO dish(name,cost,menu_id) VALUES('bla1',312,2);
INSERT INTO dish(name,cost,menu_id) VALUES('bla2',232,3);
INSERT INTO dish(name,cost,menu_id) VALUES('bla3',232,5);
INSERT INTO dish(name,cost,menu_id) VALUES('bla4',57,2);
INSERT INTO dish(name,cost,menu_id) VALUES('bla5',756,2);
INSERT INTO dish(name,cost,menu_id) VALUES('bla6',55,4);
INSERT INTO dish(name,cost,menu_id) VALUES('bla7',22,1);
INSERT INTO dish(name,cost,menu_id) VALUES('bla8',232,4);
INSERT INTO dish(name,cost,menu_id) VALUES('bla9',31,5);

INSERT INTO menu( discount_percent) VALUES(1);
INSERT INTO menu( discount_percent) VALUES(2);
INSERT INTO menu( discount_percent) VALUES(3);
INSERT INTO menu( discount_percent) VALUES(4);
INSERT INTO menu( discount_percent) VALUES(5);

INSERT INTO customer(email,first_name,last_name,token) VALUES('customerTest.1@genericmail.com','john','doe','dG9rZW4x');
INSERT INTO customer(email,first_name,last_name,token) VALUES('customerTest.2@genericmail.com','jake','paul','dG9rZW4y');
INSERT INTO customer(email,first_name,last_name,token) VALUES('customerTest.3@genericmail.com','gigi','becali','dG9rZW4z');
INSERT INTO customer(email,first_name,last_name,token) VALUES('customerTest.4@genericmail.com','costel','fantastic','dG9rZW40');
INSERT INTO customer(email,first_name,last_name,token) VALUES('customerTest.5@genericmail.com','customer','customerescu','dG9rZW41');

INSERT INTO purchase(date,customer_id) VALUES (now(),1);
INSERT INTO purchase(date,customer_id) VALUES (now(),1);
INSERT INTO purchase(date,customer_id) VALUES (now(),2);
INSERT INTO purchase(date,customer_id) VALUES (now(),2);
INSERT INTO purchase(date,customer_id) VALUES (now(),3);
INSERT INTO purchase(date,customer_id) VALUES (now(),3);
INSERT INTO purchase(date,customer_id) VALUES (now(),4);
INSERT INTO purchase(date,customer_id) VALUES (now(),4);
INSERT INTO purchase(date,customer_id) VALUES (now(),5);
INSERT INTO purchase(date,customer_id) VALUES (now(),5);
INSERT INTO purchase(date,customer_id) VALUES (now(),null);
INSERT INTO purchase(date,customer_id) VALUES (now(),null);



INSERT INTO order_item(quantity, dish_id, purchase_id) VALUES(2,3,1);
INSERT INTO order_item(quantity, dish_id, purchase_id) VALUES(2,1,2);
INSERT INTO order_item(quantity, dish_id, purchase_id) VALUES(2,2,3);
INSERT INTO order_item(quantity, dish_id, purchase_id) VALUES(2,4,4);
INSERT INTO order_item(quantity, dish_id, purchase_id) VALUES(2,4,5);
INSERT INTO order_item(quantity, dish_id, purchase_id) VALUES(2,5,6);
INSERT INTO order_item(quantity, dish_id, purchase_id) VALUES(2,3,7);
INSERT INTO order_item(quantity, dish_id, purchase_id) VALUES(2,2,8);
INSERT INTO order_item(quantity, dish_id, purchase_id) VALUES(2,1,9);
INSERT INTO order_item(quantity, dish_id, purchase_id) VALUES(2,3,10);
INSERT INTO order_item(quantity, dish_id, purchase_id) VALUES(3,3,11);
INSERT INTO order_item(quantity, dish_id, purchase_id) VALUES(1,5,12);

