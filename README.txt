SCRIPT PARA CRIACAO DO BANCO DE DADOS------------------------------------


CREATE DATABASE ticket_controle
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Portuguese_Brazil.1252'
    LC_CTYPE = 'Portuguese_Brazil.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;


SCRIPT PARA CRIACAO DAS TABELAS------------------------------------------
 
FUNCIONARIO--------------------------------------------------------------


CREATE TABLE IF NOT EXISTS public.funcionario
(
    id integer NOT NULL,
    nome text COLLATE pg_catalog."default" NOT NULL,
    cpf text COLLATE pg_catalog."default" NOT NULL,
    situacao "char" NOT NULL,
    data_alteracao text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT funcionario_pkey PRIMARY KEY (id)
)


TICKET-------------------------------------------------------------------


CREATE TABLE IF NOT EXISTS public.ticket
(
    id_ticket integer NOT NULL,
    id_func integer NOT NULL,
    quantidade integer NOT NULL,
    situacao "char" NOT NULL,
    data_entrega text COLLATE pg_catalog."default",
    CONSTRAINT ticket_pkey PRIMARY KEY (id_ticket)
)


-------------------------------------------------------------------------

Informações uteis : 

1 - Os Campos id Funcionario e id Ticket, ao perderem o foco realizam uma consulta no banco de dados,
indentificando automaticamente se vai ser um cadastro ou uma consulta ou uma alteração.
2 - A aba Relatorio ja vem carrega com todos os dados incluidos no banco, todas as datas e todos os funcionarios.
3 - A consulta pode ser feita de forma parcial.
3.1 Informando somente o codigo do funcionario e deixando as datas em branco - Ira realizar uma consulta geral para um determinado funcionario.
3.2 Deixando o campo de funcionario em branco e preenchendo as datas - Ira realizar um consulta por periodo mas para todos os funcionarios.
3.3 Preenchendo todos os campos sera uma consulta por periodo para funcionario X.
3.4 E a busca geral, são todos os campos vazios, vai ser uma busca de todos os registros do banco.
4 Sempre que o campo id_funcionario perde o foco ele realiza uma consulta e mostra na tela o funcionario que foi solicitado.
