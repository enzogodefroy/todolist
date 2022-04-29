package modele;

import java.io.PrintWriter;
import java.lang.reflect.Type;

public class SaveFactory {
    
    public static Operation saveForType(TypeFichier fileType, PrintWriter w)
    {
        switch (fileType)
        {
            case JSON:
                return new SaveJson(w);
            case XML:
                return new SaveXML(w);
            case TEXT:
                return new SaveText(w);
            default:
                return null;
        }
    }
}
