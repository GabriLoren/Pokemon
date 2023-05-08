CREATE TABLE pokedex(
pokedex_num INT PRIMARY KEY,
name VARCHAR(20) UNIQUE NOT NULL,
type1 VARCHAR(10),
type2 VARCHAR(10),
base_vit INT,
base_atk INT,
base_def INT,
base_sdef INT,
base_satk INT,
base_spd INT,
max_vit INT,
max_atk INT,
max_def INT,
max_sdef INT,
max_satk INT,
max_spd INT,
base_lvl INT DEFAULT(1),
evolution_lvl INT,
sprite VARCHAR(50)
);

CREATE TABLE trainer(
trainer_id INT PRIMARY KEY,
name VARCHAR(20) UNIQUE NOT NULL,
pokedollar INT
);

CREATE TABLE obj(
obj_id INT PRIMARY KEY,
name VARCHAR(10) UNIQUE NOT NULL,
buff DOUBLE,
debuff DOUBLE
);

CREATE TABLE move(
move_id INT PRIMARY KEY,
name VARCHAR(20) UNIQUE NOT NULL,
type VARCHAR(10),
power INT,
status VARCHAR(20),
turns INT,
buff DOUBLE,
stat VARCHAR(10),
stamina_cost INT,
lvl_requirement INT,
category VARCHAR(10),
dmg_type VARCHAR(10)
);

CREATE TABLE pokemon_trainer(
pokemon_id INT PRIMARY KEY,
pokedex_num INT,
trainer_id INT,
nickname VARCHAR(20),
type1 VARCHAR(10),
type2 VARCHAR(10),
vitality INT,
attack INT,
defense INT,
sp_defense INT,
sp_attack INT,
speed INT,
stamina INT,
gender CHAR(1),
level INT,
in_team BOOLEAN,
exp INT,
fertility INT,
move1 INT,
move2 INT,
move3 INT,
move4 INT,
object INT,
CONSTRAINT pokedex_fk FOREIGN KEY (pokedex_num) REFERENCES pokedex(pokedex_num),
CONSTRAINT trainer_fk FOREIGN KEY (trainer_id) REFERENCES trainer(trainer_id),
CONSTRAINT move1_fk FOREIGN KEY (move1) REFERENCES move(move_id),
CONSTRAINT move2_fk FOREIGN KEY (move2) REFERENCES move(move_id),
CONSTRAINT move3_fk FOREIGN KEY (move3) REFERENCES move(move_id),
CONSTRAINT move4_fk FOREIGN KEY (move4) REFERENCES move(move_id),
CONSTRAINT object_fk FOREIGN KEY (object) REFERENCES obj(obj_id)
);

CREATE TABLE obj_trainer(
obj_trainer_id INT PRIMARY KEY,
obj_id INT,
trainer_id INT,
quantity INT,
CONSTRAINT obj_trainer_fk FOREIGN KEY (obj_id) REFERENCES obj(obj_id),
CONSTRAINT trainer_obj_fk FOREIGN KEY (trainer_id) REFERENCES trainer(trainer_id)
);