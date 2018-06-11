CREATE TABLE [dbo].[estado] (
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nome] [VARCHAR](100) NOT NULL,
	[sigla] [VARCHAR](20) NOT NULL,
	CONSTRAINT [pk_estado] PRIMARY KEY CLUSTERED ([id] ASC)
);

CREATE TABLE [dbo].[cidade] (
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nome] [VARCHAR](100) NOT NULL,
	[id_estado] [INT] NOT NULL,	
	CONSTRAINT [pk_cidade] PRIMARY KEY CLUSTERED ([id] ASC),
	CONSTRAINT [fk_cidade_estado] FOREIGN KEY (id_estado) REFERENCES [dbo].[estado] (id)
    ON DELETE CASCADE  
    ON UPDATE CASCADE
);

INSERT INTO estado (nome, sigla) VALUES
('Acre', 'AC'),
('Alagoas', 'AL');

INSERT INTO cidade (nome, id_estado) VALUES
('Acrelândia', 1),
('Assis Brasil', 1),
('Brasiléia', 1),
('Bujari', 1),
('Água Branca', 2),
('Anadia', 2),
('Arapiraca', 2),
('Atalaia', 2);