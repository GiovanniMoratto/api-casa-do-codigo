-- H2 Database (Tests) --

INSERT INTO `tb_autores`(nome, email, descricao, data_criacao) VALUES('J. R. R. Tolkien', 'tolkien@email.com', 'John Ronald Reuel (J.R.R.) Tolkien was born in 1892 in South Africa', '2021-07-01');
INSERT INTO `tb_autores`(nome, email, descricao, data_criacao) VALUES('Author01', 'duplicate_email@email.com', 'bla bla bla', '2021-07-03');

INSERT INTO `tb_categorias`(nome) VALUES('Fantasy Novel');
INSERT INTO `tb_categorias`(nome) VALUES('Duplicated');

INSERT INTO `tb_livros`(titulo, resumo, sumario, preco, numero_paginas, isbn, data_publicacao, id_categoria, id_autor) VALUES('The Hobbit','a','a',60,600,'a','2021-10-24',1,1);
INSERT INTO `tb_livros`(titulo, resumo, sumario, preco, numero_paginas, isbn, data_publicacao, id_categoria, id_autor) VALUES('Title duplicated','b','b',60,600,'isbn duplicated','2021-10-24',2,2);
