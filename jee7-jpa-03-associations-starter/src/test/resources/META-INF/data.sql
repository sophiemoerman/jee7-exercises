insert into person(id, firstName, lastName, birthDate, street, number, postalCode, city) values(1000, 'John', 'Doe', '1970-01-01', 'Brighton Road', '27', '1000', 'Brussels');
insert into person(id, firstName, lastName, birthDate, street, number, postalCode, city) values(2000, 'Jane', 'Doe', '1970-01-02', 'Harper Lane', '8', '2845', 'London');
insert into person(id, firstName, lastName, birthDate, street, number, postalCode, city) values(3000, 'Tyler', 'Turner', '1983-07-15', 'Masonstreet', '72B', '5874', 'Winterfell');
insert into person(id, firstName, lastName, birthDate, street, number, postalCode, city) values(4000, 'Marcia ', 'Jackson', '1975-03-28', 'Factory Lane', '100/7', '1578', 'Glasgow');
insert into person(id, firstName, lastName, birthDate, street, number, postalCode, city) values(5000, 'Allan', 'Wilson', '1964-12-28', 'Turingstreet', '1', '2547', 'Newcastle');

insert into candy_preferences(person_id, candy_color) values(1000, 'BLUE');
insert into candy_preferences(person_id, candy_color) values(2000, 'YELLOW');
insert into candy_preferences(person_id, candy_color) values(2000, 'VIOLET');
insert into candy_preferences(person_id, candy_color) values(3000, 'RED');
insert into candy_preferences(person_id, candy_color) values(3000, 'YELLOW');
insert into candy_preferences(person_id, candy_color) values(4000, 'RED');
insert into candy_preferences(person_id, candy_color) values(4000, 'GREEN');
insert into candy_preferences(person_id, candy_color) values(4000, 'BLUE');
insert into candy_preferences(person_id, candy_color) values(5000, 'RED');
insert into candy_preferences(person_id, candy_color) values(5000, 'YELLOW');
insert into candy_preferences(person_id, candy_color) values(5000, 'BLUE');

insert into candy(id, name, color, price) values(1000, 'Jolly Ranger', 'RED', 4.95);
insert into candy(id, name, color, price) values(2000, 'Pink Kisses', 'PINK', 3.99);
insert into candy(id, name, color, price) values(3000, 'Gobstopper Heart Breakers', 'BLUE', 3.24);
insert into candy(id, name, color, price) values(4000, 'Kahlua Liquor', 'VIOLET', 7.98);
insert into candy(id, name, color, price) values(5000, 'Gummy Bears', 'GREEN', 6.99);
insert into candy(id, name, color, price) values(6000, 'Sweethearts', 'VIOLET', 3.74);

insert into candy_order(id, street, number, postalCode, city, person_id) values(1000, 'Churchstreet', '27', '1080', 'Antwerp', 3000);
insert into candy_order(id, street, number, postalCode, city, person_id) values(2000, 'Manhattan', '13', '1078', 'Geel', 4000);
insert into candy_order(id, street, number, postalCode, city, person_id) values(3000, 'Abbey Road', '7', '574', 'Lipton', 5000);
insert into candy_order(id, street, number, postalCode, city, person_id) values(4000, 'Red Herring Lane', '1', '2547', 'Dublin', 3000);


insert into order_line(id, quantity, order_id, candy_id) values(1000, 50, 1000, 1000);
insert into order_line(id, quantity, order_id, candy_id) values(2000, 20, 1000, 2000);
insert into order_line(id, quantity, order_id, candy_id) values(3000, 37, 1000, 3000);
insert into order_line(id, quantity, order_id, candy_id) values(4000, 7, 2000, 4000);
insert into order_line(id, quantity, order_id, candy_id) values(5000, 10, 2000, 5000);
insert into order_line(id, quantity, order_id, candy_id) values(6000, 1000, 3000, 6000);

insert into order_line(id, quantity, order_id, candy_id) values(7000, 300, 4000, 1000);
insert into order_line(id, quantity, order_id, candy_id) values(8000, 250, 4000, 3000);