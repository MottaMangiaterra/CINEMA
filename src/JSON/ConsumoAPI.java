package JSON;
import CINE.Pelicula;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.util.ArrayList;

public class ConsumoAPI {
    public void consumirlaAPI(ArrayList<Pelicula> peliculas)
    {
        try {
            String jsonResponse = JsonUtiles.leerJSON("Peliss");
            JSONArray jsonArray = new JSONArray(jsonResponse);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                System.out.println("Nombre" + jsonObject.getString("nombre"));
                System.out.println("Genero" + jsonObject.getString("genero"));
                System.out.println("Duracion" + jsonObject.getInt("duracion"));
                System.out.println("Clasificacion" + jsonObject.getString("clasificacion"));

                peliculas.set(i, new Pelicula(jsonObject.getString("nombre"), jsonObject.getString("genero"), jsonObject.getInt("duracion"), jsonObject.getString("clasificacion")));
            }
        }catch (JSONException jsonException)
        {
            System.out.println("JSON mal formado");
        }

    }

}
