create or replace database pokemon;

create table pokemon.entrenador(
id int,
nombre varchar(20),
pokedollar int);

INSERT INTO pokemon.ENTRENADOR VALUES (0,'ADMIN',2000);

create table pokemon.pokemon(
id int,
nombre varchar(20),
vida int,
ataque int,
defensa	int,
ataqueSp int,
defensaSpint int,
velocidad int,
stamina	int,
nivel int,
tipo1 varchar(20),
tipo2 varchar(20),    
imagen varchar(20),
sonido varchar(20));

INSERT INTO pokemon.POKEMON VALUES(1,'CHARMANDER',100,100,100,100,100,100,100,1,'FIRE','NULL','ch.png','charmander.mp3');
INSERT INTO pokemon.POKEMON VALUES(2,'PIKACHU',100,100,100,100,100,100,100,1,'ELECTRIC','NULL','pk.png','pikachu.mp3');
INSERT INTO pokemon.POKEMON VALUES(3,'RATATA',100,100,100,100,100,100,100,1,'NORMAL','NULL','ratata.png','ratata.mp3');
INSERT INTO pokemon.POKEMON VALUES(4,'SQUIRTLE',100,100,100,100,100,100,100,1,'NORMAL','NULL','sc.png','squirtle.mp3');



create table pokemon.movimiento(
id int,
nombre varchar(20),
categoria varchar(20),
potencia int,
tipo varchar(20),
estado varchar(20),
turnos int,
coste_estamina int,
mejora float);


insert into pokemon.movimiento (id,nombre,categoria,potencia,coste_estamina) VALUES(1,'PATADA','ATAQUE',10,20);

insert into pokemon.movimiento (id,nombre,categoria,potencia,coste_estamina) VALUES(2,'PUTIASO','ATAQUE',40,20);

insert into pokemon.movimiento (id,nombre,categoria,potencia,coste_estamina) VALUES(3,'CABEZAZO','ATAQUE',30,20);

create table pokemon.pokemon_entrenador(
id int,
id_pokedex int,
mote varchar(20),
id_entrenador int,
vida int,
ataque int,
defensa	int,
ataque_sp int,
defensa_sp int,
velocidad int,
nivel int,
id_movimiento1 int,
id_movimiento2 int,
id_movimiento3 int,
id_movimiento4 int,
id_objeto int,
fertilidad int,
exp int,
equipo varchar(2));

INSERT INTO pokemon.POKEMON_ENTRENADOR VALUES (0, 1, 'PAQUITO69', 0, 100, 5, 5, 5, 5, 5, 1, 1, 0, 0, 0, 0, 5, 0, 'SI');

CREATE table pokemon.objecto(
id INT,
nombre varchar(20),
precio int,
ataque double,
defensa double,
defensa_sp double,
ataque_sp double,
velocidad double,
estamina double
);


INSERT INTO pokemon.objecto VALUES (0,'NULO',0,1,1,1,1,1,1);
INSERT INTO pokemon.objecto VALUES (1,'PESA',20,1.2,1.2,1,1,0.8,1);
INSERT INTO pokemon.objecto VALUES (2,'PLUMA',30,1,0.8,0.8,1,1.3,1);

create table pokemon.objeto_entrenador(
id_objeto Int,
id_entrenador int,
cantidad int);

