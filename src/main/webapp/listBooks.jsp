<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="edu.sabanciuniv.libraryapplication.entity.Book"%>
<html>
<head>
    <title>List of Books</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="wrapper">
<h1>List of Books</h1>
<table border="1">
    <thead>
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Publish Year</th>
        <th>Genre</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<Book> books = (List<Book>) request.getAttribute("books"); // get the books from the request
        if (books != null && books.size() > 0) { // if there are books
            for (Book book : books) { // iterate over the books
    %>
    <tr>
        <td><%= book.getTitle() %></td>
        <td><%= book.getAuthor() %></td>
        <td><%= book.getPublishYear() %></td>
        <td><%= book.getGenre() %></td>
        <td>
            <a href="DeleteBookServlet?id=<%= book.getId() %>">Delete</a>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="5">No books found</td> <!-- if there are no books -->
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<a href="index.jsp">Back to Home</a> <!-- link to the home page -->
</div>
</body>

</html>
