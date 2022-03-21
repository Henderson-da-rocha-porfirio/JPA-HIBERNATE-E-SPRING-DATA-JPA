# Mapeamento de Herança no Hibernate
##Nós usamos herança em java para adicionar extensibilidade e reusibilidade para usar e criar novas classes de nossas classes domínios como simples objetos Java antigos que podem usar herança quando aplicadas ou aplicáveis e possíveis.

## Por exemplo temos:

### 1. caso de uso Pagamento.
### 2. Duas formas de pagamento: cartão de crédito ou um cheque.
### 3. Quando aplicamos herança para todos estes campos em comum como ID e Montante, vamos a uma classe pai chamada Pagamento. E esses dois modos de pagamento tem seus próprios filhos.
### 4. E eles terão campos específicos e outros que não são em comum.
### 5. Cartão de Crédito: cardnumber
### 6. Cheque: chequenumber
### 7. Mas basicamente, os databases não suportam mapeamento de herança através das tabelas do database. ( isso é um problema em ORM ).
### 8. E para resolver este problema, o JPA provê mapeamento de herança através de três tipos de simples tabelas estratégias:
#### a. SINGLE_TABLE
##### 1. Essa estratégia traz todas as informações de Cartão de crédito ou cheque, numa simples tabela:
|  PMODE     | 
| :---:         |
|   cc   |
|   cq   |
##### 1.1  cc - Cartão de crédito - Quando o Hibernate verifica " cc ", ele sabe que essa linha tem que ser convertida num cartão de crédito.
##### 1.2 cq - Cheque - Quando o Hibernate verifica " cq ", ele sabe que essa linha tem que ser convertida num cheque.
##### 2. Para isso ocorrer, utilizamos duas anotações: @Inheritance e @DiscriminatorColumn em Pagamento ( classe Pai ).
##### 3. E utilizamos @DiscriminatorValue nas classes-filhas.

#### b. TABLE_PER_CLASS
##### 1. Essa estratégia traz todas as informações de Cartão de crédito ou cheque, serem armazenadas nos campos apropriados das tabelas:
###### cc
|   id   |  amount  |    cardnumber    |
| :---         |     :---:      |          ---: |
| alinhado a esquerda   | alinhado ao centro     | alinhado a direita    |
###### cq
|   id   |  amount  |    checknumber    |
| :---         |     :---:      |          ---: |
| alinhado a esquerda   | alinhado ao centro     | alinhado a direita    |

##### 1.1 Tabelas recuperam informações através dos ID's.
##### 1.2 Apesar de ser mais rápida, não é muito recomendada como ela faz a duplicação das colunas através das tabelas. É possível que gere alguma falha de normalização da regra.
#### c. JOINED
