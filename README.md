# Sistema de Biblioteca em Java

Projeto base para a **segunda etapa** do trabalho de Estrutura de Dados.

## Alunos
- Jonas Guilhermino Nascimento
- Gabriel Oliveira Ramos

## Pacotes
- `br.edu.biblioteca.action`
- `br.edu.biblioteca.repository`
- `br.edu.biblioteca.ui`

## Estruturas implementadas
- `Lista - armazenar usuários e livros em memória;`
- `Fila - controle de reservas;`
- `Pilha - histórico de operações`
- `Árvore - organização para busca eficiente (ex: árvore binária por título);`
- `Algoritmos de ordenação - ordenar livros por título, autor ou ano`

## Funcionalidades implementadas
- Cadastro de livros (ISBN, título, autor, editora, ano, categoria);
- Cadastro de usuários (alunos, professores, bibliotecários);
- Controle de empréstimos e devoluções;
- Reserva de livros;
- Controle de multas por atraso;
- Consulta e busca no acervo;
- Relatórios (livros mais emprestados, usuários inadimplentes etc.);

## Como compilar
```bash
javac -d bin $(find src -name "*.java")
```

## Como executar
```bash
java -cp bin br.edu.biblioteca.ui.MenuPrincipal
```

## Observação
Esta entrega está focada na **segunda etapa**
