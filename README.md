## *** ORM - Object Relation Mapping (Mapeamento Objeto Relacional)
````
É uma técnica para mapeamento de classes (orientação a objeto) para tabelas de banco relacional.
De forma a simplificar a persitência de dados e tornar possível que
o progamador trabalhe mais com a orientação a objeto e menos no modelo relacional.
````
### 1. Mapeamento Objeto Relacional (ORM) é a representação de uma tabela de um banco de dados relacional através de classes Java.
### 2. Equivalência:

|   Banco de Dados   | Linguagem OO |
|   :---:     |   :---:     |
| Tabela  | Classe |
| Linha / Registro  | Objeto |
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

### 3. Para completar, temos as anotações que adicionarão metadados às classes e permitirão os frameworks ORM, como Hibernate ou EclipseLink, entrarem em ação.
````
* @Entity
* @Table
* @Id
* @Column
````
### 4. Persistência Com ORM:
### - A ORM traduz as instruções que o nosso código Java passar para ela.
````
Código Java -> ORM -> Driver -> SQL
````
