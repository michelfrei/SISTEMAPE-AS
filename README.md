# SISTEMAPECAS


CREATE TABLE sys.funcionario (
id int(5) auto_increment primary key,
id_tipo_usuario int(5) not null,
nome varchar(75) not null,
endereco varchar(75) not null,
numero int(5) not null,
bairro varchar(45) not null,
cpf char(14) not null,
rg char(14),
telefone varchar(14) not null,
telefone2 varchar(14),
email varchar(75),
usuario varchar(20) not null,
senha varchar(16) not null,
ativo boolean not null
);

create table sys.cliente(
id int auto_increment primary key, 
nome_razao varchar(75) not null, 
cpf_cnpj varchar(18) not null, 
rg char(14), 
endereco varchar(75) not null, 
numero int(5) not null, 
complemento varchar(30) not null, 
bairro varchar(60) not null, 
cidade varchar(60) not null, 
estado char(2) not null, 
cep char(10) not null, 
telefone char(14) not null, 
telefone2 char(14) not null, 
email varchar(100) not null, 
vencimento char(2) not null, 
debito double(10, 2) not null, 
ativo boolean not null
);

create table sys.produto(
id int auto_increment primary key,
tipo varchar(100) not null, 
descricao varchar(100) not null, 
detalhes varchar(100) not null,
marca varchar(100) not null,
origem varchar(100) not null, 
codigo_de_barras varchar(100) not null, 
fabricante varchar(100) not null, 
setor varchar(100) not null, 
unidade_medida varchar(100) not null, 
peso double(8, 2) not null, 
medidas varchar(100) not null, 
foto varchar(100) not null, 
estoque int(10) not null, 
ativo boolean not null
);
\\------------------\\\\------------\\\------------------\\\----------------------------\\------------------------------------\\\
Nuevo:

create table sys.cliente( id int auto_increment primary key, nome_razao varchar(75) not null, cpf_cnpj varchar(18) not null, rg char(14), endereco varchar(75) not null, numero int(5) not null, complemento varchar(30) not null, bairro varchar(60) not null, cidade varchar(60) not null, estado char(2) not null, cep char(10) not null, telefone char(14) not null, telefone2 char(20) not null, email varchar(100) not null, vencimento char(10) not null, debito double(10, 2) not null, ativo boolean not null );

create table sys.funcionario ( id int auto_increment primary key, id_tipo_usuario int(5) not null, nome varchar(75) not null, endereco varchar(75) not null, numero int(5) not null, bairro varchar(45) not null, cpf varchar(20) not null, rg varchar(20), telefone char(20) not null, telefone2 char(20), email varchar(75), usuario varchar(20) not null, senha varchar(16) not null, ativo boolean not null );

create table sys.produto( id int auto_increment primary key, tipo varchar(100) not null, descricao varchar(100) not null, detalhes varchar(100) not null, marca varchar(100) not null, origem varchar(100) not null, codigo_de_barras varchar(100) not null, fabricante varchar(100) not null, setor varchar(100) not null, unidade_medida varchar(100) not null, peso double(8, 2) not null, medidas varchar(100) not null, foto varchar(100) not null, estoque int(10) not null, ativo boolean not null )
