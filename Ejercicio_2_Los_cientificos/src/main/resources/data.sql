use cientificos;
drop table if exists cientificos, proyectos, asignado_a;

create table cientificos (
	dni varchar(8),
    nom_apels nvarchar(255),
    primary key (dni)
);

create table proyectos (
	id char(4),
    nombre nvarchar(255),
    horas int,
    primary key (id)
);

create table asignado_a (
    id int auto_increment primary key,
	cientifico varchar(8),
    proyecto char(4),
    foreign key (cientifico) references cientificos (dni)
    on delete cascade on update cascade,
    foreign key (proyecto) references proyectos (id)
    on delete cascade on update cascade
);


insert into cientificos(dni, nom_apels)values('12345678', 'Izan Dueso');
insert into proyectos(id, nombre, horas)values('aaaa', 'Spring', 300);
insert into asignado_a(cientifico, proyecto)values('12345678', 'aaaa');