INSERT INTO tipo_fase (descricao) VALUES ('monofasico');
INSERT INTO tipo_fase (descricao) VALUES ('bifasico');
INSERT INTO tipo_fase (descricao) VALUES ('trifasico');

INSERT INTO tipo_pessoa (descricao) VALUES ('pessoa-fisica');
INSERT INTO tipo_pessoa (descricao) VALUES ('pessoa-juridica');

INSERT INTO pessoa (nome, cpf, tipo_pessoa_id ) VALUES ('Vitor', 12345678910, 1);

INSERT INTO cliente (num_documento, num_cliente, pessoa_id) VALUES ('Vitor', 12345678910, 2);

INSERT INTO funcionario(codigo_funcional, pessoa_id) VALUES  (123123123, 1);

INSERT INTO rota (descricao) VALUES ('Fortaleza');
INSERT INTO rota (descricao) VALUES ('Aquiraz');
INSERT INTO rota (descricao) VALUES ('Quixada');