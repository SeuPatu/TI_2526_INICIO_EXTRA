# Tecnologias Informáticas - exercício extra

Faz *fork* deste repositório.  Cria um programa tal como descrito na secção seguinte. No fim, substitui o conteúdo do README por uma descrição do funcionamento do teu programa.

## Gestão Simples de Livros

### Descrição

Escreve um programa em C++ que permita gerir um pequeno catálogo de livros.

1. Cria uma estrutura **Livro** com:

   * titulo (string)

   * ano (int)

2. O programa deve permitir:

   * Adicionar até 5 livros (usar array fixo).

   * Listar todos os livros inseridos.

   * Procurar livro pelo título (mostrar ano se encontrado, ou “não encontrado”).

   * Sair.

3. O programa deve:

   * Ter um menu em ciclo até o utilizador escolher sair.

   * Usar funções para cada operação (ex.: adicionarLivro, listarLivros, procurarLivro).

   * Usar decisões (**if** ou **switch**) para as opções do menu.

### Exemplo de funcionamento

    === MENU ===
    1. Adicionar Livro
    2. Listar Livros
    3. Procurar Livro
    4. Sair
    Escolha: 1
    Título: O Principezinho
    Ano: 1943

    Escolha: 2
    1 - O Principezinho (1943)

    Escolha: 3
    Introduza o título a procurar: O Principezinho
    Encontrado: O Principezinho (1943)

    Escolha: 4
    A sair...
