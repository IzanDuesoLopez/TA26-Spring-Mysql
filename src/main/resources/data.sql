use piezas_y_proveedores;
drop table if exists piezas, proveedores, suministra;


create table piezas(
    codigo int primary key,
    nombre nvarchar(100)
);

create table proveedores(
    id char(4) primary key,
    nombre nvarchar(100)
);

create table suministra(
    id int primary key,
    codigo_pieza int,
    id_proveedor char(4),
    precio int,
    foreign key(codigo_pieza) references piezas(codigo),
    foreign key(id_proveedor) references proveedores(id)
);


insert into piezas(codigo, nombre)values(0, 'PiezaUno');
insert into piezas(codigo, nombre)values(1, 'PiezaDos');
insert into piezas(codigo, nombre)values(2, 'PiezaTres');
insert into proveedores(id, nombre)values('aaaa', 'Intel');
insert into proveedores(id, nombre)values('bbbb', 'AMD');
insert into proveedores(id, nombre)values('cccc', 'NVidia');
insert into suministra(id, codigo_pieza, id_proveedor, precio)values(0, 0, 'aaaa', 200);
insert into suministra(id, codigo_pieza, id_proveedor, precio)values(1, 1, 'bbbb', 300);
insert into suministra(id, codigo_pieza, id_proveedor, precio)values(2, 2, 'cccc', 400);