/*TODO actualize script */

create table car
(
    id             int primary key auto_increment,
    mark           varchar(255) not null,
    model          varchar(255),
    odometerstatus int
);
create table expense
(
    id         int primary key auto_increment,
    car_id     int,
    created_at timestamp,
    value      decimal(10, 2) not null,
    description varchar(255) not null,
    FOREIGN KEY (car_id) REFERENCES car (id)
);