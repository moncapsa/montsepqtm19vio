package birdH;

import java.io.IOException;  
import java.io.PrintWriter;   
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
  
@WebServlet("/EditBird")  
public class EditBird extends HttpServlet {  

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
 
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("Update Bird");
        
        String sid = request.getParameter("id");  
        int id =Integer.parseInt(sid);  
          
        Bird b= BirdDao.getBirdById(id);  
          
        out.print("<form action='EditBird2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+b.getId()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+b.getName()+"'/></td></tr>");  
        out.print("<tr><td>LatinName:</td><td><input type='latinName' name='latinName' value='"+b.getLatinName()+"'/></td></tr>");     
        out.print("<tr><td>Location:</td><td><input type='location' name='location' value='"+b.getLocation()+"'/></td></tr>");  
        out.print("<tr><td>Observation:</td><td>");  
        out.print("<select name='observation' style='width:150px'>");  
        out.print("<option>1</option>");  
        out.print("<option>2</option>");  
        out.print("<option>3</option>");
        out.print("<option>4</option>");
        out.print("</select>");  
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
} 