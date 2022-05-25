# bixb

## Pré Requisitos

- Java 17
- Docker
- Docker Compose

## Arquitetura

![arquitetura](arquitetura.jpg)

## Executando

`docker-compose up --build`

## Endpoints
### Enviando mensagem para o kafka
```
curl -X POST \
http://localhost:8081/message \
-H 'Accept: application/json' \
-H 'Content-Type: application/json' \
-d '{"name": "Tenis Nike Vapor max"}'

```

### Validando que o consumidor recebeu a mensagem e salvou no banco de dados
`curl localhost:8080/crud/products`
