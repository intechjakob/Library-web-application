<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Book</title>
    <link rel="stylesheet" href="style.css">

</head>
<body>
<div class="wrapper">
<h1>Add New Book</h1>
<form action="AddBookServlet" method="post" class="form-group">
    <div>
        <label for="title">Book Title:</label>
        <input type="text" id="title" name="title" required>
    </div>
    <div>
        <label for="author">Author:</label>
        <input type="text" id="author" name="author" required>
    </div>
    <div>
        <label for="publishYear">Publish Year:</label>
        <input type="number" id="publishYear" name="publishYear" required>
    </div>
    <div>
        <label for="genre">Genre:</label>
        <input type="text" id="genre" name="genre" required>
    </div>
    <button type="submit" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">Add Book</button>
</form>
<a href="index.jsp">Back to Home</a>
</div>
</body>
</html>
