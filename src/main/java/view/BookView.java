package view;

import model.BookModel;
import service.BookService;
import util.DateValidator;

import java.util.Scanner;

public class BookView {
    private final Scanner scanner;
    private final BookService bookService;

    public BookView(Scanner scanner, BookService bookService){
        this.scanner = scanner;
        this.bookService = bookService;
    }

    public String requestBookCode(){
        System.out.print("\nDigite o código do livro: ");
        return scanner.nextLine();
    }

    public String requestReleaseDate(){
        String date;

        do{
            System.out.print("Digite a data de lançamento do livro: ");
            date = scanner.nextLine();

            if(!DateValidator.isValidDate(date)){
                System.out.println("\nDigite uma data válida!");
            }
        }while (!DateValidator.isValidDate(date));

        return date;
    }

    public BookModel requestBookInformation(String bookCode){
        System.out.print("Digite o nome do livro: ");
        String name = scanner.nextLine();

        System.out.print("Digite o nome do autor do livro: ");
        String author = scanner.nextLine();

        String releaseDate = requestReleaseDate();

        return new BookModel(name, author, releaseDate, bookCode);
    }

    public void displaySpecificBookEntry(){
        String bookCode = requestBookCode();
        if(bookService.bookCodeExists(bookCode)){
            bookService.displaySpecificBook(bookCode);
        } else System.out.println("\nNão há livro cadastrado com o código informado!\n");
    }

    public void deleteBookEntry(){
        String bookCode = requestBookCode();
        if(bookService.bookCodeExists(bookCode)){
            bookService.deleteBook(bookCode);
        } else System.out.println("\nNão há livro cadastrado com o código informado!\n");
    }

    public void registerNewBookEntry(){
        String bookCode = requestBookCode();
        if(!bookService.bookCodeExists(bookCode)){
            bookService.registerNewBook(requestBookInformation(bookCode));
        } else System.out.println("\nJá há livro cadastrado com o código informado!\n");
    }

    public void modifyBookEntry(){
        String bookCode = requestBookCode();
        if(bookService.bookCodeExists(bookCode)){
            BookModel book = requestBookInformation(bookCode);
            bookService.modifyBook(book.getBookCode(), book);
        } else System.out.println("\nNão há livro cadastrado com o código informado!\n");
    }
}
