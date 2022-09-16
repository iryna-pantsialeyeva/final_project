package finalproject.part1.view;

import finalproject.part1.service.BookService;
import finalproject.part1.service.ServiceFactory;

import java.util.Scanner;

public class MainMenu {

    private static ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private static BookService bookService = serviceFactory.getBookService();

    public static void main(String[] args) throws InterruptedException {

        MainMenu.start();
    }

    static void start() throws InterruptedException {

        System.err.println("Hello, dear user.");
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);

        while (true) {
            System.err.println("Please select an action: \n 1) Add book \n 2) Show book \n " +
                    "3) Delete book \n 4) Exit");
            System.err.print("Insert number here: ");

            int choice = scInt.nextInt();
            switch (choice) {
                case 1:
                    System.err.print("Please insert the name of the book: ");
                    String name = scStr.nextLine();
                    System.err.print("Please insert isbn: ");
                    String isbn = scStr.nextLine();
                    System.err.print("Please insert the author of the book: ");
                    String author = scStr.nextLine();
                    System.err.print("Please insert the genre of the book: ");
                    String genre = scStr.nextLine();
                    bookService.addBook(name, isbn, author, genre);
                    System.out.println("Book was added. \n");
                    Thread.sleep(500);
                    break;
                case 2:
                    System.err.print("Please insert id of the book that you would like to read: ");
                    Long id = scInt.nextLong();
                    System.out.println(bookService.getBookById(id) + "\n");
                    Thread.sleep(500);
                    break;
                case 3:
                    System.err.print("Please insert id of the book that you would like to delete: ");
                    Long idBook = scInt.nextLong();
                    bookService.deleteBook(idBook);
                    System.out.println("Book was deleted. \n");
                    Thread.sleep(500);
                    break;
                case 4:
                    System.out.println("Good bye.");
                    scInt.close();
                    scStr.close();
                    return;
                default:
                    System.out.println("Chosen option can not be performed. Please insert number within 1-4. \n");
            }
        }
    }
}
