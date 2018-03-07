create database if not exists Ab4AppDB;

use Ab4AppDB;

create table if not exists Locations(
	locationType varchar(50) not null,
    locationName varchar(50) not null primary key,
    parentName varchar(50) 
);

create table if not exists Spots(
	id int primary key auto_increment,
    spotName varchar(50) not null,
    locationName varchar(50) not null,
    price float not null,
    startDate date not null,
    endDate date not null,
    foreign key(locationName) references Locations(locationName) 
);

create table if not exists Activities(
	spotId int not null,
    activity varchar(50) not null,
    foreign key(spotId) references Spots(id)
);

insert into Locations values
('country','Romania', null),

('region','region1','Romania'),
('region','region2','Romania'),
('region','region3','Romania'),

('city','city1','region1'),
('city','city2','region1'),
('city','city3','region2'),
('city','city4','region3');

#select * from Locations;

insert into Spots values
(null,'spot1','city1',190,'2018-01-01','2018-11-25'),
(null,'spot2','city1',120,'2018-03-01','2018-07-11'),
(null,'spot3','city1',150,'2018-04-01','2018-05-21'),
(null,'spot4','city2',170,'2018-06-01','2018-08-15'),
(null,'spot5','city2',160,'2018-05-01','2018-09-18'),
(null,'spot6','city3',250,'2018-08-01','2018-12-09'),
(null,'spot7','city4',350,'2018-07-01','2018-11-17');

# select * from spots;

insert into Activities values
(1, 'Motocross'),
(2, 'Freeflying'),
(3, 'Surfing'),
(4, 'Kitesurfing'),
(5, 'Parkour'),
(6, 'Rafting'),
(7, 'Freerunning'),
(1, 'Waveski'),
(2, 'Land windsurfing'),
(3, 'Bungee jumping'),
(4, 'Flowriding'),
(5, 'Freestyle skiing'),
(3, 'Motocross'),
(4, 'Freeflying'),
(5, 'Surfing'),
(6, 'Kitesurfing'),
(7, 'Parkour'),
(1, 'Rafting'),
(2, 'Freerunning'),
(3, 'Waveski'),
(4, 'Land windsurfing'),
(5, 'Bungee jumping'),
(6, 'Flowriding'),
(7, 'Freestyle skiing');

 select distinct * from Activities;

 select * from spots join activities on spots.id = activities.spotId where spotName = 'spot4';


