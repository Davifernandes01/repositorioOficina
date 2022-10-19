 /* Script da criacao do banco de dados Oficina, com as tabelas cliente e Carros*/

 /*cada cliente so pode ter um cpf,
 cada cliente pode ter varios carros,
 um carro so pode ter um cliente*/

 create database oficina;

 	create table cliente(
    id_cliente int primary key auto_increment,
 	nome varchar(50) not null,
 	cpf varchar(11) not null

 	)Engine = InnoDB;


 	create table carros(

 		id_carro int primary key auto_increment,
 		fabricante varchar(15) not null,
 		modelo varchar(15) not null,
 		placa varchar(7) not null,
 		cor varchar(20) not null,
 		id_carro_cliente int not null


 		)Engine = InnoDB;



ALTER TABLE carros ADD CONSTRAINT id_carro_cliente
FOREIGN KEY(id_carro_cliente) REFERENCES cliente(id_cliente)
on delete CASCADE;

 alter table cliente add unique(cpf);
 alter table carros add unique(placa);
 






