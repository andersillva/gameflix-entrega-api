--liquibase formatted sql
				
--changeset andersillva:1
CREATE TABLE if not exists liberacao (
	id_liberacao		INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	dt_inicio			DATE NOT NULL,
	dt_fim				DATE NOT NULL,
	id_jogo				INT NOT NULL,
	nm_jogo				VARCHAR(60) NOT NULL
);
