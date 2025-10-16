# ProjetoJava

Aplicação de console em Java para gerenciar um catálogo simples de livros.

Descrição

Este projeto contém um programa Java (`ProjetoJava.java`) que permite ao usuário:

- Adicionar livros (título e ano) até um máximo de 5 livros.
- Listar os livros adicionados.
- Procurar um livro pelo título (busca case-insensitive).

A interface é baseada em "abas"/telas de terminal: um menu principal e telas separadas para "Adicionar", "Listar" e "Procurar". As telas limpam a saída ao entrar/voltar e mantêm os dados em memória.

Como compilar e executar

No Windows (PowerShell):

1. Compile:

```powershell
javac "c:\Users\BOLSONARO ANAO\Desktop\java\trabalho ti\ProjetoJava.java"
```

2. Execute (a partir da mesma pasta onde está o .class):

```powershell
Set-Location -Path "c:\Users\BOLSONARO ANAO\Desktop\java\trabalho ti"
java ProjetoJava
```

Ou, a partir de qualquer pasta especificando o classpath:

```powershell
java -cp "c:\Users\BOLSONARO ANAO\Desktop\java\trabalho ti" ProjetoJava
```

Uso esperado

- O menu principal é mostrado, com as opções:
  1. Adicionar Livro
  2. Listar Livros
  3. Procurar Livro
  4. Sair

- Ao escolher uma opção, é aberta uma tela dedicada para aquela ação. Ao terminar, pressione Enter para voltar ao menu.

Limitações e melhorias sugeridas

- O catálogo é mantido apenas em memória (não há persistência entre execuções).
- Sugestões de melhorias:
  - Persistência em arquivo (CSV/JSON).
  - Remover/editar entradas.
  - Aumentar limite de livros ou permitir tamanho dinâmico.

Licença

Este projeto é um exercício educacional. Sinta-se à vontade para copiar, modificar e usar.

---

(README gerado automaticamente. Se quiser, eu posso: 1) inicializar um repositório Git nesta pasta e criar um commit com este README; 2) adicionar um remote e enviar (push) para um repositório GitHub — precisarei da URL do repositório remoto ou você pode configurar o remote localmente.)
