drop table amenities if exists;

create table amenities (
    amenityID BIGINT NOT NULL PRIMARY KEY,
    longitude     DOUBLE NOT NULL,
    latitude      DOUBLE NOT NULL,
    name          VARCHAR(255),
    address       VARCHAR(255),
    website       VARCHAR(255),
    opening_hours  VARCHAR(255),
    name_en VARCHAR(255),
    phone_number VARCHAR(255),
    country VARCHAR(255),
    city VARCHAR(255),
    type INT,
    visits INT DEFAULT 0,
);