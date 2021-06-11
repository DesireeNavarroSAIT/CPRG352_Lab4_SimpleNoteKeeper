/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.Note;
import javax.servlet.http.HttpSession;

/**
 *
 * @author m-navarro
 */
public class NoteServlet extends HttpServlet {
    //file path to note.txt

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Empty strings for the contents of the file
        String firstFLine = "";
        String secondFLine = "";

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        //Read the file note.txt
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));

        firstFLine += br.readLine();
        secondFLine += br.readLine();

        //Create an Note object and calls the Note.java
        Note note = new Note(firstFLine, secondFLine);
        request.setAttribute("note", note);

        String editClicked = request.getParameter("edit");

        //Check if the the parameter "edit" is clicked. If clicked it will redirect to editnote.jsp
        if (editClicked != null) {

            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        }
        // close the buffer
        br.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));

        String title = request.getParameter("title");
        String contexts = request.getParameter("contexts");
        
        //prints the notes
        pw.println(title);
        pw.println(contexts);
        //close the printwriter 
        pw.close();
        
        //get or set the new variable to the pre-existing variable in the Note.java to
        //display in the view.jsp
        Note note = new Note(title,contexts);
        request.setAttribute("note", note);
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);


    }
}
