/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.stringcalculation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sandu
 */
@WebServlet(name = "StringCalculation", urlPatterns = {"/StringCalculation"})
public class StringCalculation extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String input = request.getParameter("inputValue");
//            String input = "10+2";
        input = input.replace(" ","");

        String parsedInteger = "";
        String operator = "";
        int aggregate = 0;
        for (int i = 0; i < input.length(); i++){
            char c = input.charAt(i); 
            if (Character.isDigit(c)) {
                parsedInteger += c;
            }
            if (!Character.isDigit(c) || i == input.length()-1){
                int parsed = Integer.parseInt(parsedInteger);
                if (operator == "") {
                    aggregate = parsed;
                }
                else {
                    if (operator.equals("+")) {
                        aggregate += parsed;
                    }else if (operator.equals("-")){
                        aggregate -= parsed;
                    }else if (operator.equals("*")){
                        aggregate *= parsed;
                    }else if (operator.equals("/")){
                        aggregate /=parsed;
                    }
                    
                }

                parsedInteger ="";
                operator = ""+c;
            }
        }
        System.out.println("Sum of " + input+":\r\n" + aggregate);
    
  out.print("<h1>"+"Result:"+aggregate+"</h1>");
  
          
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
