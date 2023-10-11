import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Livro> listaLv = new ArrayList<>();

        System.out.println("Olá seja bem-vindo, cadastre seu livro");

        Scanner leitor = new Scanner(System.in);

        String opcao;

        do {
            System.out.println("Digite uma opção: 1-Cadastrar livro / 2-Listar livro / 0-Voltar");
            opcao = leitor.nextLine();

            switch (opcao) {
                case "1":
                    Livro novoLivro = new Livro();
                    novoLivro.autor = new Autor();

                    System.out.println("Digite o titulo do livro: ");
                    novoLivro.titulo = leitor.nextLine();

                    System.out.println("Digite o autor: ");
                    novoLivro.autor.nome = leitor.nextLine();

                    System.out.println("Digite o preço: ");
                    novoLivro.preco = leitor.nextFloat();

                    System.out.println("Digite a data de lançamento do livro: (dd/mm/aaaa) ");
                    novoLivro.dataLancamento = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    Period lacamento = Period.between(novoLivro.dataLancamento, LocalDate.now());

                    if (lacamento.getYears() >= 5) {
                        System.out.println("Data de lançamento válida!");
                    }else {
                        System.out.println("Data de lançamento inválida");
                        break;
                    }

                    System.out.println("Digite o nome do Autor: ");
                    novoLivro.autor.nome = leitor.nextLine();

                    System.out.println("Digite o local de nacimento do Autor: ");
                    novoLivro.autor.localNac = leitor.next();

                    listaLv.add(novoLivro);

                    break;

                case "2":
                    System.out.println("2");
                    break;

                case "0":
                    System.out.println("Volta");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (!opcao.equals("0"));
    }
}