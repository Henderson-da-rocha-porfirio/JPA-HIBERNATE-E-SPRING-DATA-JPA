# SPRING DATA JPA E HIBERNATEe
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
