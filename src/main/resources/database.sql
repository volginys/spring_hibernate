create table users (
    id        bigint       auto_increment primary key,
    name      varchar(255) not null,
    lastname  varchar(255) not null,
    email     varchar(255) not null,
    car_id    bigint       not null,

    FOREIGN KEY (car_id) REFERENCES cars (id)
)
    ENGINE = InnoDB;


create table cars (
    id        bigint       auto_increment primary key,
    model     varchar(255) not null,
    series    bigint       not null
)
    ENGINE = InnoDB;