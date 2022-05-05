# SPRING DATA JPA

## ORM - Object Relation Mapping:
````
É uma técnica para mapeamento de classes (orientação a objeto) para tabelas de banco relacional.
De forma a simplificar a persitência de dados e tornar possível que
o progamador trabalhe mais com a orientação a objeto e menos no modelo relacional.
````
### Comparação I

|   Modelo Relacional   | Modelo OO |
|   :---:     |   :---:     |
| Tabela  | Classe |
| Linha  | Objeto |
| Coluna  | Atributo |
| :---:   | Método |
| Chave Estrangeira(FK)  | Associação entre Classes |

### Comparação II

|   Modelo Relacional   | Modelo OO |
|   :---:     |   :---:     |
| tab_pessoas  | public class Pessoa |
| :---:  | :---: |
| id BIGINT(20)  | private Long id; |
| :---:   | :---: |
|:---:  | :---: |

### 1. Persistência Com ORM:
### - A ORM traduz as instruções que o nosso código Java passar para ela.
````
Código Java -> ORM -> Driver -> SQL
````
### A. JPA: Java Persistence API
````
É uma especificação JEE, ou seja, uma solução ORM para a persitência de dados padronizado para aplicações Java.
````
#### - Define a forma de mapeamento de objeto relacional
#### - Possui uma API de consultas
#### - Possui uma API de modificação de dados
#### - Tem uma Linguagem de Consultas (JPQL)

### B. Hibernate
````
É uma implementação da especificação JPA.
````
### 2. JPA vs HIBERNATE
````
Código Java -> ORM = JPA (ESPECIFICA:métodos; interfaces;) / HIBERNATE (IMPLEMENTA: métodos e interfaces) -> Driver -> SQL
````
