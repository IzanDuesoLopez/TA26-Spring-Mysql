drop table if exists piezas, proveedores, suministra;
use piezas_y_proveedores;

create table piezas(
    codigo int auto_increment primary key,
    nombre nvarchar(100)
);

create table proveedores(
    id char(4) primary key,
    nombre nvarchar(100)
);

create table suministra(
    codigoPieza int,
    idProveedor char(4),
    foreign key(codigoPieza) references Piezas(codigo),
    foreign key(idProveedor) references Proveedores(id)
);


insert into piezas(nombre)values('PiezaUno');
insert into proveedores(id, nombre)values('aaaa', 'Intel');
insert into suministra(codigoPieza, idProveedor(values(1, 'aaaa');
