import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileManager {

    public static void guardar(String nomeFicheiro, Object obj) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(nomeFicheiro));
        out.writeObject(obj);
        out.close();
    }

    public static Object carregar(String nomeFicheiro)
            throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(nomeFicheiro));
        Object obj = in.readObject();
        in.close();
        return obj;
    }
}
