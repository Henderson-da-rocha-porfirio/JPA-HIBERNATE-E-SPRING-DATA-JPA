# JPA AssociationsMappings
### 1. Como Exemplo temos um Shopping App onde nós não pomos todos os dados dentro de uma única tabela no database como na tabela Order:
|   id   |  productname  |    description    |    shippingaddress    |
| :---         |     :---:      |          ---: |     :---:      |
|   |      |    |
### 2. Geralmente criamos as regras do nosso database em tabelas separadas que parece mais o apropriado no armazenamento dos dados dessa forma, onde a comunicação entre estas tabelas se dá em forma de relacionametos através de primary e foreign keys:
#### a. Pedidos (Order)
|   :---   | address_id  |    product_id    |
| :---:        |     ---:      |     :---:      |
|   |      |
#### b. Produto
|   id   | ---:  |
| :---         |     ---:      |
|   |      |
#### c. Endereco
|   id   | street  |    city    |
| :---         |     ---:      |     :---:      |
|   |      |
### 3. É por isso que precisamos de um AssociationsMappings. Para podermos, através dessas associações de mapeamento entre elas, navegar através delas.
### 4. E teremos várias queries sofrendo joins e etc que serão gerados pelo hibernate ou alguma outra implementação do JPA.
# Relacionamentos
### 1. ONE TO ONE
#### a. Pessoa - Uma Pessoa tem uma Licenca
|   Long id   |
|     :---:      |
| Licenca licenca |
|   |
#### b. Licenca - E Licenca pertence a uma Pessoa em particular
|   Long id   |
|     :---:      |
| Pessoa pessoa |
|   |
### 2. MANY TO MANY -
#### a. Encomenda (Order) - Uma Encomenda pode ter múltiplos produtos.
|   Long id   |
|    :---:    |
| Set < Produto > produtos |
|   |
#### b. Produto - E um Produto pode pertencer a várias encomendas.
|   Long id   |
|    :---:    |
| String name |
|Set < Encomenda > encomendas |
### 3. ONE TO MANY e MANY TO ONE
#### a. Cliente - Um cliente pode ter vários números de telefone //  Da perspectiva do cliente o relacionamento é ONE TO MANY.
|   Long id   |
|   :---:     |
| Set < NumeroTelefone > numbers |
|   |
#### b. NumeroTelefone - E um número pode pertencer a um cliente apenas. //  Da perspectiva do NumeroTelefone o relacionamento é MANY TO ONE
|   Long id   |
|     :---:   |
| String number |
| |
### 4. E há dois modos que estes relacionamentos podem ocorrer:
#### a. Unidirecional - Significa que somente nós estaremos habilitados para acessar esse relacionamento de maneira única.
##### 1. Exemplo: Se este Cliente for configurado ONE TO MANY de Cliente para NumeroTelefone, nós não conseguiremos usar a Entidade NumeroTelefone
##### 2. Mas nós conseguiremos acessar o NumeroTelefone do Cliente que é Unidirecional. Para que haja acceso, é preciso configurar de um lado e do outro esse tipo de modo Unidirecional de relacionamento.
##### 3. Cliente - Um cliente pode ter vários números de telefone //  Da perspectiva do cliente o relacionamento é ONE TO MANY.
|   Long id   |
|   :---:      |
| Set <  NumeroTelefone > numbers |
|   |
##### 4. NumeroTelefone - E um número pode pertencer a um cliente apenas. //  Da perspectiva do NumeroTelefone o relacionamento é MANY TO ONE
|   Long id   |
|     :---:   |
| String number |
| |
#### b. Bidirecional - Significa que podemos acessar os objetos ou entidades uns dos outros. E conseguiremos navegar de Cliente para NumeroTelefone e vice-versa.
# Annotations
### 1. @OneToOne
### 2. @OneToMany
### 3. @ManyToOne
### 4. @ManyToMany
### 5. @Temporal (TemporalType.DATE) = Ao utilizarmos o Tipo Date, precisamos marcá-los com a @Temporal de javax.persistence
### 6. @JoinTable = E usando @JoinTable, estamos falando para o hibernate que esta é uma tabela Join e também informará o que são as chaves na tabela do database em questão e como elas estão associadas.
### 7. @joinColumns =  coluna join da tabela.
# Entendendo as Associações
### 1. [OneToMany] ->  Cliente 1(um cliente)  ------------------>  *(Vários NumeroTelefone) NumeroTelefone <- [ManyToOne]
### 2. Quando declaramos uma lista de NumeroTelefone dentro da classe Cliente, porque um Cliente pode ter vários numerosTelefone, e do lado do NumeroTelefone nós definirmos um objeto cliente por causa de múltiplos numerosTelefone pertecerem a um único cliente. Então colocamos a seguinte anotação:
#### a. @OneToMany acima de List<NumeroTelefone> numerosTelefone; em Cliente
|   Cliente   |
|    :---:    |
|    @OneToMany     |
| List < NumeroTelefone > numerosTelefone;|
#### b. @ManyToOne acima de Cliente cliente; em NumeroTelefone
|   NumeroTelefone   |
|     :---:      |
|    @ManyToOne    |
| Cliente cliente |
### 3. Nesse caso, @OneToMany pode ser chamada como um tipo de associação Pai porque um Cliente pode ter múltiplos NumeroTelefone.
### 4. E chamamos NumeroTelefone como uma tipo de associação Filho porque muitos NumeroTelefone podem pertencer a um único Cliente.
# Entendendo os Modos de Associações
## A. Bidirecional
### 1. No exemplo abaixo, nós navegamos de Cliente para todos os seus numerosTelefone. E nós podemos recuperar todos os numerosTelefone de List de Cliente e de NumeroTelefone nós podemos ir ao seu cliente.
#### a. @OneToMany acima de List<NumeroTelefone> numerosTelefone; em Cliente
|   Cliente   |
|    :---:      |
|    @OneToMany     |
| List < NumeroTelefone > numerosTelefone;|
#### b. @ManyToOne acima de Cliente cliente; em NumeroTelefone
|   NumeroTelefone   |
|     :---:      |
|    @ManyToOne    |
| Cliente cliente |
## B. Unidirecional
### 1. No exemplo abaixo, nós não precisamos definir o Cliente com a @ManyToOne e ele já se torna uma associação de modo unidirecional.
### 2. Porque navegamos de Cliente para os NumeroTelefone dele:
#### a. Não precisa por @ManyToOne acima de Cliente cliente; em NumeroTelefone.
#### b. Contudo, como não definimos o Cliente de NumeroTelefone com a anotação @ManyToOne, não vamos conseguir navegar de NumeroTelefone para Cliente. E daí a listagem não funcionará.
|   NumeroTelefone   |
|    :---:     |
| Cliente cliente |
#### b. @OneToMany acima de List<NumeroTelefone> numerosTelefone; em Cliente
|   Cliente   |
|    :---:      |
|    @OneToMany     |
| List < NumeroTelefone > numerosTelefone;|
### 3. Então dependerá da regra de negócio se faremos a associação Unidirecional ou Bidirecional.
