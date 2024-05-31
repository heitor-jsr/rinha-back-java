-- Cria o banco de dados rinhadb
CREATE DATABASE rinhadb;

-- Cria o usuário admin com a senha 123
CREATE USER admin WITH PASSWORD '123';

-- Concede todos os privilégios no banco de dados rinhadb ao usuário admin
GRANT ALL PRIVILEGES ON DATABASE rinhadb TO admin;

-- Ativa o auto commit para todas as conexões futuras
SET AUTOCOMMIT = TRUE;

-- Habilita o cache de preparação de statements
SET PREPARE TRANSACTION STATEMENT CACHE 250;

-- Habilita o uso de prepared statements do servidor
SET USE SERVER PREPARED STATEMENTS = TRUE;

-- Habilita o cache de metadados de resultados
SET cache_result_set_metadata = true;

-- Habilita o cache de configuração do servidor
SET cache_server_configuration = true;

-- Habilita a eliminação de SET AUTOCOMMIT
SET elide_set_autocommits = true;

-- Define a query de validação para o pool de conexões
ALTER SYSTEM SET validation_query = 'SELECT 1';
