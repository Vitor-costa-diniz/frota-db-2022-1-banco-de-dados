CREATE TABLE tipo_fase(
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(45)
);

CREATE TABLE classe(
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(45),
    id_tipo_fase INT REFERENCES tipo_fase(id)
);


CREATE TABLE tarifa(
    id SERIAL PRIMARY KEY,
    taxa VARCHAR(45),
    classe INT REFERENCES classe(id),
    lei VARCHAR(45) not null,
    data_inicio TIMESTAMP not null,
    data_final TIMESTAMP not null
);

CREATE TABLE tipo_pessoa(
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(45)
);

CREATE TABLE pessoa(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(45) not null,
    cpf VARCHAR(45) not null,
    cnpj VARCHAR(45),
    tipo_pessoa_id INT REFERENCES tipo_pessoa(id)
);

CREATE TABLE funcionario(
    id SERIAL PRIMARY KEY,
    codigo_funcional VARCHAR(45) not null,
    pessoa_id INT REFERENCES pessoa(id)
);

CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    num_documento VARCHAR(45) not null unique,
    num_cliente VARCHAR(45) not null unique,
    pessoa_id INT REFERENCES  pessoa(id)
);


CREATE TABLE rota(
  id SERIAL PRIMARY KEY,
  descricao VARCHAR(45)
);


CREATE TABLE poste(
  id SERIAL PRIMARY KEY,
  latitude VARCHAR(45),
  longitude VARCHAR(45),
  codigo VARCHAR(45),
  obervacao VARCHAR(45)
);

CREATE  TABLE  medidor(
    id SERIAL PRIMARY KEY,
    descricao  VARCHAR(45),
    rota_id INT REFERENCES rota(id),
    poste_id INT REFERENCES poste(id)
);


CREATE TABLE tarefa_rota(
    id SERIAL PRIMARY KEY,
    observacao VARCHAR(45),
    data_inicio TIMESTAMP,
    data_fim TIMESTAMP,
    tarefa_rotacao VARCHAR (45),
    rota_id INT REFERENCES rota(id)
);

CREATE TABLE time_rota (
    id SERIAL PRIMARY KEY,
    funcionario_id INT REFERENCES funcionario(id),
    tarefa_rota_id INT REFERENCES tarefa_rota(id)
);

CREATE TABLE medicao(
    id SERIAL PRIMARY KEY,
    mes VARCHAR(45),
    ano VARCHAR(45),
    data_medicao timestamp,
    consumo varchar(45),
    medidor_id INT REFERENCES medidor(id),
    time_rota_id INT REFERENCES  time_rota(id)
);

CREATE TABLE cobranca(
    id SERIAL PRIMARY KEY,
    mes_referencia varchar(45),
    ano_referencia varchar(45),
    tarifa_id INT REFERENCES  tarifa(id),
    medicao_id INT REFERENCES medicao(id)
);

CREATE TABLE contrato (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(45),
    data_inicio timestamp,
    data_criacao timestamp,
    medidor_id int references medidor(id),
    classe_id int references classe(id),
    cliente_id int references cliente(id)