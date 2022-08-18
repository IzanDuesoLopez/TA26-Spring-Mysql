DROP table IF EXISTS ventas, cajeros, productos, maquinas_registradoras;

create table cajeros(
    codigo int auto_increment primary key,
    nom_apels varchar(255)
);

create table productos(
    codigo int auto_increment primary key,
    nombre varchar(255),
    precio int
);

create table maquinas_registradoras(
    codigo int auto_increment primary key,
	piso int
);

create table ventas(
    id int auto_increment primary key,
    cajero int,
    maquina int,
    producto int,
    constraint ventas_a_fk foreign key (cajero) references cajeros(codigo),
    constraint ventas_a_fk_01 foreign key (maquina) references maquinas_registradoras(codigo),
    constraint ventas_a_fk_02 foreign key (producto) references productos(codigo)
);