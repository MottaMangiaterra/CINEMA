package JSON;
import CINE.Golosina;
import CINE.Pelicula;
import CINE.Sala;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.util.HashMap;
import java.util.HashSet;

public class ConsumoAPI {
    public void consumirlaAPI(HashSet<Pelicula> peliculas, HashSet<Golosina> golosinas)
    {
        try {
            String jsonResponse = JsonUtiles.leerJSON("Peliss");//json pelis
            JSONArray jsonArray = new JSONArray(jsonResponse);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                JSONArray jsonArrayH= jsonObject.getJSONArray("horarios");
                JSONArray jsonArrayS=jsonObject.getJSONArray("salas");
                HashMap<Integer,Sala> salaHashMap=new HashMap<>();
                for(int j=0;j<jsonArrayH.length();j++) {
                    JSONObject jsonObjectS=jsonArrayS.getJSONObject(j);
                    double horario = jsonArrayH.getDouble(j);
                    Integer horarioReal= (int) (horario*100);
                    Sala sala=new Sala(jsonObjectS.getInt("numeroSala"),jsonObjectS.getInt("cantButacas"));

                    salaHashMap.put(horarioReal,sala);
                }
                peliculas.add(new Pelicula(jsonObject.getString("nombre"), jsonObject.getString("genero"), jsonObject.getInt("duracion"), jsonObject.getString("clasificacion"),salaHashMap));
                salaHashMap.clear();
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
            System.out.println("JSON mal formado");
        }


    }

}
