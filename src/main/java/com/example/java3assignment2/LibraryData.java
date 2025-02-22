package com.example.java3assignment2;

import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;

import JDBC.Author;
import JDBC.Book;
import JDBC.BookDatabaseManager;
import JDBC.Library;

@WebServlet(name = "libraryData", value = "/library-data")
public class LibraryData extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String viewId = request.getParameter("viewId");
        PrintWriter out = response.getWriter();

        BookDatabaseManager db = new BookDatabaseManager();

        List<Book> listOfBooks = new ArrayList<>();
        List<Author> listOfAuthors = new ArrayList<>();
        Map<Integer, List<String>> isbnMap = null;

        listOfBooks = db.loadBooks();
        listOfAuthors = db.loadAuthors();
        isbnMap = db.loadISBN();

        Library library = new Library(listOfBooks, listOfAuthors, isbnMap);

        printHeader(out);

        if ("book".equals(viewId)) {
            out.println("<div class='container'><h2>Books:</h2>");
            out.println("<table class='table table-striped'>");
            out.println("<thead><tr><th>ISBN</th><th>Title</th><th>Edition</th><th>Copyright</th><th>Author/s</th></tr></thead>");
            out.println("<tbody>");
            for (Book book : listOfBooks) {
                StringBuilder authorNames = new StringBuilder();
                for (Author author : book.getAuthorList()) {
                    if (authorNames.length() > 0) {
                        authorNames.append(", ");
                    }
                    authorNames.append(author.getFirstName() + " " + author.getLastName());
                }
                out.println("<tr><td>" + book.getIsbn() + "</td><td>" + book.getTitle() + "</td><td>" + book.getEditionNumber() + "</td><td>" + book.getCopyright() + "</td><td>" + authorNames + "</td></tr>");
            }
            out.println("</tbody>");
            out.println("</table>");
            out.println("</div>");
        } else if ("author".equals(viewId)) {
            out.println("<div class='container'><h2>Authors:</h2>");
            out.println("<table class='table table-striped'>");
            out.println("<thead><tr><th>Author ID</th><th>First Name</th><th>Last Name</th><th>Books</th></tr></thead>");
            out.println("<tbody>");

            for (Author author : listOfAuthors) {
                StringBuilder bookTitles = new StringBuilder();
                for (Book book : author.getBookList()) {
                    if (bookTitles.length() > 0) {
                        bookTitles.append(", ");
                    }
                    bookTitles.append(book.getTitle());
                    }
                out.println("<tr><td>" + author.getAuthorID() + "</td><td>" + author.getFirstName() + "</td><td>" + author.getLastName() + "</td><td>" + bookTitles + "</td></tr>");
            }
            out.println("</tbody>");
            out.println("</table>");
            out.println("</div>");
        }
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        BookDatabaseManager db = new BookDatabaseManager();

        String addId=request.getParameter("addId");

        if ("author".equals(addId)) {
            String firstName=request.getParameter("firstName");
            String lastName=request.getParameter("lastName");

            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);

            try {
                db.addAuthor(firstName, lastName);
                printHeader(out);
                out.println("<h2 class='text-center'>Author added successfully!</h2>");
            } catch (Exception e) {
                e.printStackTrace();
                out.println("<h2 class='text-center'>Error adding Author</h2>");
                out.println("</body>");
                out.println("</html>");
            }


        } else if ("book".equals(addId)) {
            String isbn = request.getParameter("isbn");
            String title = request.getParameter("title");
            int editionNumber = Integer.parseInt(request.getParameter("editionNumber"));
            String copyright = request.getParameter("copyright");
            String authorListNumber = request.getParameter("authorId");

            List<Integer> authorList = new ArrayList<>();

            System.out.println("ISBN: " + isbn);
            System.out.println("Title: " + title);
            System.out.println("Edition Number: " + editionNumber);
            System.out.println("Copyright: " + copyright);
            System.out.println("Author List: " + authorListNumber);

            authorList.add(Integer.valueOf(authorListNumber));

            try {
                db.addBook(isbn, title, editionNumber, copyright, authorList);
                printHeader(out);
                out.println("<h2 class='text-center'>Book added successfully!</h2>");
            } catch (Exception e) {
                e.printStackTrace();
                printHeader(out);
                out.println("<h2 class='text-center'>Error adding book</h2>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    public void printHeader(PrintWriter out) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("    <title>HOME</title>");
        out.println("    <meta charset='utf-8'>");
        out.println("    <meta name='viewport' content='width=device-width, initial-scale=1'>");
        out.println("    <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css'>");
        out.println("    <script src='https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js'></script>");
        out.println("    <script src='https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js'></script>");
        out.println("    <script src='https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js'></script>");
        out.println("</head>");
        out.println("<body class='bg-light'>");
        out.println("<div class='container text-center'>");
        out.println("    <h1 class='text-center'><b>Josh Taylor's Library for Orphans</b></h1>");
        out.println("    <a href='index.jsp' class='nav-link btn btn-primary btn-lg m-2'><b>HOME</b></a>");
        out.println("    <nav class='navbar navbar-expand-sm justify-content-center'>");
        out.println("        <ul class='navbar-nav'>");
        out.println("            <li class='nav-item'><a class='nav-link btn btn-primary btn-lg m-2' href='addbook.jsp'>Add Book</a></li>");
        out.println("            <li class='nav-item'><a class='nav-link btn btn-primary btn-lg m-2' href='addauthor.jsp'>Add Author</a></li>");
        out.println("            <li class='nav-item'><form action='library-data' method='get'><input type='hidden' name='viewId' value='book'><button class='nav-link btn btn-primary btn-lg m-2' type='submit'>View Books</button></form></li>");
        out.println("            <li class='nav-item'><form action='library-data' method='get'><input type='hidden' name='viewId' value='author'><button class='nav-link btn btn-primary btn-lg m-2' type='submit'>View Authors</button></form></li>");
        out.println("        </ul>");
        out.println("    </nav>");
        out.println("    <br/>");
        out.println("</div>");
    }
}