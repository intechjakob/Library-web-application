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

@WebServlet(name = "SearchBookServlet", urlPatterns = {"/SearchBookServlet"})
public class SearchBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the search query and type from request parameters
        String query = request.getParameter("query");
        String searchType = request.getParameter("searchType"); // title or author

        BookService bookService = new BookService(); // Create a new BookService instance to use its search methods
        List<Book> books; // Create a list to store the search results

        // Determine the type of search and use the appropriate BookService method
        if ("title".equalsIgnoreCase(searchType)) { // Case-insensitive comparison
            books = bookService.searchBooksByTitle(query); // Use the searchBooksByTitle method
        } else if ("author".equalsIgnoreCase(searchType)) { // Case-insensitive comparison
            books = bookService.searchBooksByAuthor(query); // Use the searchBooksByAuthor method
        } else {
            // Default to an empty list if no valid search type is provided
            books = List.of();
        }

        // Set the books list as a request attribute and forward to a JSP page for display
        request.setAttribute("books", books);
        request.setAttribute("searchQuery", query);
        request.getRequestDispatcher("/searchResults.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect to the search form if the servlet is accessed via GET
        request.getRequestDispatcher("/searchBooks.jsp").forward(request, response);
    }
}
