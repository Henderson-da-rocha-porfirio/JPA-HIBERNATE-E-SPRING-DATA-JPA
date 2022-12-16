# JpaSpecificationExecutor

## Ela possui métodos como:
````
java.util.Optional<T> findOne(@org.springframework.lang.Nullable org.springframework.data.jpa.domain.Specification<T> specification);

java.util.List<T> findAll(@org.springframework.lang.Nullable org.springframework.data.jpa.domain.Specification<T> specification);

org.springframework.data.domain.Page<T> findAll(@org.springframework.lang.Nullable org.springframework.data.jpa.domain.Specification<T> specification, org.springframework.data.domain.Pageable pageable);

java.util.List<T> findAll(@org.springframework.lang.Nullable org.springframework.data.jpa.domain.Specification<T> specification, org.springframework.data.domain.Sort sort);

long count(@org.springframework.lang.Nullable org.springframework.data.jpa.domain.Specification<T> specification);
````

## E recebe como parâmetros, um specification.

## Isso faz com que o find consiga ser passado nele os specifications:
### comFreteGratis e o comNOmeSemelhante na controller: 
`````
(...) .findAll(comFreteGratis.and(comNOmeSemelhante));
````
## E cada Specification, cria um predicate do JPA (procurar no codigo por predicate
### Exemplo: restaurantes com frete gratis ou com nome semelhante, fazer o teste no Postman.
