drop schema if exists spring cascade;
create schema spring;
use spring;
create table pokemon (
	id bigint AUTO_INCREMENT,
	attack bigint,
	defence bigint,
	evolves boolean,
	name varchar(255),
	poke_dex bigint,
	speed bigint,
	type1 varchar(255),
	type2 varchar(255),
	weakness1 varchar(255),
	weakness2 varchar(255),
	primary key (id));
