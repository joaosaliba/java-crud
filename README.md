# Para rodar projeto
Ter :
Tom cat
Eclipse
MySql

# Scrip criar branco e tabelas

```
create schema banco;

create table Agencia (
agencia_id int(5) not null auto_increment,
num_agencia int(5) not null,
razao_social varchar(128) not null,
endereco varchar(48) not null,
gerente varchar(128) not null,

primary key(agencia_id)
);

create table Conta(
conta_id int(5) not null auto_increment,
agencia_fk int not null,
dono varchar(128) not null,
valor float not null,

primary key(conta_id),
foreign key(agencia_fk) references Agencia(agencia_id)
);
```