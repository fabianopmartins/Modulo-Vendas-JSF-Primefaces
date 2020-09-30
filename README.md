# Modulo-Vendas-JSF-Primefaces

# ULR inicial

http://localhost:8080/Soften/pages/autenticacao.xhtml

Proposta de Projeto
 Criar um CRUD (Create, Read, Update and Delete) utilizando a tecnologia 
Java e os frameworks JSF, PrimeFaces e Hibernate. O banco de dados a ser 
utilizado pode ser o MySQL ou o MariaDB. Não existem requisitos para o layout 
e tudo que não estiver especificado neste documento fica a critério do 
desenvolvedor. 
Segue a especificação do que deve ser criado:
 Login 
 Cadastro de Usuários;
 Cadastro de Clientes;
 Cadastro de Produtos;
 Pedido de Venda.
Tabelas no Banco de Dados:
 Usuarios
 Clientes
 Produtos
 PedidoVenda
 PedidoVendaItens
 Cidades (Opcional)
 Estados (Opcional)
As colunas associadas às tabelas devem ser construídas de acordo com os 
campos em tela, mas cada tabela deve ter, necessariamente, uma coluna 
“CodigoRegistroTabela”, sendo esta a chave primária auto increment. 
1.1 Login
O processo de login é dependente do processo 1.2 Cadastro de 
Usuários. Porém, deve ser criado um usuário padrão denominado 
“Administrador” cuja senha deverá ser @Admin2020. O login deve ser permitido 
somente para usuários que estejam cadastrados na tabela do banco de dados 
“Usuarios”. Não é necessária uma opção de recuperação de senha, nem de novo 
cadastro na página de login. A página inicial deve ser uma tela em branco, com 
as funcionalidades agrupadas em um menu. 
1.2 Cadastro de Usuários
A listagem dos usuários cadastrados e um novo cadastro deverão ser feitos 
na mesma tela. A partir dela, deve ser possível fazer a inserção, edição e exclusão 
de um registro. Além da listagem dos usuários cadastrados, devem ser exibidos 
os seguintes campos: 
Nome do Campo Tipo Tamanho Obrigatório? Observações
Nome Caractere 40 Sim
Login Alfanumérico 10 Sim
SOFTEN SISTEMAS - 2020
Senha Alfanumérico 20 Sim A senha não deve 
ser exibida, e sim 
substituída por 
asteriscos 
Botão Salvar - - - -
Botão Cancelar - - - -
Botão Excluir - - - -
Regras de Interface:
1. Botão Salvar – deve validar os campos de preenchimento obrigatório. 
Caso o cadastro seja salvo, deve exibir o novo usuário na listagem.
a. Caso algum deles não esteja preenchido, a borda do campo deve 
ser alterada para outra cor a mensagem de advertência deve ser 
exibida: “Todos os campos são de preenchimento obrigatório! ”.
b. Caso o “Login Usuário” já exista deve exibir a mensagem de 
advertência: “Usuário já cadastrado!”.
2. Botão Cancelar – deve descartar qualquer alteração feita e redirecionar 
o cliente para a página inicial.
3. Botão Excluir – deve estar habilitado somente se o usuário logado for 
o Administrador. Quando o usuário for excluído, deve ser removido da 
listagem.
Regras de Negócio:
1. Botão Salvar – deve salvar o cadastro na tabela “Usuarios”.
2. Botão Excluir – deve excluir o usuário e removê-lo da tabela “Usuarios”.
1.3 Cadastro de Clientes
A listagem dos clientes cadastrados e um novo cadastro deverão ser feitos 
na mesma tela. A partir dela, deve ser possível fazer a inserção, edição e exclusão 
de um registro. Além da listagem dos clientes cadastrados, devem ser exibidos 
os seguintes campos:
Nome do Campo Tipo Tamanho Obrigatório? Observações
Dados Principais
Nome/Razão Social Alfanumérico 60 Sim
CPF/CNPJ Número 14 Sim A máscara deverá 
ser 999.999.999-
99 ou 
99.999.99/9999-
99
Inscrição Estadual Alfanumérico 14 Sim
Endereços
CEP Número 8 Sim A máscara deverá 
ser 99999-999
Logradouro Alfanumérico 60 Sim
Número Número 6 Sim
Bairro Alfanumérico 60 Sim
Complemento Alfanumérico 60 Não
SOFTEN SISTEMAS - 2020
Cidade Alfanumérico 60 Sim
Estado Alfanumérico 20 Sim
Botão Salvar - - - -
Botão Cancelar - - - -
Botão Excluir - - - -
Regras de Interface:
1. CPF/CNPJ – a máscara correspondente deve ser aplicada de acordo com 
o tipo de documento preenchido.
2. Botão Salvar – deve validar os campos de preenchimento obrigatório. 
Caso o cadastro seja salvo, deve exibir o novo cliente na listagem.
a. Caso algum deles não esteja preenchido, a borda do campo deve 
ser alterada para outra cor a mensagem de advertência deve ser 
exibida: “Campo “Nome_do_Campo” é de preenchimento 
obrigatório! ”.
3. Botão Cancelar – deve descartar qualquer alteração feita e redirecionar 
o usuário para a página inicial.
4. Botão Excluir – deve estar habilitado somente se o usuário logado for 
o Administrador. Quando o cliente for excluído, deve ser removido da 
listagem. Só deverá ser possível excluir um cliente se este não estiver 
associado a uma venda. Caso esteja, deve ser exibida a mensagem de 
advertência: “Cliente não pode ser excluído!”. 
Regras de Negócio:
1. Botão Salvar – deve salvar o cadastro na tabela “Clientes”.
2. Botão Excluir – deve excluir o cliente e removê-lo da tabela “Clientes”.
1.4 Cadastro de produtos
A listagem dos produtos cadastrados e um novo cadastro deverão ser 
feitos na mesma tela. A partir dela, deve ser possível fazer a inserção, edição e 
exclusão de um registro. Além da listagem dos produtos cadastrados, devem 
ser exibidos os seguintes campos:
Nome do Campo Tipo Tamanho Obrigatório? Observações
Nome Alfanumérico 60 Sim
Valor de Custo Decimal 10v2-4 Sim Exemplo: 
9999999999,9999
Valor de Venda Decimal 10v2-4 Sim Exemplo: 
9999999999,9999
Botão Salvar - - - -
Botão Cancelar - - - -
Botão Excluir - - - -
SOFTEN SISTEMAS - 2020
Regras de Interface:
1. Botão Salvar – deve validar os campos de preenchimento obrigatório. 
Caso o cadastro seja salvo, deve exibir o novo produto na listagem.
b. Caso algum deles não esteja preenchido, a borda do campo deve 
ser alterada para outra cor a mensagem de advertência deve ser 
exibida: “Campo “Nome_do_Campo” é de preenchimento 
obrigatório! ”.
2. Botão Cancelar – deve descartar qualquer alteração feita e redirecionar 
o usuário para a página inicial.
3. Botão Excluir – deve estar habilitado somente se o usuário logado for 
o Administrador. Quando o produto for excluído, deve ser removido da 
listagem. Só deverá ser possível excluir um produto se este não estiver 
associado a uma venda. Caso esteja, deve ser exibida a mensagem de 
advertência: “Produto não pode ser excluído!”.
Regras de Negócio:
1. Botão Salvar – deve salvar o cadastro na tabela “Produtos”.
2. Botão Excluir – deve excluir o cliente e removê-lo da tabela “Produtos”.
1.5 Pedido de Venda
A listagem dos pedidos de venda cadastrados e um novo cadastro deverão 
ser feitos na mesma tela. A partir dela, deve ser possível fazer a inserção, edição 
e exclusão de um registro. Deverá também ser possível inserir mais de um 
produto em um pedido, mas o cliente deverá ser único. 
Além da listagem dos pedidos de venda cadastrados, devem ser exibidos 
os seguintes campos:
Nome do Campo Tipo Tamanho Obrigatório? Observações
Cliente Alfanumérico 60 Sim
Produto Decimal 10v2-4 Sim Exemplo: 
9999999999,9999
Quantidade Decimal 10v2-4 Sim Exemplo: 
9999999999,9999
Valor Unitário Decimal 10v2-4 Sim Exemplo: 
9999999999,9999
Valor Total Decimal 10v2 Sim Exemplo: 
9999999999,99
Botão Inserir 
Produto
- - - -
Produto Excluir 
Produto
- - - -
Botão Salvar - - - -
Botão Cancelar - - - -
Botão Excluir - - - -
Regras de Interface:
1. Cliente – deve ser possível realizar a busca do cliente a partir dos já 
cadastrados e também a criação de novo cliente. Os componentes a serem 
utilizados para essas operações são de livre escolha.
2. Produto – deve ser possível realizar a busca do produto a partir dos já 
cadastrados e também a criação de novo produtos. Os componentes a 
serem utilizados para essas operações são de livre escolha.
3. Valor Unitário – assim que o produto for inserido, deve exibir o “Valor 
de Venda” associado ao produto.
4. Valor Total – desabilitado para edição. 
5. Botão Inserir Produto – desabilitado até que um produto seja 
selecionado. Caso nenhum produto tenha sido escolhido para inserção, 
deve exibir a mensagem de advertência: “Selecione um produto para 
inserção!”. Quando um produto for inserido, deve ser exibido na listagem 
de produtos associados ao pedido de venda. 
6. Botão Excluir Produto – desabilitado até que um produto inserido no 
pedido de venda seja selecionado. Caso nenhum produto tenha sido 
selecionado para exclusão, deve exibir a mensagem de advertência: 
“Selecione um produto para exclusão!”. Quando um produto for excluído, 
deve ser removido da listagem de produtos associados ao pedido de 
venda.
7. Botão Salvar – deve validar os campos de preenchimento obrigatório. 
Caso o registro seja salvo, deve exibir o novo pedido na listagem.
c. Caso algum deles não esteja preenchido, a borda do campo deve 
ser alterada para outra cor a mensagem de advertência deve ser 
exibida: “Campo “Nome_do_Campo” é de preenchimento 
obrigatório! ”.
4. Botão Cancelar – deve descartar qualquer alteração feita e redirecionar 
o usuário para a página inicial.
5. Botão Excluir – deve estar habilitado somente se o usuário logado for 
o Administrador. Quando o pedido for excluído, deve ser removido da 
listagem de pedidos de venda cadastrados. 
Regras de Negócio:
1. Valor Total – o cálculo do valor total é feito a partir do produto entre o 
“Valor Unitário” e a “Quantidade”. 
2. Botão Salvar – deve salvar os registros nas tabelas “PedidoVenda” e 
“PedidoVendaItens”.
3. Botão Excluir – deve excluir os registros nas tabelas “PedidoVenda” e 
“PedidoVendaItens”.
