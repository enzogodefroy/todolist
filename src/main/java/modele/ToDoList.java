package modele;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ToDoList implements Iterable<Task>, Operable {
	private List<Task> content;
	public ToDoList() {
		content = new ArrayList<Task>();
	}
	public List<Task> getContent() {
		return content;
	}
	public void setContent(ArrayList<Task> cont) {
		content.clear();
		for(Task t : cont) {
			content.add(t);
		}
	}
	public int size() {
		return content.size();
	}
	public void add(Task t) {
		content.add(0, t);
	}
	public Task get(int index) {
		return content.get(index);
	}
	public Iterator<Task> iterator() {
		return content.iterator();
	}
	public void clear() {
		content.clear();
	}
	public void purge() {
		Iterator<Task> it = iterator();
		while(it.hasNext()) {
			Task t = it.next();
			if (t.getStatus() == Status.DONE) {
				it.remove();
			}
		}
	}

	public void enregistre (String nomFichier, TypeFichier typeFichier)
	{
		Save s = new Save(this);
		s.saveAs(nomFichier, typeFichier);
	}
	public void charge(DataInputStream s) throws IOException {
		int n = s.readInt();
		content = new ArrayList<Task>();
		for(int i = 0; i < n; i++) {
			Task t = new Task(); t.charge(s); add(t);
		}
	}
	public void enregistreSous(String nomFichier) {
		try (DataOutputStream s = new DataOutputStream(new FileOutputStream(nomFichier+".bin"))) {
			Operation op = new SaveBinary(s);
			this.performs(op);
			s.close();
		} catch (Exception e) { }
	}
	public void exporteSous(String nomFichier) {
		try (PrintWriter w = new PrintWriter(new FileWriter(nomFichier + ".txt"))) {
			Operation op = new SaveText(w);
			this.performs(op);
			w.close();
		} catch (Exception e) { }
	}
	public void exporteXML(String nomFichier) {
		try (PrintWriter w = new PrintWriter(new FileWriter(nomFichier + ".xml"))) {
			Operation op = new SaveXML(w);
			this.performs(op);
			w.close();
		} catch (Exception e) { }
	}
	public void performs(Operation op) throws Exception {
		op.doItOn(this);
	}
	public void chargeDepuis(String nomFichier) {
		try (DataInputStream s = new DataInputStream(new FileInputStream(nomFichier))) {
			charge(s);
			s.close();
		} catch (IOException e) { }
	}
}
