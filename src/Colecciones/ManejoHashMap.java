package Colecciones;

public interface ManejoHashMap<K, V> {
    void agregarElemento(K clave, V valor);
    V obtenerElemento(K clave);
    boolean contieneClave(K clave);
    boolean contieneValor(V valor);
    void eliminarElemento(K clave);
    void limpiar();
    int obtenerTamaño();
}
