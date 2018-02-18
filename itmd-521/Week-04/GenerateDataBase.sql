create database itmd521;


create table records(
	us_station varchar(6),
	wb_station varchar(5),
	date varchar(8),
	hour varchar(4),
	latitude varchar(6),
	longitude varchar(7),
	kind varchar(5),
	elevation varchar(5),
	wind varchar(3),
	quality varchar(1),
	visibility varchar(6),
	temperature int,
	dew varchar(5),
	pressure varchar(5)
);