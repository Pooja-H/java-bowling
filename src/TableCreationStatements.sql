create table if not exists player_details(playerId int,name varchar(250));
create table if not exists score_board(
gameid int not null,
laneid int not null,
player_id int not null,
frame int not null,
ball1_score int not null,
ball2_score int not null,
ball3_score int not null,
framescore int ,
PRIMARY KEY (gameid,playerId,frame)
FOREIGN KEY (laneid) REFERENCES Persons(Lane)
);

create TABLE Lane(
laneId int not null,
isFree BOOLEAN
);