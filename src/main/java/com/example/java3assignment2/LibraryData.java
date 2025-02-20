package com.example.java3assignment2;

import JDBC.Author;
import JDBC.Book;
import JDBC.BookDatabaseManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "libraryData", value = "/library-data")
public class LibraryData extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello Worldz!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {



    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        BookDatabaseManager db = new BookDatabaseManager();
//
//        String view = request.getParameter("view");
//
//        if ("books".equals(view)) {
//            List<String> books = db.getBooksWithAuthors();
//            out.println("<h2>Book List</h2>");
//            for (String book : books) {
//                out.println("<p>" + book + "</p>");
//            }
//        } else if ("authors".equals(view)) {
//            List<String> authors = db.getAuthorsWithBooks();
//            out.println("<h2>Author List</h2>");
//            for (String author : authors) {
//                out.println("<p>" + author + "</p>");
//            }
//        }
//
//        out.println("<a href='index.jsp'>Return to Home</a>");
//    }

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