<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>HOME</title>
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
    <h2>Head Librarian:</h2>
    <img src="images/JoshTaylor.png" alt="Librarian" class="img-fluid rounded border border-dark" width="300" height="300">
    <h3>Josh Taylor</h3>
</div>
<br/>
<hr>

<div class="container bg-light p-4">
    <h2 class="text-center">Early Life:</h2>
    <br>
    <div class="row align-items-center">
        <div class="col-md-4 text-center">
            <img src="images/PeasantJosh.jpg" alt="Peasant" class="img-fluid rounded border border-dark">
            <h5 class="mt-2">Conche 1964: A young Josh Taylor begs for food from bypassing strangers.</h5>
        </div>
        <div class="col-md-8">
            <p class="fs-5">Nulla facilisi. Vivamus risus mi, cursus et felis ac, interdum dictum lorem. Etiam vulputate ante eget hendrerit pellentesque. Aliquam et blandit sem, vitae rhoncus risus. In nunc felis, pulvinar id lobortis vitae, finibus id nunc. Quisque posuere lacinia nisi. Morbi faucibus, nulla a vestibulum sagittis, turpis leo tincidunt felis, sit amet maximus lacus est et eros. Praesent sed leo magna. Donec et tempus mi, congue interdum lectus. Nunc felis nunc, semper ac nisi ac, tincidunt tristique dui. Ut feugiat at sapien eu consectetur. Phasellus rutrum a nisi sit amet suscipit. Suspendisse vel arcu suscipit, gravida risus sit amet, pellentesque arcu. Suspendisse lectus enim, lacinia vitae hendrerit eget, congue ac lorem. Interdum et malesuada fames ac ante ipsum primis in faucibus. Etiam gravida sodales massa, id facilisis ligula lobortis vel. Suspendisse nibh est, euismod id mauris ac, imperdiet suscipit elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Pellentesque nec orci sit amet neque pulvinar volutpat nec vitae sem. Nullam interdum sit amet velit quis elementum. Integer sagittis semper mi volutpat sodales.</p>
        </div>
    </div>
</div>
<br>

<div class="container bg-light p-4">
    <h2 class="text-center">Present Day:</h2>
    <br>
    <div class="row align-items-center">
        <div class="col-md-8">
            <p class="fs-5">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus congue sollicitudin vestibulum. Donec sem massa, bibendum eu fermentum id, condimentum non felis. Nullam cursus ipsum nec magna bibendum volutpat eget sed augue. Proin auctor ultricies ex nec dignissim. Etiam tincidunt cursus tortor, quis luctus enim sagittis in. Nulla eget pulvinar nulla. Integer suscipit augue ut lorem ultrices tristique. Praesent metus ex, dapibus et urna et, ultrices faucibus lectus. Nunc dapibus, quam sit amet mattis pulvinar, eros purus consequat felis, eu hendrerit leo augue vel massa. Sed sagittis nulla eu lacinia feugiat. Nam faucibus dui vitae velit tempor, facilisis pulvinar neque dictum. Proin sit amet pharetra dui, id dictum elit. Vestibulum ultricies sagittis diam, eget sagittis metus bibendum a. Fusce imperdiet, ipsum nec vestibulum vestibulum, elit nunc tempor purus, eget blandit tellus felis et nunc. Aliquam porta lorem velit. Aenean sollicitudin dui sapien. Aliquam sed fermentum mi. In malesuada tempor tempus. Fusce pulvinar sapien et purus auctor molestie. Suspendisse at tristique augue.</p>
        </div>
        <div class="col-md-4 text-center">
            <img src="images/FishermanJosh.jpg" alt="Fisherman" class="img-fluid rounded border border-dark">
            <h5 class="mt-2">St. John's 2024: Josh Taylor sporting his favorite fishing gear.</h5>
        </div>
    </div>
</div>
<br/>
</body>
</html>
