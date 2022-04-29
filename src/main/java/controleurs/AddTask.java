package controleurs;
import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modele.Task;
import modele.ToDoList;

public class AddTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String nom = request.getParameter("nom");
		if (nom == null) nom = ""; else nom = nom.trim();
		String description = request.getParameter("description");
		if (description == null) description = ""; else description = description.trim();

		if (nom == "") {
			getServletContext().getRequestDispatcher("/erreur.jsp").forward(request, response);
			return;
		}
		Task nouvelle = new Task(nom, description);
		ToDoList toDo = (ToDoList)getServletContext().getAttribute("toDo");
		if (toDo == null) {
			toDo = new ToDoList();
			getServletContext().setAttribute("toDo", toDo);
		}
		toDo.add(nouvelle);
		getServletContext().getRequestDispatcher("/").forward(request, response);
	}
}