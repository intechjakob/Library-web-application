<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Books</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="wrapper">
<h1>Search for Books</h1>
<form action="SearchBookServlet" method="post" class="form-group">
    <div>
        <label for="query">Search Query:</label>
        <input type="text" id="query" name="query" required>
    </div>
    <div>
        <label for="searchType">Search By:</label>
        <select id="searchType" name="searchType">
            <option value="title">Title</option> //search by title
            <option value="author">Author</option> //search by author
        </select>
    </div>
    <button type="submit">Search</button>
</form>
<a href="index.jsp">Back to Home</a>
</div>
</body>
</html>


