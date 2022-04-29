package modele;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Save {

    private ToDoList toDoList;

    public Save (ToDoList toDoList)
    {
        this.toDoList = toDoList;
    }

    public void saveAs (String nomFichier, TypeFichier typeFichier)
    {
        switch (typeFichier){
            case BINARY:
                try (DataOutputStream s = new DataOutputStream(new FileOutputStream(nomFichier+".bin"))) {
                    Operation op = new SaveBinary(s);
                    toDoList.performs(op);
                } catch (Exception e) { }
            default:
                try (PrintWriter w = new PrintWriter(new FileWriter(nomFichier + "." + typeFichier.extension))) {
                    Operation op = SaveFactory.saveForType(typeFichier, w);
                    toDoList.performs(op);
                } catch (Exception e) { }
        }
    }
}
