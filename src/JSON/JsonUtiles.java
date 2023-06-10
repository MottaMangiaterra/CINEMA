package JSON;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Consume de Manera un JSON Local
 */
public class JsonUtiles {
    /**
     * @param archivo
     * @return Un string con peliculas si
     */
    public static String leerJSON(String archivo) {
        String peliculas = "";

        try {
            peliculas = new String(Files.readAllBytes(Paths.get(archivo + ".json")));
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return peliculas;
    }
}
