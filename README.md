# SPRING DATA JPA

## *** JPA -  Java Persistence API
### 1. É uma especificação oficial que descreve como deve ser o comportamento dos frameworks de persistência Java que desejarem implementá-la..

### 2. Podemos imaginar que a especificação JPA como uma interface que possui algumas assinaturas, mas que precisa que alguém a implemente.

### 3. Apesar de não ter nada executável, a especificação possui algumas classes, interfaces e anotações que ajudam o desenvolvedor a abstrair o código.

### 4. São artefatos do pacote javax.persistence que ajudam a manter o código independente das implementações da especificação.

### 5. Assim não precisamos importar classes de terceiros em nosso código.

### 6. Implementação é quem dá vida para a especificação. É o código que podemos executar, que chamamos de framework.

### 7. Enfim, para persistir dados com JPA, é preciso escolher uma implementação que é quem, de fato, vai fazer todo o trabalho

### 8. É um papel importante para mostrar para a comunidade que a especificação é possível e viável.

### 9. A grande ideia da especificação JPA é que a aplicação possa trocar de implementação sem que precise de mudanças no código. Apenas um pouco de configuração.

### 10. Uma mesma aplicação que poderia estar rodando no GlassFish com EclipseLink poderia também funcionar no WildFly com Hibernate

### 11. Temos como implementação o OpenJPA da Apache, o Hibernate da Red Hat e o EclipseLink da Eclipse Foundation.

### 12. As duas mais importantes são o Hibernate, por ainda ser a mais utilizada, e o EclipseLink, por ser a implementação de referência.
````
Fonte: https://blog.algaworks.com/tutorial-jpa/
````
## *** JPA: Java Persistence API - Detalhes
````
É uma especificação JEE, ou seja, uma solução ORM para a persitência de dados padronizado para aplicações Java.
````
#### - Define a forma de mapeamento de objeto relacional
#### - Possui uma API de consultas
#### - Possui uma API de modificação de dados
#### - Tem uma Linguagem de Consultas (JPQL)

## *** JPA vs HIBERNATE
````
Código Java -> ORM = JPA (ESPECIFICA:métodos; interfaces;) / HIBERNATE (IMPLEMENTA: métodos e interfaces) -> Driver -> SQL
````

## *** JPA & SPRING - O FLUXO DE EXECUÇÃO E O JPA
### A. Entendendo o Fluxo de Execução do Spring ao corrermos ( run ) a nossa aplicação:
#### 1. MAVEN CLASSPATH: Ele começa buscando em nossa classpath as dependências do Maven que foram inicializadas na instalação do projeto como o Spring:
##### a. Se não usarmos outro fornecedor(vendor) ORM ( Object Relational Mapping = processo de mapeamento de uma classe java à tabela do database e seus campos ou membros para as colunas das tabelas existentes. ), ele usará o hibernate por default.
##### b. Busca também pelo connector sql ( ou mysql se estiver usando ).
#### 2. APPLICATION PROPERTIES: Percebe que nós estamos buscando conectar o sql database e busca pelo application.properties.
##### a. E acha as informações relativas a conexão como url, username, password e etc.
#### 3. PACKAGES: Escaneia todos os sub-packages do package principal em que a classe Main estar presente.
##### a. Por isso esta classe precisa estar com a annotation @SpringBootApplication para ela escanear tanto o Package quanto os sub-packages.
#### 4. REPOSITORY: O Spring Boot terá acesso a todas as informações e/ou os dados Spring que possuem a informação para criar a JPA entity manage factory usando as informações de data source que nós informamos para ele na properties.
##### a. Ele sabe como conectar-se e também estabelecer uma conexão ao database.
##### b. Dessa forma, ele criará uma EntityManager que é a classe chave no JPA.
##### c. E quando executa nossa Interface ProdutoRepositorio com o método respository.save, Spring cria internamente uma implementação, uma implementação representante ( proxy ) dessa classe que retornará os métodos invocados em EntityManager.
##### d. Então, quando invocamos métodos como "save" ou um "find one" ou um "delete", internamente, Spring está invocando os métodos de EntityManager através de uma classe que gera em tempo real a implementação nessa interface em particular e executa as operações de gerenciamento necessárias no Database.
##### e. Com isso, evitamos todos os códigos boiler plates ( vários códigos e estruturas ) e configuração ao simplesmente usar Spring Data que simplifica nossas operações de Database para as nossas aplicações.
