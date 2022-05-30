# JPA REPOSITORY
#### O Spring Boot terá acesso a todas as informações e/ou os dados Spring que possuem a informação para criar a JPA entity manage factory usando as informações de data source que nós informamos para ele na properties.
##### a. Ele sabe como conectar-se e também estabelecer uma conexão ao database.
##### b. Dessa forma, ele criará uma EntityManager que é a classe chave no JPA.
##### c. E quando executa nossa Interface ProdutoRepositorio com o método respository.save, Spring cria internamente uma implementação, uma implementação representante ( proxy ) dessa classe que retornará os métodos invocados em EntityManager.
##### d. Então, quando invocamos métodos como "save" ou um "find one" ou um "delete", internamente, Spring está invocando os métodos de EntityManager através de uma classe que gera em tempo real a implementação nessa interface em particular e executa as operações de gerenciamento necessárias no Database.
##### e. Com isso, evitamos todos os códigos boiler plates ( vários códigos e estruturas ) e configuração ao simplesmente usar Spring Data que simplifica nossas operações de Database para as nossas aplicações.
## Conexão de múltiplos Databases e Datasources
### 1. App Conectando ao mesmo tempo como:
#### - O próprio database
#### - O database H2 ( database in-memory )
### 2. São dois como exemplo, mas podem ser bem mais.
### 3. Anotações em :
#### - Entidades JPA
#### - Repositories
### 4. Configurações em:
#### - Properties
#### - DataSource
#### - EntityManagerFactory
#### - TransactionManager
#### - E tudo feito separadamente para cada Database.

### Dependência
````
<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
</dependency>
````
