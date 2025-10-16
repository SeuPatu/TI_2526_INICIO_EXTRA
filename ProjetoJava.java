import java.util.Scanner;

public class ProjetoJava {
    private static final int MAX_LIVROS = 5;

    static class Livro {
        String titulo;
        int ano;

        Livro(String titulo, int ano) {
            this.titulo = titulo;
            this.ano = ano;
        }
    }

    // Adiciona um livro e retorna a nova quantidade
    private static int adicionarLivro(Livro[] livros, int quantidade, Scanner sc) {
        if (quantidade >= MAX_LIVROS) {
            System.out.println("Catálogo cheio. Não é possível adicionar mais livros.");
            return quantidade;
        }

        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Ano: ");
        while (!sc.hasNextInt()) {
            System.out.println("Entrada inválida. Digite um número para o ano.");
            sc.next();
        }
        int ano = sc.nextInt();
        sc.nextLine(); // consome o fim de linha

        livros[quantidade] = new Livro(titulo, ano);
        quantidade++;
        System.out.println("Livro adicionado com sucesso!");
        return quantidade;
    }

    private static void listarLivros(Livro[] livros, int quantidade) {
        if (quantidade == 0) {
            System.out.println("Nenhum livro no catálogo.");
            return;
        }

        for (int i = 0; i < quantidade; i++) {
            System.out.printf("%d - %s (%d)%n", i + 1, livros[i].titulo, livros[i].ano);
        }
    }

    private static void procurarLivro(Livro[] livros, int quantidade, Scanner sc) {
        if (quantidade == 0) {
            System.out.println("Catálogo vazio. Não há livros para procurar.");
            return;
        }

        System.out.print("Introduza o título a procurar: ");
        String tituloProcurado = sc.nextLine();

        boolean encontrado = false;
        for (int i = 0; i < quantidade; i++) {
            if (livros[i].titulo.equalsIgnoreCase(tituloProcurado)) {
                System.out.printf("Encontrado: %s (%d)%n", livros[i].titulo, livros[i].ano);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Livro não encontrado.");
        }
    }

    // Limpa o ecrã de forma simples. Tenta usar o comando do SO, caso contrário imprime várias linhas.
    private static void clearScreen() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // fallback: imprime várias linhas para simular limpeza
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }

    // Tela separada para adicionar livros. Permite voltar ao menu principal sem perder dados.
    private static int screenAdicionar(Livro[] livros, int quantidade, Scanner sc) {
        // Tela simples: ao entrar, limpa e adiciona um livro, depois volta ao menu principal
        clearScreen();
        System.out.println("=== ADICIONAR LIVRO ===");
        if (quantidade >= MAX_LIVROS) {
            System.out.println("Catálogo cheio. Não é possível adicionar mais livros.");
            System.out.println("Pressione Enter para voltar ao menu principal...");
            sc.nextLine();
            clearScreen();
            return quantidade;
        }

        quantidade = adicionarLivro(livros, quantidade, sc);
        System.out.println();
        System.out.println("Pressione Enter para voltar ao menu principal...");
        sc.nextLine();
        clearScreen();
        return quantidade;
    }

    // Tela separada para listar livros. Mostra a lista e permite voltar.
    private static void screenListar(Livro[] livros, int quantidade, Scanner sc) {
        clearScreen();
        System.out.println("=== LISTAR LIVROS ===");
        listarLivros(livros, quantidade);
        System.out.println();
        System.out.println("Pressione Enter para voltar ao menu principal...");
        sc.nextLine();
        clearScreen();
    }

    // Tela separada para procurar livros. Permite procurar várias vezes e depois voltar.
    private static void screenProcurar(Livro[] livros, int quantidade, Scanner sc) {
        clearScreen();
        System.out.println("=== PROCURAR LIVRO ===");
        procurarLivro(livros, quantidade, sc);
        System.out.println();
        System.out.println("Pressione Enter para voltar ao menu principal...");
        sc.nextLine();
        clearScreen();
    }

    public static void main(String[] args) {
        Livro[] livros = new Livro[MAX_LIVROS];
        int quantidade = 0;
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        do {
            // mostra o menu a cada iteração (aparece novamente ao voltar das abas)
            System.out.println();
            System.out.println("=== MENU ===");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Procurar Livro");
            System.out.println("4. Sair");
            System.out.print("Escolha: ");

            while (!sc.hasNextInt()) {
                System.out.println("Opção inválida. Tente novamente.");
                sc.next();
                System.out.print("Escolha: ");
            }
            opcao = sc.nextInt();
            sc.nextLine(); // consome o fim de linha

            switch (opcao) {
                case 1:
                    quantidade = screenAdicionar(livros, quantidade, sc);
                    break;
                case 2:
                    screenListar(livros, quantidade, sc);
                    break;
                case 3:
                    screenProcurar(livros, quantidade, sc);
                    break;
                case 4:
                    System.out.println("A sair...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            // se ainda não saiu, adiciona uma linha em branco para separar e volta a pedir a escolha
            if (opcao != 4) {
                System.out.println();
            }

        } while (opcao != 4);

        sc.close();
    }
}
