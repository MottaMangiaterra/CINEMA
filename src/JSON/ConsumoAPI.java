package JSON;
import CINE.Golosina;
import CINE.Pelicula;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashSet;

public class ConsumoAPI {
    public void consumirlaAPI(HashSet<Pelicula> peliculas, HashSet<Golosina> golosinas)
    {
        try {
            String jsonResponse = JsonUtiles.leerJSON("Peliss");//json pelis
            JSONArray jsonArray = new JSONArray(jsonResponse);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                peliculas.add(new Pelicula(jsonObject.getString("nombre"), jsonObject.getString("genero"), jsonObject.getInt("duracion"), jsonObject.getString("clasificacion")));
            }

         /*   String golosinaJsonResponse=JsonUtiles.leerJSON("Golosinas"); //json golosinas
            JSONArray jsonArray1=new JSONArray(golosinaJsonResponse);
            for(int j=0;j<jsonArray1.length();j++)
            {
                JSONObject jsonObject= jsonArray1.getJSONObject(j);
                golosinas.add(new Golosina(jsonObject.getString("marca"),jsonObject.getString("sinTacc"),jsonObject.getString("nombre"),jsonObject.getDouble("precio")));
            }*/
        }catch (JSONException jsonException)
        {
            System.out.println(jsonException.fillInStackTrace());
            System.out.println("JSON mal formado");
        }


    }

}
