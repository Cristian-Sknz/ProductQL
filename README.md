# Spring Framework com GraphQL

Este pequeno projeto, serviu como aprendizado, pois nele implementei o GraphQL junto ao Spring.

## Sobre
Foi utilizado o H2 Database como banco de dados, e ele irá funcionar em memoria, ou seja sempre que reiniciado ele ira apagar os dados gerados anteriormente.

Ao iniciar a aplicação alguns dados serão adicionados automaticamente no banco de dados.

`schema.graphqls`
```graphql
# Models
type Product {
    id: ID!,
    name: String,
    price: Float,
    category: Category
}

enum Category {
    FOOD
    UTILITY
    AUTOMOTIVE
    HOME_APPLIANCES
    UNDEFINED
}

#Inputs
input ProductInput {
    name: String,
    price: Float,
    category: Category
}

# Queries
type Query {
    getAllProducts: [Product],
    getProductById(id: Int): Product
}
# Mutations
type Mutation {
    saveProduct(product: ProductInput): Product,
    deleteProduct(id: Int): Boolean
}
```
#### Exemplo de Query:
```graphql
query {
    getAllProducts {
        id
        name
        category
        price
    }
}
```

#### Exemplo de Mutation:
```graphql
mutation ($input: ProductInput) {
    saveProduct(product: $input) {
        id
        name
        category
        price
    }
}
```

#### Exemplo de Subscription:
Nenhuma Subscription foi adicionada neste projeto.

### Dependencias utilizadas:
Implementações:
* Spring Data JPA 
* Spring Web
* H2 Database
* GraphQL Spring Boot Starter
* GraphQL Java Tools

Desenvolvimento:
* Spring DevTools
* GraphiQL (UI Interface)