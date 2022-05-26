# Agendamento de Paciente - App
## Caso de Uso:
### 1. A aplicação tem:
#### i. paciente chega até - a:
#### ii. Recepção do hospital - que usa:
#### iii. Agendamento de Paciente Sistema - para:
#### iv. Criar um agendamento - onde:
#### v. Database - que lê e retorna para:
#### vi. Recepção do hospital
### 2. O sistema tem a capacidade:
#### i. Checar - quando o paciente terá data para o agendamento.
#### ii. Checa a saída dele também da data de agendamento colocando uma flag no database.
### 3. Raciocínio:
#### A. Quais os objetos ou modelos de classes, e até mesmo, as tabelas do database que poderíamos criar diante dese caso de uso?
#### B. Objetos:
#### - Paciente:
##### i. Carrega as informações do paciente
##### ii. Pagamento. 
#### - Médico:
##### i. Quer consultar.
#### - Agendamento:
##### i. Informação sobre datas disponíveis.
##### ii. Inscrição de pacientes.
##### iii. Saída de pacientes da agenda.
##### - Podemos dizer que temos 3 objetos: Paciente, Médico e Agendamento.
#### C. Relacionamentos e Associações ( tabelas )
##### i. OneToMany -> Paciente 1 <--------------------------> * Agendamento <- ManyToOne
##### ii. OneToMany -> Médico 1 <--------------------------> * Agendamento <- ManyToOne
##### i.ManyToMany -> Paciente * <--------------------------> * Médico <- ManyToMany
##### - Temos então daí, vendo pelo database, três tabelas: Paciente, Médico e Agendamento.
##### - E ainda devemos considerar mais uma: uma Tabela para o Join: pacientes_medicos.
##### - Então no total ficam 4 tabelas com a de Join.
### 4. Por onde começar:
#### i. Criar o Database Schema: criar a tabela Agendamento que requererá a criação das tabelas medico, paciente_medicos e paciente
#### ii. Criar o Projeto Spring Data: cria entidades, repositorios e testes para o agendamento dos pacientes.
#### iii. Incorporar ( to embedded ) SeguroSaude dentro de Paciente.
#### iv. Definir a associação entre Paciente e Médico e também fazer o Join entre entidades.

# VERIFICAR O REPOSITORIO SQL CORRESPONDENTE A ESSE APP NAS BRANCHES
