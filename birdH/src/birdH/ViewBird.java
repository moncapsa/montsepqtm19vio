package birdH;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewBird")
public class ViewBird extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("Birds List");

		List<Bird> list = BirdDao.getAllBirds(); 

		out.print("<table id='customers'");
		out.print("<br><br>");
		out.print(
				"<tr><th>Id</th><th>Name</th><th>LatinName</th><th>Location</th><th>Observation</th><th>Edit</th><th>Delete</th></tr>");

		for (Bird bird : list) {
			out.print("<tr><td>" + bird.getId() + "</td><td>" + bird.getName() + "</td><td>"+ bird.getLatinName() + "</td><td>" + bird.getLocation() + "</td><td>" + bird.getObservation() + "</td><td><a href='EditBird?id=" + bird.getId() + "'>edit</a></td> <td><a href='DeleteBird?id=" + bird.getId() + "'>delete</a></td></tr>");

		}
		out.print("</table>");

		out.println("<a href='index.html'>Add New Bird</a>");

		out.close();
	}
}