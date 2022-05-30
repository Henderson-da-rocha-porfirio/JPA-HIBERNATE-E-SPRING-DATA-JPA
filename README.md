# ACID-PROPRIEDADES - Transaction Management

### Propriedades ACID
#### a. Automicity
#### b. Consistency
#### c. Isolation
#### d. Durability
### 4. Propriedades ACID em Execução
#### a. Automicity - Ambos Updates acontecerão ou não acontecerão e isso é atômico a uma simples unidade de trabalho.
|   :---:  |   contaId   | nome | balanco | :---: |
|   :---:   |   :---:     |   :---:     | :---: | :---: |
|   update ->   | 1  | João | 1000 | -500 |
|   update ->   |2	 | Maria | 200  | +500 |
|   :---:   |:---: | :---: | :---:  | :---: |
#### b. Consistency - Significa que o data base deveria ser deixado em um estado consistente até o fim da transação. Tudo tem que estar em perfeito estado conforme o ciclo que acontecerá e terminará e não haverá nenhum dano.
#### Se olharmos o balanco, o balanco total no fim da transação será consistente. Ou seja, R$ 500 foram deduzidos de João e foi adicionado na conta de Maria. No final, haverá 500 reais na conta de João e 700 reais na conta de Maria.
|   :---:  |   contaId   | nome | balanco | :---: |
|   :---:   |   :---:     |   :---:     | :---: | :---: |
|   update ->   | 1  | João | 1000 | -500 |
|   update ->   |2	 | Maria | 200  | +500 |
|   :---:   |:---: | :---: | :---:  | :---: |
#### c. Isolation - Significa que há muitas transações acontecendo e cada uma dessas deveriam trabalhar isoladas sem impactar umas as outras.
|   :---:  |   contaId   | nome | balanco | :---: |
|   :---:   |   :---:     |   :---:     | :---: | :---: |
|   update ->   | 1  | João | 1000 | -500 |
|   update ->   |2	 | Maria | 200  | +500 |
|   :---:   |:---: | :---: | :---:  | :---: |
#### d. Durability - Uma vez que a transação muda, essas são committed e deveriam permanecer no database que é durável.
|   :---:  |   contaId   | nome | balanco | :---: |
|   :---:   |   :---:     |   :---:     | :---: | :---: |
|   update ->   | 1  | João | 1000 | -500 |
|   update ->   |2	 | Maria | 200  | +500 |
|   :---:   |:---: | :---: | :---:  | :---: |
