package edu.sabanciuniv.libraryapplication.servlets;

import edu.sabanciuniv.libraryapplication.entity.Book;
import edu.sabanciuniv.libraryapplication.services.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListBooksServlet", urlPatterns = {"/ListBooksServlet"})
public class ListBooksServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Use BookService to get a list of all books
        BookService bookService = new BookService();
        List<Book> books = bookService.listAllBooks();

        // Set the books list as a request attribute
        request.setAttribute("books", books);

        // Forward to listBooks.jsp to display the books
        request.getRequestDispatcher("/listBooks.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // This servlet does not handle POST requests
        // but, we can implement logic here for the sake of completeness
        doGet(request, response);
    }
}
