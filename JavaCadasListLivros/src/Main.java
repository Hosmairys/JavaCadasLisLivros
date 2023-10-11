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
                    } else {
                        System.out.println("Data de lançamento inválida");
                        break;
                    }

                    leitor.nextLine();

                    System.out.println("Digite o nome do Autor: ");
                    novoLivro.autor.nome = leitor.nextLine();

                    System.out.println("Digite o local de nacimento do Autor: ");
                    novoLivro.autor.localNac = leitor.next();

                    listaLv.add(novoLivro);

                    break;

                case "2":
                    if (listaLv.size() > 0) {

                        for (Livro cadaLv : listaLv){
                            System.out.println("Titulo: " + cadaLv.titulo);
                            System.out.println("Autor: " + cadaLv.autor.nome);
                            System.out.println("Preço: " + cadaLv.preco);
                            System.out.println("Data de lançamento: " + cadaLv.dataLancamento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                            System.out.println("Local de Nacimento: " + cadaLv.autor.localNac);


                            System.out.println();
                            System.out.println("Aperte ENTER para continuar");
                            leitor.nextLine();
                        }

                    } else {
                        System.out.println("Lista vazia!");
                    }
                    break;

                case "0":
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    break;
            }

        } while (!opcao.equals("0"));
    }
}