package org.example;


import org.example.Model.Author;
import org.example.Model.Book;
import org.example.Services.GutendexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Main implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

    @Autowired
    private GutendexService gutendexService;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("1- Buscar libro por título");
            System.out.println("2- Listar libros registrados");
            System.out.println("3- Listar autores registrados");
            System.out.println("4- Listar autores vivos en un determinado año");
            System.out.println("5- Listar libro por idioma");
            System.out.println("6- Salir");
            System.out.print("Selecciona una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String title = scanner.nextLine();
                    List<Book> books = gutendexService.searchBooksByTitle(title);
                    books.forEach(book -> System.out.println(book.getTitle()));
                    break;
                case 2:
                    List<Book> allBooks = gutendexService.getAllBooks();
                    allBooks.forEach(book -> System.out.println(book.getTitle()));
                    break;
                case 3:
                    List<Author> allAuthors = gutendexService.getAllAuthors();
                    allAuthors.forEach(author -> System.out.println(author.getName()));
                    break;
                case 4:
                    System.out.print("Ingrese el año: ");
                    int year = scanner.nextInt();
                    List<Author> authorsByYear = gutendexService.getAuthorsByYear(year);
                    authorsByYear.forEach(author -> System.out.println(author.getName()));
                    break;
                case 5:
                    System.out.print("Ingrese el idioma: ");
                    String language = scanner.nextLine();
                    List<Book> booksByLanguage = gutendexService.getBooksByLanguage(language);
                    booksByLanguage.forEach(book -> System.out.println(book.getTitle()));
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (option != 6);

        scanner.close();
    }
}