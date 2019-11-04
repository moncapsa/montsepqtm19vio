package birdH;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditBird2")
public class EditBird2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);

		String name = request.getParameter("name");
		String latinName = request.getParameter("latinName");
		String location = request.getParameter("location");
		String observation = request.getParameter("observation");

		Bird bird = new Bird();
		
		bird.setId(id);
		bird.setName(name);
		bird.setLatinName(latinName);
		bird.setLocation(location);
		bird.setObservation(observation);

		int status = BirdDao.update(bird);

		if (status > 0) {
			response.sendRedirect("ViewBird");
		} else {
			out.println("Sorry! unable to update record");
		}
		out.close();
	}
}