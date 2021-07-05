INSERT INTO `tb_autores`(nome, email, descricao, data_criacao) VALUES('Autor01', 'email_repetido@email.com', 'Primeiro autor', '2021-07-01');
INSERT INTO `tb_autores`(nome, email, descricao, data_criacao) VALUES('Autor02', 'autor02@email.com', 'Segundo autor', '2021-07-03');

INSERT INTO `tb_categorias`(nome) VALUES('teste01');
INSERT INTO `tb_categorias`(nome) VALUES('teste02');

INSERT INTO `tb_livros`(titulo, resumo, sumario, preco, numero_paginas, isbn, data_publicacao, categoria_id, autor_id) VALUES('titulo duplicado','a','a',60,600,'a','2021-10-24',1,1);
INSERT INTO `tb_livros`(titulo, resumo, sumario, preco, numero_paginas, isbn, data_publicacao, categoria_id, autor_id) VALUES('teste01','b','b',60,600,'isbn duplicado','2021-10-24',1,1);
