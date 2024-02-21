package edu.sabanciuniv.libraryapplication.servlets;

import edu.sabanciuniv.libraryapplication.services.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteBookServlet", urlPatterns = {"/DeleteBookServlet"})
public class DeleteBookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the book ID from the request parameter
        String idStr = request.getParameter("id");
        if (idStr != null && !idStr.isEmpty()) { // If the ID is not empty
            int id = Integer.parseInt(idStr); // Convert the ID to an integer

            // Use BookService to delete the book by ID
            BookService bookService = new BookService();
            bookService.deleteBook(id);
        }

        // Redirect back to the list of books
        response.sendRedirect("ListBooksServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response); // Call the doGet method
    }
}
