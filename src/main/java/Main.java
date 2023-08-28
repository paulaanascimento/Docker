import service.BookService;
import view.BookView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookService bookService = new BookService();
        BookView bookView = new BookView(scanner, bookService);

        while (true) {
            System.out.println("--------------- MENU ---------------\n" +
                    "\t1. Exibir todos os livros\n" +
                    "\t2. Exibir um livro específico\n" +
                    "\t3. Cadastrar um novo livro\n" +
                    "\t4. Alterar um livro\n" +
                    "\t5. Deletar um livro\n" +
                    "\t6. Encerrar o programa");
            System.out.print("Digite o número correspondente a opção desejada: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    bookService.displayAllBooks();
                    break;
                case "2":
                    bookView.displaySpecificBookEntry();
                    break;
                case "3":
                    bookView.registerNewBookEntry();
                    break;
                case "4":
                    bookView.modifyBookEntry();
                    break;
                case "5":
                    bookView.deleteBookEntry();
                    break;
                case "6":
                    System.out.println("\nEncerrando aplicação...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nOpção inválida! Tente novamente!\n");
                    break;
            }
        }
    }
}
