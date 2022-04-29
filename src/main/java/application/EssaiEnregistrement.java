package application;

import modele.Save;
import modele.Task;
import modele.ToDoList;
import modele.TypeFichier;

public class EssaiEnregistrement{
	public static void main(String[] args) {
		ToDoList list = new ToDoList();
		Task t1 = new Task("une premiere chose");
		Task t2 = new Task("une deuxieme chose", "la deuxieme chose a faire");
		Task t3 = new Task("une troisieme chose", "la troisieme chose a faire");
		list.add(t1);
		list.add(t2);
		list.add(t3);
		t1.setInProgress();
		t2.setInProgress();
		t1.setDone();
		/*list.enregistreSous("liste");
		list.exporteSous("liste");
		list.exporteXML("liste");*/
		
		Save s = new Save(list);
		s.saveAs("liste", TypeFichier.BINARY);
		Save s1 = new Save(list);
		s1.saveAs("liste1", TypeFichier.XML);
		Save s2 = new Save(list);
		s2.saveAs("liste2", TypeFichier.TEXT);

		/*
		ToDoList readedList = new ToDoList();
		readedList.chargeDepuis("liste.tdl");
		for(Task t : readedList) {
			System.out.println(t.getName()+'\t'+t.getComment()+'\t'+t.getStatus());
		}
		*/
	}
}
