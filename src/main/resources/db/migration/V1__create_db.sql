CREATE TABLE client (
id BIGINT  GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
name VARCHAR (200) CHECK (LENGTH(name) >=3)
);


CREATE TABLE planet (
id VARCHAR PRIMARY KEY CHECK (id REGEXP '[A-Z0-9]+'),
name VARCHAR CHECK (LENGTH(name) >=1 AND  LENGTH(name) <=500)
);


CREATE TABLE ticket (
id BIGINT  GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
created_at TIMESTAMP,
client_id BIGINT,
from_planet_id VARCHAR,
to_planet_id VARCHAR
);


alter table ticket add constraint client_id_fk foreign key (client_id)
references client (id) on delete cascade;

alter table ticket add constraint from_planet_id_fk foreign key (from_planet_id)
references planet (id) on delete cascade;

alter table ticket add constraint to_planet_id_fk foreign key (to_planet_id)
references planet (id) on delete cascade;

