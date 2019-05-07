use mydb;
INSERT INTO USUARIO (email, nome, perfil, senha) values ('thalis@teste.com', 'thalis', 1, 'teste');
INSERT INTO NOTICIA (conteudo, resumo, titulo, usuario_email) values ('aasda23aa', 'aa3asd2daa', 'aa2aas3a', 'thalis@teste.com');
INSERT INTO Comentario (texto, noticia_id, usuario_email) values ('Finalmente estou terminando isso mano, mas falta outras coisas pra fazer', 7 ,'thalisgaetaf@gmail.com');
UPDATE USUARIO set nome = 'thalis', perfil = 0, senha = 'uhsadhs' where email = 'thalis@teste.com';
select * from noticia nd inner join comentario comen on nd.id = comen.noticia_id ;
SELECT texto, nome FROM comentario comen inner join usuario us on comen.Usuario_email = us.email  WHERE noticia_id = 7;
select * from usuario;
select * from comentario;
ALTER TABLE noticia modify conteudo varchar(8000);
SET @@global.time_zone = '-3:00';
select now();
restart