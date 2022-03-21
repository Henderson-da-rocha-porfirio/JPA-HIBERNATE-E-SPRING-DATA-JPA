create table pagamento(
id int PRIMARY KEY,
pmode varchar(20),
amount decimal(8,3) ,
cardnumber varchar(20),
checknumber varchar(20)
);

select * from pagamento
