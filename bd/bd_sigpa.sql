-- drop database sigpa;

-- select * from contaspagar;
-- select * from venda;
-- select * from fornecedores;
-- select * from endereco;
-- select * from funcionarios;
-- select * from clientes;
-- select * from itemfinanceiro;
-- select * from compra;
create database sigpa;

use sigpa;

create table endereco (
	id int not null auto_increment,
    rua varchar (50),
    num int,
    bairro varchar (50),
    cidade varchar (50),
    uf varchar (2),
    cep varchar (8),
    primary key (id)

);

create table funcionarios (
	id int auto_increment not null,
    nome varchar (50) not null,
    cpf varchar (11) not null unique,
    rg varchar (20) not null,
    nascimento date not null,
    sexo char not null,
    email varchar (150) not null unique,
    endereco_fk int,
    telefone varchar (11) not null,
    admissao date not null,
    cargo varchar(60) not null,
    salario numeric (10,3),
    username varchar (20) not null,
    senha varchar (20) not null,
    tipo varchar(20) not null,
    primary key (id),
    foreign key (endereco_fk) references endereco(id)
);
 
create table clientes (
	id int auto_increment not null,
    nome varchar(50) not null,
    cpf varchar (11) not null unique,
    rg varchar (20) not null,
    nascimento date not null,
    sexo char not null,
    email varchar (150),
    endereco_fk int ,
    telefone varchar (11) not null,
    limite long not null,
    primary key (id),
    foreign key (endereco_fk) references endereco(id)

);

create table fornecedores (
	id int auto_increment not null,
    cnpj varchar (14) not null unique,
    endereco_fk int,
    telefone varchar (11) not null,
    email varchar (150),
    nome varchar (50) not null,
    representante varchar (50) not null,
    primary key (id),
    foreign key (endereco_fk) references endereco(id)

);

create table itemfinanceiro (
	id int auto_increment not null,
    nome varchar (50) not null,
    precounitario long not null,
    precocusto float not null,
    estoque float not null,
    descricao varchar(100),
    categoria varchar (20),
    fornecedor_fk int not null,
    primary key (id),
    foreign key (fornecedor_fk) references fornecedores (id)
);

create table compra (
	id int auto_increment not null,
    total float not null,
    descricao varchar (120) not null,
    datacompra date not null not null,
    previsao date not null,
    fornecedor_fk int not null,
    primary key (id),
    foreign key (fornecedor_fk) references fornecedores (id)

);

create table venda (
	id int auto_increment not null,
    datavenda date not null,
    cliente_fk int not null,
	valorvenda float not null,
    primary key (id),
    foreign key (cliente_fk) references clientes (id)
);

create table contasapagar (
	id int auto_increment not null,
    descricao varchar(150) not null,
    valor float not null,
    vencimento date,
    primary key (id)
);

create table itemvenda (
	id int auto_increment,
    venda_fk int not null,
    item_fk int not null,
    quantidade int not null,
    valorunitario float,
    primary key (id),
    foreign key (venda_fk) references venda (id),
    foreign key (item_fk) references itemfinanceiro (id)

);