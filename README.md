# Service IMPL
## Services Layer ( Camada de Serviço )
### - Eles são os responsáveis, dentro do caso de uso deste projeto, para transferir o dinheiro.
### - Será criado uma Interface de serviço de conta bancária, ContaBancariaService, que Implementará uma nova Interface que será criada chamada ContaBancariaServiceImpl, e essa usará ContaBancariaRepo para transferir o dinheiro.
|   Transferência de Dinheiro (caso de uso)  |   :---:     |
|   :---:     |   :---:     |
| Interface: ContaBancariaService|  Implementará:     |
| Interface: ContaBancariaServiceImpl    |   Que usará:    |
| Interface: ContaBancariaRepo    |   Para transferir o dinheiro.     |
