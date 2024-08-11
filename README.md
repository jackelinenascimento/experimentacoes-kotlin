# Projeto Kotlin com Spring Boot

Este projeto é uma aplicação baseada em Kotlin e Spring Boot, projetada para demonstrar a criação de uma API REST simples para gerenciar entidades `Person`. A aplicação inclui operações CRUD (Create, Read, Update, Delete) e utiliza boas práticas de design de código.

## Estrutura do Projeto

- **src/main/kotlin/org/example**
    - `Application.kt` - Classe principal para iniciar a aplicação Spring Boot.
    - **domain**
        - `model/Person.kt` - Modelo de dados para a entidade `Person`.
        - `repository/PersonRepository.kt` - Repositório para acesso aos dados da `Person`.
        - `service/PersonService.kt` - Interface para serviços relacionados à `Person`.
        - `service/PersonServiceImpl.kt` - Implementação do serviço `PersonService`.
    - **adapter**
        - `api/PersonController.kt` - Controlador REST para expor a API para a entidade `Person`.

## Configuração do Projeto

O projeto usa Gradle para gerenciamento de dependências e tarefas de construção. O arquivo `build.gradle.kts` já está configurado com plugins e dependências necessários.

### Instalar Dependências

Execute o seguinte comando para baixar e instalar as dependências do projeto:

```bash
./gradlew build
```

### Executar a Aplicação
Para iniciar a aplicação, execute o seguinte comando:

```bash
./gradlew bootRun
```
# Acessar a API

A API estará disponível em [http://localhost:8080](http://localhost:8080). Você pode usar ferramentas como Postman ou curl para testar os endpoints da API.

## Endpoints da API

### Criar uma Pessoa

**POST /persons**

**Corpo da requisição:**

```json
{
  "name": "Nome da Pessoa",
  "age": 30
}
```

### Obter Pessoa por ID

**GET /persons/{id}**

**Retorno:**

```json
{
  "id": "UUID",
  "name": "Nome da Pessoa",
  "age": 30
}
```

### Obter Todas as Pessoas

**GET /persons**

**Retorno:**

```json
[
  {
    "id": "UUID",
    "name": "Nome da Pessoa",
    "age": 30
  }
]
```

### Excluir Pessoa por ID

**DELETE /persons/{id}**

## Testes

Os testes são configurados usando JUnit. Para executar os testes, use o comando:

```bash
./gradlew test

```

## Configuração de Qualidade de Código

O projeto usa ktlint para formatação e verificação de estilo de código Kotlin. Para executar o ktlint, use:

```bash
./gradlew ktlintCheck
```

## Configuração de Qualidade de Código

Para corrigir automaticamente os problemas encontrados pelo ktlint, use:

```bash
./gradlew ktlintFormat
```

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para enviar um pull request ou abrir uma issue para sugestões e melhorias.

## Licença

Este projeto é licenciado sob a MIT License.






