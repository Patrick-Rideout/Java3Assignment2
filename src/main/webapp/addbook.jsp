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
<body>

<div class="container bg-light text-center">
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
                <a class="nav-link btn btn-primary btn-lg m-2" href="#">View Books</a>
            </li>
            <li class="nav-item">
                <a class="nav-link btn btn-primary btn-lg m-2" href="#">View Authors</a>
            </li>
        </ul>
    </nav>
    <br/>
</div>

<div class="container bg-light text-center">
    <h2>Add Author Details:</h2>

    <form action="" method="post">
        <div class="form-group">
            <label for="isbn"><b>ISBN:</b></label>
            <input type="text" class="form-control" id="isbn">
        </div>
        <div class="form-group">
            <label for="title"><b>Title:</b></label>
            <input type="text" class="form-control" id="title">
        </div>
        <div class="form-group">
            <label for="editionNumber"><b>Edition Number:</b></label>
            <input type="text" class="form-control" id="editionNumber">
        </div>
        <div class="form-group">
            <label for="copyright"><b>Copyright:</b></label>
            <input type="text" class="form-control" id="copyright">
        </div>

        <input type="submit" value="SUBMIT"/>

    </form>


</div>




<a href="hello-servlet" class="btn btn-success btn-lg btn-block">Hello Servlet</a>
<br/>

</body>
</html>
