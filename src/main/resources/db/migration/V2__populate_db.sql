
INSERT INTO client (name) VALUES ('Obi Van'), ('Ja Ja Bins'), ('Kwaigon Jin'), ('General Grivus'), ('Queen Amidala'),
('Palpatin'), ('Master Yoda'), ('Asoka Tano'), ('Lord Duku'), ('Mira Jade');

INSERT INTO planet (id, name) VALUES ('X1', 'Melmak'), ('R2D2', 'Korusant'), ('OPTIMUS1', 'Cyberthron'),
('BABYLON5', 'Minbar'), ('SECTOR_CAPSULAR','Tarsonis');

INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id) VALUES
('2009-06-04 18:25:08', 1, 'X1', 'R2D2'),
('2012-06-04 19:25:08', 2, 'OPTIMUS1', 'R2D2'),
('2013-07-05 20:25:08', 3, 'X1', 'OPTIMUS1'),
('2009-07-05 21:25:08', 4, 'X1', 'BABYLON5'),
('2020-04-01 10:25:08', 5, 'SECTOR_CAPSULAR', 'R2D2'),
('2011-08-09 23:25:08', 6, 'R2D2', 'X1'),
('2006-06-06 00:25:08', 7, 'OPTIMUS1', 'R2D2'),
('2005-05-05 04:25:08', 8, 'BABYLON5', 'R2D2'),
('2009-08-12 05:25:08', 9, 'BABYLON5', 'X1'),
('2019-06-04 15:25:08', 10, 'X1', 'SECTOR_CAPSULAR');