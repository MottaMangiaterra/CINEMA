package Colecciones;

import Excepciones.ClaveNotFoundException;
import Excepciones.SalaNotFoundException;

public interface ManejoHashMap<K, V> {
    void agregarElemento(K clave, V valor);
    V obtenerElemento(K clave);
    void eliminarElemento(K clave) throws SalaNotFoundException, ClaveNotFoundException;
    void limpiar();
    int obtenerTamaño();
    String obtenerLlaves();
}
