package Colecciones;

import java.util.HashMap;

public class MiManejadorHashMap {
    public class ManejadorHashMap<K, V> implements ManejoHashMap<K, V> {
        private HashMap<K, V> hashMap;

        public ManejadorHashMap() {
            hashMap = new HashMap<>();
        }

        public void agregarElemento(K clave, V valor) {
            hashMap.put(clave, valor);
        }

        public V obtenerElemento(K clave) {
            return hashMap.get(clave);
        }

        public boolean contieneClave(K clave) {
            return hashMap.containsKey(clave);
        }

        public boolean contieneValor(V valor) {
            return hashMap.containsValue(valor);
        }

        public void eliminarElemento(K clave) {
            hashMap.remove(clave);
        }

        public void limpiar() {
            hashMap.clear();
        }

        public int obtenerTamaño() {
            return hashMap.size();
        }
    }
}
