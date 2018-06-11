CREATE TABLE [dbo].[funcionario] (
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nome] [VARCHAR](100) NOT NULL,
	[email] [VARCHAR](100) NOT NULL,
	[telefone] [VARCHAR](20) NOT NULL,
	[cpf] [VARCHAR](20) NOT NULL,
	[rg] [VARCHAR](20) NOT NULL,
	[numero] [VARCHAR](100) NULL,
	[bairro] [VARCHAR](100) NOT NULL,
	[rua] [VARCHAR](200) NOT NULL,
	[cep] [VARCHAR](20) NOT NULL,
	[data_admissao] [date] NOT NULL,
	[data_demissao] [date] NULL,
	[data_nascimento] [date] NULL,
	[observacao] [VARCHAR](255) NULL,
	[foto] [VARCHAR](200) NULL,
	[tipo_conteudo] [VARCHAR](100) NULL,
	[id_cargo] [INT] NOT NULL,
	[id_cidade] [INT] NOT NULL,	
	CONSTRAINT [pk_funcionario] PRIMARY KEY CLUSTERED ([id] ASC),
	CONSTRAINT [fk_funcionario_cargo] FOREIGN KEY (id_cargo) REFERENCES [dbo].[cargo] (id),
	CONSTRAINT [fk_funcionario_cidade] FOREIGN KEY (id_cidade) REFERENCES [dbo].[cidade] (id)
    ON DELETE CASCADE  
    ON UPDATE CASCADE
);