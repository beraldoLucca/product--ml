# Gerenciamento de produto

O projeto mostra os produtos existentes no banco de dados.

## Sumário

- [Descrição](#descrição)
- [Instalação](#instalação)
- [Uso](#uso)
- [Endpoints de Testes](#endpoints-de-testes)
- [Autores e Reconhecimentos](#autores-e-reconhecimentos)

## Descrição

O projeto consegue listar um produto a partir de seu id e do id de sua respectiva categoria.

## Instalação e Uso

Instruções para instalação do projeto.

```bash
# Clone o repositório
git clone https://github.com/beraldoLucca/fast-food.git

# Navegue até o diretório do projeto
cd product

# Rode a aplicação com o seguinte comando
java --jar product-0.0.1-SNAPSHOT.jar

# Depois da aplicação estar rodando, acesse a URL do Swagger
http://localhost:8080/swagger
```

## Endpoints de Testes

### Introdução
Aqui estão os endpoints da API que você pode usar para testar as funcionalidades.


### Endpoints principais:

-   ### Buscar produtos por id do produto e da categoria
    - #### URL: /api/v1/product/{productId}/category/{categoryId}
        - exemplo: api/v1/product/1/category/1
    - #### Método: `GET`
    - #### Resposta:
    [{"id": 1,
    "name": "Coxinha",
    "category": "LANCHE",
    "price": 5.90,
    "description": "Salgado frito recheado com frango",
    "image": "example.html"}]

## Autores e Reconhecimentos

Lucca Beraldo

