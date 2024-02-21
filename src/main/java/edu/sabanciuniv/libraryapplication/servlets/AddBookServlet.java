package edu.sabanciuniv.libraryapplication.servlets;

import edu.sabanciuniv.libraryapplication.entity.Book;
import edu.sabanciuniv.libraryapplication.services.BookService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddBookServlet", urlPatterns = {"/AddBookServlet"}) // URL pattern to access this servlet
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve book details from the request
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String yearStr = request.getParameter("publishYear");
        String genre = request.getParameter("genre");

        int publishYear = 0; // Default value for publish year
        try {
            publishYear = Integer.parseInt(yearStr); // Convert the string to an integer
        } catch (NumberFormatException e) {
            // Handle the case where publish year is not a valid integer
            request.setAttribute("errorMessage", "Invalid publish year"); // Set an error message
            request.getRequestDispatcher("/addBook.jsp").forward(request, response); // Redirect back to the form
            return;
        }

        // Create a new book entity and populate it with the details
        Book book = new Book(title, author, publishYear, genre);

        // Use BookService to add the book to the database
        BookService bookService = new BookService();
        bookService.addBook(book);

        // Redirect to the list of books to see the new book added
        response.sendRedirect("ListBooksServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect POST request to this servlet if accessed via GET
        request.getRequestDispatcher("/addBook.jsp").forward(request, response);
    }
}
