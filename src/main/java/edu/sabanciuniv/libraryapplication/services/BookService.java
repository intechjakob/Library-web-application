package edu.sabanciuniv.libraryapplication.services;

import edu.sabanciuniv.libraryapplication.entity.Book;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryPU");

    public void addBook(Book book) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        em.close();
    }

    public List<Book> listAllBooks() { // List all books in the database
        EntityManager em = emf.createEntityManager();
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b", Book.class); // JPQL
        List<Book> books = query.getResultList(); // Execute the query
        em.close();
        return books;
    }

    public void deleteBook(int bookId) { // Delete a book from the database
        EntityManager em = emf.createEntityManager(); // Create an EntityManager object for the database operations
        Book book = em.find(Book.class, bookId); // Find the book with the given ID
        if (book != null) { // If the book is found
            em.getTransaction().begin(); // Start a transaction
            em.remove(book); // Remove the book from the database
            em.getTransaction().commit(); // Commit the transaction
        }
        em.close(); // Close the EntityManager object
    }

    public List<Book> searchBooksByTitle(String title) { // Search books by title
        EntityManager em = emf.createEntityManager(); // Create an EntityManager object for the database operations
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.title LIKE :title", Book.class);
        query.setParameter("title", "%" + title + "%"); // Set the parameter value for the query
        List<Book> books = query.getResultList();
        em.close();
        return books;
    }

    public List<Book> searchBooksByAuthor(String author) { // Search books by author
        EntityManager em = emf.createEntityManager();
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.author LIKE :author", Book.class);
        query.setParameter("author", "%" + author + "%"); // Set the parameter value for the query
        List<Book> books = query.getResultList();
        em.close();
        return books;
    }
}
