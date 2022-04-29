package modele;

public interface Operation {
	//visit
	void doItOn(ToDoList l) throws Exception;
	void doItOn(Task t) throws Exception;
}
