CREATE database sistema_compra;

use sistema_compra;

CREATE TABLE lista_compras(
	id int auto_increment primary key,
	data_compra datetime,
    mercado_id int,
    item_id int ,
    quantidade int,
    preco_unitario decimal(6,2),
    total decimal(6,2)
);

create table mercado(
	id int auto_increment primary key,
	descricao varchar(100) not null
);

create table produto(
	id int auto_increment primary key,
	nome varchar(100) not null
);

ALTER TABLE lista_compras ADD CONSTRAINT fk_lista_compra_mercado FOREIGN KEY (mercado_id) REFERENCES mercado (id);
ALTER TABLE lista_compras ADD CONSTRAINT fk_lista_compra_produto FOREIGN KEY (item_id) REFERENCES produto (id);

insert into mercado(descricao) values('Cooper');
insert into mercado(descricao) values('giassi');
insert into mercado(descricao) values('angeloni');
insert into mercado(descricao) values('galegao');
insert into mercado(descricao) values('Komprao');

select * from mercado;

insert into produto(nome) values("Sabonete");

select * from produto p;

insert into lista_compras(data_compra, mercado_id, item_id, quantidade, preco_unitario, total)
				   values(now(), 3, 1, 3, 1.99, 5.97);

select l.data_compra as 'Data compra', m.descricao as 'Mercado' ,
		p.nome as 'Nome do produto',
        l.quantidade 'Quantidade comprada',
        l.preco_unitario 'Valor unitário',
        l.total as 'Soma do total de item'
from lista_compras l
join mercado m on l.mercado_id = m.id
join produto p on l.item_id = p.id
;
