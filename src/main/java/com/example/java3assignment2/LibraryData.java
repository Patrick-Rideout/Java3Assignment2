package com.example.java3assignment2;

import JDBC.Author;
import JDBC.Book;
import JDBC.BookDatabaseManager;
import JDBC.Library;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "libraryData", value = "/library-data")
public class LibraryData extends HttpServlet {

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

        if ("book".equals(viewId)) {
            out.println("<div class='container'><h2>Books:</h2><ul class='list-group'>");
            for (Book book : listOfBooks) {
                out.println("<li class='list-group-item'>" + book.getTitle() + "</li>");
            }
            out.println("</ul></div>");
        } else if ("author".equals(viewId)) {
            out.println("<div class='container'><h2>Authors:</h2>");
            out.println("<table class='table table-striped'>");
            out.println("<thead><tr><th>Author ID</th><th>First Name</th><th>Last Name</th><th>Books</th></tr></thead>");
            out.println("<tbody>");

            for (Author author : listOfAuthors) {
                StringBuilder bookTitles = new StringBuilder();
                List<Book> books = author.getBookList();
                if (books != null) {
                    for (Book book : books) {
                        if (bookTitles.length() > 0) {
                            bookTitles.append(", ");
                        }
                        bookTitles.append(book.getTitle());
                    }
                } else {
                    bookTitles.append("No books available");
                }

                out.println("<tr><td>" + author.getAuthorID() + "</td><td>" + author.getFirstName() + "</td><td>" + author.getLastName() + "</td><td>" + bookTitles.toString() + "</td></tr>");
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
        PrintWriter pwriter = response.getWriter();

        BookDatabaseManager db = new BookDatabaseManager();

        List<Book> listOfBooks = db.loadBooks();
        List<Author> listOfAuthors = db.loadAuthors();
        Map<Integer, List<String>> isbnMap = db.loadISBN();

        String addId=request.getParameter("addId");

        if ("author".equals(addId)) {
            String firstName=request.getParameter("firstName");
            String lastName=request.getParameter("lastName");

            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);

            try {
                db.addAuthor(firstName, lastName);
                pwriter.println("<h2>Author added successfully!</h2>");
            } catch (Exception e) {
                e.printStackTrace();
            }


        } else if ("book".equals(addId)) {
            String isbn = request.getParameter("isbn");
            String title = request.getParameter("title");
            Integer editionNumber = Integer.valueOf(request.getParameter("editionNumber"));
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
                pwriter.println("<h2>Book added successfully!</h2>");
            } catch (Exception e) {
                e.printStackTrace();
                pwriter.println("<h2>Error adding book!</h2>");
            }
        }

    }

    public void destroy() {
    }
}