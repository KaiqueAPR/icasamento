-- Arquivo referente a criação da tabela PRESENTE

CREATE DATABASE IF NOT EXISTS iCasamento;

USE iCasamento;

CREATE TABLE IF NOT EXISTS presente (
    PRES_CD_PRESENTE INT PRIMARY KEY,
    PRES_NM_PRESENTE VARCHAR(255),
    -- Chave estrangeira referente a tabela TIPO_PRESENTE
    FOREIGN KEY (PRES_CD_TIPO_PRESENTE) REFERENCES TIPO_PRESENTE(PRES_CD_TIPO_PRESENTE),
    PRES_TX_LINK VARCHAR(255),
    PRES_VL_PRECO FLOAT,
    PRES_TX_CAMINHO_IMAGEM VARCHAR(255)
    
);

CREATE INDEX PRES_CD_PRESENTE ON presente (PRES_CD_PRESENTE);
CREATE INDEX PRES_NM_PRESENTE ON presente (PRES_NM_PRESENTE);
CREATE INDEX PRES_TX_LINK ON presente (PRES_TX_LINK);
CREATE INDEX PRES_VL_PRECO ON presente (PRES_VL_PRECO);
CREATE INDEX PRES_TX_CAMINHO_IMAGEM ON presente (PRES_TX_CAMINHO_IMAGEM);