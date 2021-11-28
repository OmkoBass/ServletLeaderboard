/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.serverleaderboard;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Omer
 */
@WebServlet(name = "ServeContestants", urlPatterns = {"/ServeContestants"})
public class ServeContestants extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    // Names that will be generated
    private static String[] names = {
            "Jack",
            "Baron",
            "Aimee",
            "Duke",
            "Chad",
            "Tatiana",
            "Lesley",
            "Freedom",
            "Liberty",
            "Barney",
            "Deimos",
            "Achilles",
            "Marcus",
            "Plato",
            "Pythagoras",
            "Lucifer"
    };
    Random random = new Random();

    protected void processPostRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try(PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<title>Contestants Post</title>");  
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">");
            out.println("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>");
            out.println("<link href=\"https://fonts.googleapis.com/css2?family=Roboto&display=swap\" rel=\"stylesheet\">");
            
            out.println("<style>");
            out.println("* { padding: 0; margin: 0; font-family: 'Roboto', sans-serif; } body { background-color: #CED4DA; }");
            out.println("</style");
            
            out.println("</head>");
          
            out.println("<body style=\"height: 100vh; display: grid; place-items: center; background-color: #CED4DA; color: #101113\">");
            
            out.println("<h1> Contestant: " + request.getParameter("contestant") + "</h1>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String contestants = "";
            
            for(int i = 0; i < 9; i++) {
                int randInt = random.nextInt(names.length);
                int score = random.nextInt(100);
                
                String scoreStyle = "style=\"";
                if("Lucifer".equals(names[randInt])) {
                    score = 666;
                }
                
                // Changes the color of the points based
                // on how good they are
                if(score == 666) {
                    scoreStyle += "color:#F03E3E;";
                }
                else if(score > 80) {
                    scoreStyle += "color:#40C057;";
                }
                else if(score >= 61 && score < 81) {
                    scoreStyle += "color:#FCC419;";
                }
                else if(score <= 60) {
                    scoreStyle += "color:#FD7E14;";
                }
                
                scoreStyle += "\"";
                
                // Generates the style for a single contestant
                String listItemStyle = "style=\"margin: 1em; "
                        + "padding: 1em; "
                        + "background-color: #F8F9FA; "
                        + "border-radius: 1em; "
                        + "box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;"
                        + "color: #2C2E33;\"";
                
                contestants += "<div " + listItemStyle + ">";
                contestants += "<h3>" + names[randInt] + "</h3>";
                contestants += "<h3 " + scoreStyle + ">" + score + "</h3>";
                contestants += "</div>";
            }
            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.println("<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">");
            out.println("<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>");
            out.println("<link href=\"https://fonts.googleapis.com/css2?family=Roboto&display=swap\" rel=\"stylesheet\">");
            out.println("<title>Contestants</title>");          
            
            // Adds roboto font and some styling
            out.println("<style>");
            out.println("* { padding: 0; margin: 0; font-family: 'Roboto', sans-serif; } body { background-color: #CED4DA; }");
            out.println("</style");
            
            out.println("</head>");
            out.println("<body>");
            
            // Body content
            out.println("<div style=\"text-align: center; color: #101113;\">");
            out.println("<h1 style=\"margin-top: 1em;\">" + "The Contestants" + "</h1>");
            out.println("<h4 style=\"margin-top: 1em;\">" + "These are the nine randomly drawn contestants we have!" + "</h4>");
            out.println("</div>");
            
            // The nine contestants
            out.println("<div style=\"display: block; margin: auto; text-align: center; max-width: 480px;\">");
            out.println(contestants);
            out.println("</div>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    // Don't need this since i don't use POST in this project
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processPostRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
