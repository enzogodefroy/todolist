package modele;

import java.io.PrintWriter;

public class SaveXML implements Operation {
	private PrintWriter w;
	public SaveXML(PrintWriter w) {
		this.w = w;
	}
	public void doItOn(ToDoList l) throws Exception {
		w.println("<ToDoList>");
		for(Task t : l) { doItOn(t); }
		w.println("</ToDoList>");
	}
	public void doItOn(Task t) throws Exception {
		w.println("<Task>");
		w.print("<name>");
		w.print(t.getName());
		w.println("</name>");
		w.print("<comment>");
		w.print(t.getComment());
		w.println("</comment>");
		w.print("<status>");
		w.print(t.getStatus());
		w.println("</status>");
		w.println("</Task>");
	}
}
