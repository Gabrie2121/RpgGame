CREATE TABLE IF NOT EXISTS Item (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    elemento VARCHAR(50),
    reforja INT,
    raridade VARCHAR(50),
    tipo_de_peca VARCHAR(50),
    dano_fisico INT,
    dano_magico INT,
    defesa_fisica INT,
    defesa_magica INT,
    imagem VARCHAR(255)
);

ALTER TABLE Item
ADD CONSTRAINT unique_nome UNIQUE (nome);

ALTER TABLE User
ADD CONSTRAINT unique_email UNIQUE (email);
