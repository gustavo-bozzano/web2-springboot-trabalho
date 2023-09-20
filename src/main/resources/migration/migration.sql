CREATE TABLE IF NOT EXISTS aluno (
    id int NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS turma (
    id int NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS aluno_turma (
    id INT AUTO_INCREMENT,
    aluno_id INT,
    turma_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (aluno_id) REFERENCES aluno (id),
    FOREIGN KEY (turma_id) REFERENCES turma (id)
);
