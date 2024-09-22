# SPRING DATA JPA E HIBERNATE
## *** Verificar os outros repositórios sobre JPA e suas branches ***
## *** Verificar os outros repositórios SQL para a realização de testes ***

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

Vamos por partes e detalhar cada um dos pontos com exemplos de código e uma explicação mais clara.

### 1. Explicação do **Spring Data JPA** com exemplo de código

O **Spring Data JPA** é uma ferramenta poderosa que reduz o trabalho repetitivo ao lidar com persistência de dados. Ele permite a criação de repositórios (interfaces que herdam de `JpaRepository` ou `CrudRepository`) que fornecem automaticamente métodos prontos para realizar operações CRUD (Create, Read, Update, Delete).

#### Exemplo prático:

1. **Entidade JPA**:
   Definimos uma entidade usando as anotações JPA.

   ```java
   import javax.persistence.Entity;
   import javax.persistence.GeneratedValue;
   import javax.persistence.GenerationType;
   import javax.persistence.Id;

   @Entity
   public class Produto {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       private String nome;
       private Double preco;

       // Getters e Setters
   }
   ```

2. **Repositório com Spring Data JPA**:
   Criamos uma interface de repositório para a entidade `Produto`. Não precisamos escrever a implementação, o **Spring Data JPA** gera isso automaticamente.

   ```java
   import org.springframework.data.jpa.repository.JpaRepository;

   public interface ProdutoRepository extends JpaRepository<Produto, Long> {
       // Não é necessário escrever implementação.
   }
   ```

3. **Exemplo de uso no serviço**:
   Você pode injetar o repositório e utilizar os métodos prontos para operações de banco de dados.

   ```java
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.stereotype.Service;

   @Service
   public class ProdutoService {
       
       @Autowired
       private ProdutoRepository produtoRepository;

       public List<Produto> listarTodos() {
           return produtoRepository.findAll();
       }

       public Produto salvar(Produto produto) {
           return produtoRepository.save(produto);
       }
   }
   ```

4. **Consultas personalizadas com @Query**:
   Caso queira criar uma consulta específica, pode usar a anotação `@Query`.

   ```java
   import org.springframework.data.jpa.repository.Query;
   import org.springframework.data.repository.query.Param;

   public interface ProdutoRepository extends JpaRepository<Produto, Long> {
       
       @Query("SELECT p FROM Produto p WHERE p.preco > :preco")
       List<Produto> findProdutosComPrecoMaiorQue(@Param("preco") Double preco);
   }
   ```

Aqui, o **Spring Data JPA** abstrai a maior parte do trabalho, enquanto o **Hibernate** lida com a implementação real do JPA, como o mapeamento objeto-relacional e a geração de SQL.

### 2. O que é o **Hibernate** e como ele se encaixa no Spring Data JPA?

O **Hibernate** é uma **implementação da especificação JPA**. Isso significa que o Hibernate implementa as interfaces e regras definidas pela JPA. Ele é um **framework ORM (Object-Relational Mapping)**, responsável por converter dados entre o modelo de objetos (classes Java) e o modelo relacional (tabelas no banco de dados).

#### Relação entre **Spring Data JPA** e **Hibernate**:
- **Spring Data JPA** atua como uma camada de abstração sobre a JPA e, por padrão, usa o **Hibernate** como a implementação JPA subjacente. Isso significa que quando você está utilizando **Spring Data JPA**, o Hibernate está "por baixo dos panos", gerenciando a comunicação real com o banco de dados.
- Quando você define entidades e repositórios no **Spring Data JPA**, ele usa o **Hibernate** para mapear essas entidades e realizar as consultas.

#### Na prática:

1. O **Hibernate** realiza o mapeamento entre as classes Java e as tabelas no banco de dados usando anotações como `@Entity`, `@Table`, `@Id`, etc.
   
   Exemplo:
   ```java
   @Entity
   @Table(name = "produtos")
   public class Produto {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       private String nome;
       private Double preco;
       // Getters e Setters
   }
   ```

2. Quando você chama um método como `findAll()` ou `save()` no repositório do **Spring Data JPA**, o **Hibernate** gera a consulta SQL adequada e a executa no banco de dados.

3. O **Spring Data JPA** utiliza o **Hibernate** para gerenciar sessões de banco de dados, transações e caching. Tudo isso acontece automaticamente, sem você precisar se preocupar com os detalhes de baixo nível.

Em resumo:
- **Spring Data JPA** fornece uma interface simples e poderosa para trabalhar com persistência de dados, e o **Hibernate** é quem faz o trabalho real de ORM e execução de SQL por trás do Spring Data JPA.
- O Hibernate é embutido dentro do **Spring Data JPA**, mas você também pode usar o Hibernate diretamente, se preferir lidar com mais detalhes do mapeamento e controle sobre as transações e queries.

Essa combinação traz simplicidade com a abstração do Spring Data JPA e a robustez do Hibernate como o motor por trás do JPA.
