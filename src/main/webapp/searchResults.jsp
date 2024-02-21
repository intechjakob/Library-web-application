<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.sabanciuniv.libraryapplication.entity.Book" %>
<html>
<head>
    <title>Search Results</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="wrapper">
<h1>Search Results</h1>
<%
    // Retrieve search query and results from request attributes
    String searchQuery = (String) request.getAttribute("searchQuery"); // Retrieve search query from request attribute
    List<Book> books = (List<Book>) request.getAttribute("books"); // Retrieve search results from request attribute

    if (books != null && !books.isEmpty()) { // If search results are not empty
%>
<p>Showing results for: "<%= searchQuery %>"</p> <!-- Display search query -->
<table border="1">
    <thead>
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Publish Year</th>
        <th>Genre</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (Book book : books) {
    %>
    <tr>
        <td><%= book.getTitle() %></td>
        <td><%= book.getAuthor() %></td>
        <td><%= book.getPublishYear() %></td>
        <td><%= book.getGenre() %></td>
        <td><a href="DeleteBookServlet?id=<%= book.getId() %>">Delete</a></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<%
} else {
%>
<p>No results found for: "<%= searchQuery %>"</p>
<%
    }
%>
<a href="index.jsp">Back to Home</a>
</div>
</body>
</html>
