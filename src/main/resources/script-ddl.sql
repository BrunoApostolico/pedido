

create database app;

use app;

create table cliente(
	codigo int not null primary key auto_increment,
	nome varchar(80)
);

insert into cliente (codigo, nome) values (null, 'Bruno');

select * from cliente;

create table produto(
	codigo int not null primary key auto_increment,
	descricao varchar(120),
	preco double
);

insert into produto (codigo,  descricao, preco) values (null, 'Macarrão a bolonheza', 100);
insert into produto (codigo,  descricao, preco) values (null, 'Bife com fritas', 200);
insert into produto (codigo,  descricao, preco) values (null, 'Coca-cola', 8);

create table atendente(
                          codigo int not null primary key auto_increment,
                          idade int,
                          formacao varchar(80),
                          turno varchar(80)
);

insert into atendente (codigo,  idade, formacao, turno) values (null, '36', 'tecnico','noite');

create table pedido (
	codigo int not null primary key auto_increment,
	data date,
	cliente_cod int,
	foreign key (cliente_cod) references cliente(codigo),
    atendente_cod int,
    foreign key (atendente_cod) references atendente(codigo)
);


create table itens_pedido (
	codigo int not null primary key auto_increment,
	pedido_cod int,
	produto_cod int,
	foreign key (pedido_cod) references pedido(codigo),
	foreign key (produto_cod) references produto(codigo)
);

insert into pedido (codigo, data, cliente_cod, atendente_cod) values (null, '2022-11-28', 1,1);


insert into itens_pedido (codigo, pedido_cod, produto_cod) value (null, 2, 1);
insert into itens_pedido (codigo, pedido_cod, produto_cod) value (null, 2, 2);
insert into itens_pedido (codigo, pedido_cod, produto_cod) value (null, 3, 3);


select p.codigo, p.data, c.nome, a.codigo, pr.descricao, pr.preco from pedido p
	join cliente c
    join atendente a
	join itens_pedido i
	join produto pr
	on p.cliente_cod = c.codigo
	and p.codigo = i.pedido_cod
    and p.atendente_cod = a.codigo
	and pr.codigo = i.produto_cod;

