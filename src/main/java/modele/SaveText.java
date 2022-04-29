package modele;

import java.io.PrintWriter;

public class SaveText implements Operation {
	private PrintWriter w;
	public SaveText(PrintWriter w) {
		this.w = w;
	}
	public void doItOn(ToDoList l) throws Exception {
		for(Task t : l) { doItOn(t); }
	}
	public void doItOn(Task t) throws Exception {
		w.print(t.getName());
		w.print('\t');
		w.print(t.getComment());
		w.print('\t');
		w.println(t.getStatus());
	}
}
