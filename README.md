# Bootcamp ZUP Orange Talents 6

## Desafio - Casa do Código

### Implementing a Rest API for "Casa do Código" using Java, Spring Boot and Hibernate.

## Rotas


### Autor

#### Cadastrar um novo autor

| URL  | Tipo |  Descrição |
| ---- | ---- |---- | 
|/autor | POST | Cadastro autor

+ Response 200 (application/json)

+ Attributes (object)

    + name [ string - required ]
    + email [ string - required, unique, valid format ]
    + description [ String - required, size (max 400) ]

+ Request (application/json)

**Corpo da requisição**:

```json
{
    "name": "Eiichiro Oda",
    "email": "email@email.com",
    "description": "One Piece"
}
```


### Categoria

#### Cadastrar uma nova categoria

| URL  | Tipo |  Descrição |
| ---- | ---- |---- |
|/categoria | POST | Cadastro categoria

+ Response 200 (application/json)

+ Attributes (object)

    + name [ string - required, unique ]

+ Request (application/json)

**Corpo da requisição**:

```json
{
    "name": "Manga"
}
```


### Livro

#### Cadastrar um novo Livro

| URL  | Tipo |  Descrição |
| ---- | ---- |---- |
|/livro | POST | Cadastro livro

+ Response 200 (application/json)

+ Attributes (object)

    + title [ string - required, unique ]
    + overview [ string - required, size (max 500) ]
    + summary [ String ]
    + price [ BigDecimal - required, min (20) ]
    + numberOfPages [ Integer - required, min (100) ]
    + isbn [ String - required, unique ]
    + publicationDate [ LocalDate - required, future, format(dd/MM/yyyy) ]
    + idCategory [ Long - required, must exist ]
    + idAuthor [ Long - required, must exist ]

+ Request (application/json)

**Corpo da requisição**:

```json
{
    "title": "Star Wars",
    "overview": "A long time ago in a galaxy far far away...",
    "summary": "Chapter V: The Empire Strikes Back",
    "price": 50.50,
    "numberOfPages": 200,
    "isbn": "XXXXXXXX",
    "publicationDate": "30-12-2050",
    "idCategory": 1,
    "idAuthor": 1
}
```

#### Listar todos os livros

| URL  | Tipo |  Descrição |
| ---- | ---- |---- |
|/livro | GET | Exibir lista de livros

+ Response 200 (application/json)

#### Buscar livro por ID

| URL  | Tipo |  Descrição |
| ---- | ---- |---- |
|/livro/{id} | GET | Buscar livro

+ Response 200 (application/json)


### País

#### Cadastrar um novo país

| URL  | Tipo |  Descrição |
| ---- | ---- |---- |
|/pais | POST | Cadastro país

+ Response 200 (application/json)

+ Attributes (object)

    + name [ string - required, unique ]

+ Request (application/json)


**Corpo da requisição**:

```json
{
    "name": "Canadá"
}
```


### Estado

#### Cadastrar um novo estado

| URL  | Tipo |  Descrição |
| ---- | ---- |---- |
|/estado | POST | Cadastro estado

+ Response 200 (application/json)

+ Attributes (object)

    + name [ string - required, unique ]
    + idCountry [ Long - required, must exist ]

+ Request (application/json)

**Corpo da requisição**:

```json
{
    "name": "British Columbia",
    "idCountry": 1
}
```


### Cliente

#### Cadastrar um novo cliente

| URL  | Tipo |  Descrição |
| ---- | ---- |---- |
|/cliente | POST | Cadastro cliente

+ Response 200 (application/json)

+ Attributes (object)

  + email [ string - required, unique, valid format ]
  + firstName [ string - required ]
  + lastName [ string - required ]
  + document [ string - required, unique, valid CPF or CNPJ format ]
  + address [ string - required ]
  + complement [ string - required ]
  + city [ string - required ]
  + idCountry [ Long - required, must exist ]
  + idState [ Long - must exist ]
  + phoneNumber [ string - required, only numbers, size (10 - 14) ]
  + zipCode [ string - required, only numbers, size (5 - 14) ]

+ Request (application/json)

**Corpo da requisição**:

```json
{
    "email": "stark@email.com",
    "firstName": "Tony",
    "lastName": "Stark",
    "document": "350.788.050-44",
    "address": "10880 Malibu Point",
    "complement": "Point Dume",
    "city": "Malibu",
    "idCountry": 1,
    "idState": 1,
    "phoneNumber": "2129704133",
    "zipCode": "90265"
}
```