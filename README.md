# *** JPQL
##### a. Significa Java Persistence Query Language.
##### b. Ele é um padrão para fazer queries do JPA que nada tem a ver com objetos e classe de domínios que são escritos em queries sequenciais, diferentes de como são escritas para tabelas e colunas do database.
##### c. JPQL queries são escritas de maneira diferente de nossos objetos e seus campos.
##### d. Exemplo:
##### 1. Database functab: 
|   funcid   |  pname  |    uname    |
| :---         |     :---:      |          ---: |
|   |      |    |
|      |       |      |


##### 2. Entidade Funcionario (definida com JPA) com os três campos que mapeiam as três colunas de functab:
|   Funcionario     | 
| :---         |
| int id;   |
| String pName  (P = primeiro nome)   |
| String uName  (U = ultimo nome)   |
| select * from Funcionario (SQL)|
| select pName,uName from Funcionario(JPQL)   |

##### e. No exemplo acima, as instruções JPQL estão convertendo os domínios das classes e seus campos, que são internamente convertidos pelo nosso ORM igual ao Hibernate no SQL.
##### f. Ele é convertido apropriadamente para o SQL correspondente ao mapeamento da entidade (Funcionario) e o da tabela(functab) do database.
##### g. É possível chamar os parâmetros passados dentro dessas queries.
##### h. Também pode-se utilizar select e nao-select operações como: inster, update, deletes usando JPQL.
##### i. Fazer uso de funções de agregação relacionais e Joins.
##### j. Muito do que há em SQL pode ser convertido e usado em palavras-chaves e síntaxe JPQL.
##### k. JPQL é case sensitive quando quando se trata de nomes de classe de domínio (Funcionario) e seu campos (pName e etc).
##### l. Contudo, JPQL não é case sensitive quando se trata de palavras-chave na própria sintaxe da linguagem como, por exemplo, se você estivesse usando funções agregadas como contagem.
