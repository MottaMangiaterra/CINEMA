package Colecciones;

import Excepciones.ClaveNotFoundException;
import Excepciones.SalaNotFoundException;

public interface ManejoHashMap<K, V> {
    void agregarElemento(K clave, V valor);
    V obtenerElemento(K clave);
    void limpiar();
    int obtenerTamaño();
    String obtenerLlaves();
}
