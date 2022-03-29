create table paciente(
id Serial PRIMARY KEY,
first_name varchar(20),
last_name varchar(30),
phone varchar(30),
provider_name varchar(30),
copay decimal(10,5)
)

create table medico(
id Serial PRIMARY KEY,
first_name varchar(20),
last_name varchar(30),
speciality varchar(30)
)

create table pacientes_medicos(
paciente_id int,
medico_id int,
FOREIGN KEY (paciente_id)
REFERENCES paciente(id),
FOREIGN KEY (medico_id)
REFERENCES medico(id)
)

create table agendamento(
id Serial PRIMARY KEY,
paciente_id int,
medico_id int,
agendamento_time TIMESTAMP,
started smallint,
ended smallint,
razao varchar(200),
FOREIGN KEY (paciente_id)
REFERENCES paciente(id),
FOREIGN KEY (medico_id)
REFERENCES medico(id)
)	
			
			
select * from paciente

select * from medico

select * from agendamento

select * from pacientes_medicos

drop table pacientes_medicos

drop table agendamento

drop table paciente

drop table medico



-- Se quiser fazer testes:

CREATE OR REPLACE FUNCTION boolean1(i smallint) RETURNS boolean AS $$
    BEGIN
            RETURN (i::smallint)::int::bool;
    END;
$$ LANGUAGE plpgsql;

CREATE CAST (smallint AS boolean) WITH FUNCTION boolean1(smallint) AS ASSIGNMENT;

change_column :AG, :column_name, 'integer USING CAST(column_name AS integer)'

ALTER TABLE agendamento
	ALTER COLUMN started TYPE boolean
CAST ( boolean AS smallint );
			END;
ALTER TABLE agendamento
	ALTER COLUMN ended TYPE boolean
CAST ( boolean AS smallint );
			END;		
