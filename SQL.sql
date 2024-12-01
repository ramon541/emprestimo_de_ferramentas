CREATE TABLE USUARIOS (
	IDUSUARIO		SERIAL 			PRIMARY KEY,
	NOME			VARCHAR(255)	NOT NULL,
	USUARIO 		VARCHAR(255)	NOT NULL UNIQUE,
	SENHA			VARCHAR(255)	NOT NULL,
	ISADMIN 		INT				DEFAULT 0
)

CREATE TABLE FERRAMENTAS (
	IDFERRAMENTA	SERIAL			PRIMARY KEY,
	NOME			VARCHAR(255)	NOT NULL
)

CREATE TABLE EMPRESTIMOS (
    IDEMPRESTIMO   		SERIAL          PRIMARY KEY,
    FK_IDUSUARIO   		INT             REFERENCES USUARIOS(IDUSUARIO) NOT NULL,
    FK_IDFERRAMENTA 	INT            	REFERENCES FERRAMENTAS(IDFERRAMENTA) NOT NULL,
    DTDEVOLUCAO    		DATE            NOT NULL,
    ISDEVOLVIDO    		INT             DEFAULT 0
);

SELECT * FROM ferramentas;

INSERT INTO USUARIOS (NOME, USUARIO, SENHA, ISADMIN)
VALUES ('Ramon Dias', 'ramon', '1234', 1)

INSERT INTO USUARIOS (NOME, USUARIO, SENHA, ISADMIN)
VALUES ('Amanda Dias', 'amanda', '1234', 0)

INSERT INTO FERRAMENTAS (NOME) VALUES ('Martelo');
INSERT INTO FERRAMENTAS (NOME) VALUES ('Chave de Fenda');
INSERT INTO FERRAMENTAS (NOME) VALUES ('Alicate');
INSERT INTO FERRAMENTAS (NOME) VALUES ('Serrote');
INSERT INTO FERRAMENTAS (NOME) VALUES ('Furadeira');
INSERT INTO FERRAMENTAS (NOME) VALUES ('Parafusadeira');
INSERT INTO FERRAMENTAS (NOME) VALUES ('Chave Inglesa');
INSERT INTO FERRAMENTAS (NOME) VALUES ('Lima');
INSERT INTO FERRAMENTAS (NOME) VALUES ('Trena');
INSERT INTO FERRAMENTAS (NOME) VALUES ('Nível');