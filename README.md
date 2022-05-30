# REPOSITORY
#### O Spring Boot terá acesso a todas as informações e/ou os dados Spring que possuem a informação para criar a JPA entity manage factory usando as informações de data source que nós informamos para ele na properties.
##### a. Ele sabe como conectar-se e também estabelecer uma conexão ao database.
##### b. Dessa forma, ele criará uma EntityManager que é a classe chave no JPA.
##### c. E quando executa nossa Interface ProdutoRepositorio com o método respository.save, Spring cria internamente uma implementação, uma implementação representante ( proxy ) dessa classe que retornará os métodos invocados em EntityManager.
##### d. Então, quando invocamos métodos como "save" ou um "find one" ou um "delete", internamente, Spring está invocando os métodos de EntityManager através de uma classe que gera em tempo real a implementação nessa interface em particular e executa as operações de gerenciamento necessárias no Database.
##### e. Com isso, evitamos todos os códigos boiler plates ( vários códigos e estruturas ) e configuração ao simplesmente usar Spring Data que simplifica nossas operações de Database para as nossas aplicações.
