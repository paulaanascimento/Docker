package service;

import model.BookModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static connection.Connection.connect;

public class BookService {
    private Statement statement;

    public BookService() {
        try {
            statement = connect().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void displayBooks(String sql) throws SQLException {
        ResultSet resultSet = statement.executeQuery(sql);
        if (!resultSet.next()) {
            System.out.println("\nNenhum livro foi cadastrado!\n");
        } else {
            do {
                System.out.println("\nNome: " + resultSet.getString("name") +
                        "\nAutor: " + resultSet.getString("author") +
                        "\nData de lançamento: " + resultSet.getString("release_date") +
                        "\nCódigo do livro: " + resultSet.getString("book_code") + "\n");
            } while (resultSet.next());
        }
    }

    public void displayAllBooks() {
        try {
            displayBooks("SELECT * FROM books");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displaySpecificBook(String bookCode) {
        try {
            displayBooks("SELECT * FROM books WHERE book_code = '" + bookCode + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void registerNewBook(BookModel bookModel) {
        String sql = "INSERT INTO books (name, author, release_date, book_code) VALUES ('" + bookModel.getName() + "', '"
                + bookModel.getAuthor() + "', '" + bookModel.getReleaseDate() + "', '" + bookModel.getBookCode() + "')";
        try {
            statement.executeUpdate(sql);
            System.out.println("\nLivro cadastrado com sucesso!\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifyBook(String bookCode, BookModel modifiedBook) {
        String sql = "UPDATE books SET name = '" + modifiedBook.getName() + "', author = '"
                + modifiedBook.getAuthor() + "', release_date = '" + modifiedBook.getReleaseDate()
                + "' WHERE book_code = '" + bookCode + "'";
        try {
            statement.executeUpdate(sql);
            System.out.println("\nLivro alterado com sucesso!\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(String bookCode) {
        String sql = "DELETE FROM books WHERE book_code = '" + bookCode + "'";
        try {
            statement.executeUpdate(sql);
            System.out.println("\nLivro deletado com sucesso!\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean bookCodeExists(String bookCode) {
        String sql = "SELECT * FROM books WHERE book_code = '" + bookCode + "'";
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            return resultSet != null && resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
