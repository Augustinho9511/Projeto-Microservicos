🚀 Microsserviços com Java & Spring Cloud: Venda e Financeiro
Este projeto é uma demonstração prática de uma arquitetura de microsserviços utilizando o ecossistema Spring. O objetivo principal foi implementar a comunicação síncrona entre serviços independentes, utilizando Docker para orquestração e OpenFeign para chamadas HTTP.

🏗️ Arquitetura do Sistema
O sistema é composto por dois serviços principais:

Venda-Service (Porta 8081): Responsável por receber as ordens de venda. Após validar a venda, ele notifica o serviço financeiro.

Financeiro-Service (Porta 8082): Responsável por processar a faturação das vendas recebidas.

Fluxo de Comunicação:
O utilizador faz um POST para o Venda-Service.

O Venda-Service utiliza um Feign Client para chamar o endpoint do Financeiro-Service.

Ambos os serviços correm em containers Docker isolados, comunicando através de uma rede virtual interna.

🛠️ Tecnologias Utilizadas
Java 17/21

Spring Boot 3

Spring Cloud OpenFeign (Comunicação entre serviços)

Gradle (Gestor de dependências)

Docker & Docker Compose (Containerização e Orquestração)

H2 Database (Base de dados em memória para testes rápidos)
