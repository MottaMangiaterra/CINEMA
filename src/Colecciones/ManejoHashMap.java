package Colecciones;

import Excepciones.ClaveNotFoundException;
import Excepciones.ElementoNotFoundException;

public interface ManejoHashMap<K, V> {
    void agregarElemento(K clave, V valor);
    V obtenerElemento(K clave) throws ElementoNotFoundException, ClaveNotFoundException;
    void eliminarElemento(K clave) throws ElementoNotFoundException, ClaveNotFoundException;
    void limpiar();
    int obtenerTamaño();
    String obtenerLlaves();
}
