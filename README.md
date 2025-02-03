# Task Manager API

## 📌 Sobre o Projeto
Task Manager API é uma aplicação Spring Boot desenvolvida para gerenciamento de tarefas. Ela expõe endpoints REST para criar, listar, atualizar e excluir tarefas, utilizando SQL Server como banco de dados.

## ⬇️ Como Baixar

Você pode baixar o projeto diretamente do GitHub, utilizando o seguinte link:

[https://github.com/genilsonalmeida/taskmanagerapi](https://github.com/genilsonalmeida/taskmanagerapi)

## 🚀 Tecnologias Utilizadas

- **Java**: 17
- **Spring Boot**: 3.4.2
- **Maven**: 3.9.9
- **Docker**: 27.4.0
- **Docker Compose**: 2.31.0-desktop.2
- **SQL Server**: 2022
- **Kubernetes (AKS)**: Utilizado para orquestração
- **Azure Pipelines**: CI/CD automatizado

## ⚙️ Requisitos

Antes de iniciar, instale os seguintes componentes:
- [Docker](https://www.docker.com/)
- [Java 17](https://jdk.java.net/17/)
- [Maven](https://maven.apache.org/) (ou utilize `mvnw`)
- [Azure CLI](https://learn.microsoft.com/en-us/cli/azure/install-azure-cli)

## 🚀 Como Executar o Projeto

### 1️⃣ Executando Localmente com Maven

```sh
./mvnw spring-boot:run
```

### 2️⃣ Executando com Docker Compose

Será necessário realizar o build do projeto, executando o comando abaixo na raiz do projeto, antes de executar o comando docker-compose.

```sh
./mvnw clean package -DskipTests
```

Após criar o artefato, o comando do docker-compose abaixo, poderá ser executado.
```sh
docker-compose up -d
```

Isso iniciará a API e o banco de dados SQL Server.

### 📡 Testando a API

Após iniciar a aplicação, você pode testar os endpoints usando o Swagger UI ou via `curl`/Postman.

#### 📌 Base URL:
```
http://localhost:8080/api/tasks
```

#### 🔹 Criar uma nova tarefa (POST `/api/tasks`)
**Requisição:**
```json
{
  "title": "Finalizar documentação",
  "description": "Escrever o README completo do projeto",
  "status": "PENDENTE"
}
```

**Resposta:**
```json
{
  "id": 1,
  "title": "Finalizar documentação",
  "description": "Escrever o README completo do projeto",
  "status": "PENDENTE",
  "createdAt": "2025-02-03T10:00:00"
}
```

---

#### 🔹 Listar todas as tarefas (GET `/api/tasks`)
**Resposta:**
```json
[
  {
    "id": 1,
    "title": "Finalizar documentação",
    "description": "Escrever o README completo do projeto",
    "status": "PENDENTE",
    "createdAt": "2025-02-03T10:00:00"
  },
  {
    "id": 2,
    "title": "Implementar testes",
    "description": "Criar testes unitários para TaskService",
    "status": "CONCLUIDO",
    "createdAt": "2025-02-03T11:00:00"
  }
]
```

---

#### 🔹 Buscar uma tarefa por ID (GET `/api/tasks/{id}`)
**Exemplo:** `/api/tasks/1`  
**Resposta:**
```json
{
  "id": 1,
  "title": "Finalizar documentação",
  "description": "Escrever o README completo do projeto",
  "status": "PENDENTE",
  "createdAt": "2025-02-03T10:00:00"
}
```

---

#### 🔹 Atualizar uma tarefa (PUT `/api/tasks/{id}`)
**Exemplo:** `/api/tasks/1`  
**Requisição:**
```json
{
  "title": "Finalizar README",
  "description": "Escrever a documentação do projeto e revisar",
  "status": "EM_ANDAMENTO"
}
```

**Resposta:**
```json
{
  "id": 1,
  "title": "Finalizar README",
  "description": "Escrever a documentação do projeto e revisar",
  "status": "EM_ANDAMENTO",
  "createdAt": "2025-02-03T10:00:00"
}
```

---

#### 🔹 Deletar uma tarefa (DELETE `/api/tasks/{id}`)
**Exemplo:** `/api/tasks/1`  
**Resposta:**
```json
{
  "message": "Tarefa deletada com sucesso"
}
```

---

## ☸️ Kubernetes e Azure Pipelines

A aplicação pode ser implantada no **Azure Kubernetes Service (AKS)** e utiliza **Azure Pipelines** para CI/CD.

### 📜 Arquivos Importantes

- **`k8s/deployment.yaml`** - Define o deploy da aplicação no Kubernetes
- **`azure-pipelines.yml`** - Configura a pipeline no Azure DevOps

### 📌 Principais Configurações no Azure DevOps

Para que a pipeline funcione corretamente, adicione as seguintes variáveis no Azure DevOps:

| Variável | Valor              |
|-----------|--------------------|
| `ACR_NAME` | myRegistry         |
| `RESOURCE_GROUP` | MyResourceGroup    |
| `AKS_CLUSTER` | MyClusterAKS       |
| `IMAGE_NAME` | taskmanagerapi     |
| `AZURE_SUBSCRIPTION` | (ID da assinatura) |

---
📌 **Projeto desenvolvido para demonstração de conhecimento em APIRest, DevOps e Cloud.** 🚀

