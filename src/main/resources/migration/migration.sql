CREATE TABLE IF NOT EXISTS aluno (
    id VARCHAR(36) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS turma (
    id VARCHAR(36) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
)

CREATE TABLE IF NOT EXISTS aluno_turma (
    id VARCHAR(36) NOT NULL,
    PRIMARY KEY (id),
    aluno_id VARCHAR(36) DEFAULT NULL,
    turma_id VARCHAR(36) DEFAULT NULL,
    FOREIGN KEY (aluno_id) REFERENCES aluno (id),
    FOREIGN KEY (turma_id) REFERENCES turma (id)
)