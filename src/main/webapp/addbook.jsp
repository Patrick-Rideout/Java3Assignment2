<%@ page import="JDBC.BookDatabaseManager" %>
<%@ page import="JDBC.Author" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Book</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="bg-light">

<div class="container text-center">
    <h1 class="text-center"><b>Josh Taylor's Library for Orphans</b></h1>
    <a href="index.jsp" class="nav-link btn btn-primary btn-lg m-2"><b>HOME</b></a>
    <nav class="navbar navbar-expand-sm justify-content-center">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link btn btn-primary btn-lg m-2" href="addbook.jsp">Add Book</a>
            </li>
            <li class="nav-item">
                <a class="nav-link btn btn-primary btn-lg m-2" href="addauthor.jsp">Add Author</a>
            </li>
            <li class="nav-item">
                <form action="library-data" method="get">
                    <input type="hidden" name="viewId" value="book">
                    <td><button class="nav-link btn btn-primary btn-lg m-2" type="submit">View Books</button></td>
                </form>
            </li>
            <li class="nav-item">
                <form action="library-data" method="get">
                    <input type="hidden" name="viewId" value="author">
                    <td><button class="nav-link btn btn-primary btn-lg m-2" type="submit">View Authors</button></td>
                </form>
            </li>
        </ul>
    </nav>
    <br/>
</div>

<div class="container bg-light text-center">
    <h2>Add Author Details:</h2>

    <form action="library-data" method="post">
        <div class="form-group">
            <label for="isbn"><b>ISBN:</b></label>
            <input type="text" class="form-control" id="isbn" name="isbn" required>
        </div>
        <div class="form-group">
            <label for="title"><b>Title:</b></label>
            <input type="text" class="form-control" id="title" name="title" required>
        </div>
        <div class="form-group">
            <label for="editionNumber"><b>Edition Number:</b></label>
            <input type="number" class="form-control" id="editionNumber" name="editionNumber" min="1" step="1" required>
        </div>
        <div class="form-group">
            <label for="copyright"><b>Copyright:</b></label>
            <input type="text" class="form-control" id="copyright" name="copyright" required>
        </div>

        <div class="form-group">
            <label for="authorId"><b>Author:</b></label>
            <select class="form-control" id="authorId" name="authorId" required>
                <option value="">-- Select an Author --</option>
                <%
                    try {
                        BookDatabaseManager db = new BookDatabaseManager();
                        List<Author> listOfAuthors = db.loadAuthors();

                        for (Author author : listOfAuthors) {
                            out.println("<option value='" + author.getAuthorID() + "'>"
                                    + author.getFirstName() + " " + author.getLastName()
                                    + "</option>");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                %>
            </select>
        </div>

        <input type="hidden" id="addId" name="addId" value="book" />
        <input type="submit" value="SUBMIT" class="btn btn-success"/>
    </form>
</div>

<br/>

</body>
</html>


