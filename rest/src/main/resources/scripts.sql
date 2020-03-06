use cities;

CREATE TABLE city
(
    id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(256) NOT NULL,
    description varchar(256) NOT NULL
);
CREATE UNIQUE INDEX city_id_uindex ON city (id);



insert into city (name, description) VALUES ('Амстердам','Посетите музей Ван
Гога');
insert into city (name, description) VALUES ('Париж','Поднимитесь на Эйфелеву
 башню, посетите Лувр и не забудьте про французские булочки');
insert into city (name, description) VALUES ('Рим','Навестите Папу =) Я про
того, что в Ватикане');
insert into city (name, description) VALUES ('Прага','Прогуляйтесь по
Карловому мосту и попробуйте главную "достопримечательность" Праги - пиво');
insert into city (name, description) VALUES ('Барселона','Можно сходить в
музей Пикассо, если вы фанат искусства! или в музей ФК "Барселона", если вы
фанат футбола');
insert into city (name, description) VALUES ('Санкт-Петербург','Храм
Спаса-на-Крови, Васильевский остров, Петергоф, ну а для любителей впечатлений
 - Кунсткамера');


