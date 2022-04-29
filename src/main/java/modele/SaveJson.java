package modele;

import java.io.PrintWriter;

public class SaveJson implements Operation{
    private PrintWriter w;
    public SaveJson(PrintWriter w) {
        this.w = w;
    }

    @Override
    public void doItOn(ToDoList l) throws Exception {

    }

    @Override
    public void doItOn(Task t) throws Exception {

    }
}
