public class Pilas {
    private int[] pila;
    private int tope;
    private int max;
    
    public Pilas(int tamano) {
        this.max = tamano;
        this.pila = new int[tamano];
        this.tope = -1;
    }
    
    // Método para verificar si la pila está vacía
    public boolean estaVacia() {
        return tope == -1;
    }
    
    // Método para verificar si la pila está llena
    public boolean estaLlena() {
        return tope == max - 1;
    }
    
    // Método para buscar un elemento por posición
    public int buscarElemento(int posicion) {
        if (posicion < 0 || posicion > tope) {
            System.out.println("Posición inválida");
            return -1;
        }
        return pila[posicion];
    }
    
    // Método para insertar un elemento
    public void insertarElemento(int elemento) {
        if (!estaLlena()) {
            tope++;
            pila[tope] = elemento;
            System.out.println("Elemento " + elemento + " insertado correctamente");
        } else {
            System.out.println("La pila está llena");
        }
    }
    
    // Método para actualizar un elemento por posición
    public void actualizarElemento(int posicion, int nuevoValor) {
        if (posicion < 0 || posicion > tope) {
            System.out.println("Posición inválida");
            return;
        }
        pila[posicion] = nuevoValor;
        System.out.println("Elemento actualizado correctamente");
    }
    
    // Método para eliminar un elemento
    public int eliminarElemento() {
        if (!estaVacia()) {
            int elemento = pila[tope];
            tope--;
            System.out.println("Elemento " + elemento + " eliminado correctamente");
            return elemento;
        } else {
            System.out.println("La pila está vacía");
            return -1;
        }
    }
    
    // Método para imprimir la pila
    public void imprimirPila() {
        if (estaVacia()) {
            System.out.println("La pila está vacía");
            return;
        }
        
        System.out.println("\nElementos en la pila:");
        for (int i = tope; i >= 0; i--) {
            System.out.println("[" + i + "] => " + pila[i]);
        }
    }
    
    // Main
    public static void main(String[] args) {
        Pilas pila = new Pilas(5);
        
        // Insertar
        pila.insertarElemento(10);
        pila.insertarElemento(20);
        pila.insertarElemento(30);
        
        // Imprimir
        pila.imprimirPila();
        
        // Buscar
        System.out.println("Elemento en posición 1: " + pila.buscarElemento(1));
        
        // Actualizar
        pila.actualizarElemento(1, 25);
        pila.imprimirPila();
        
        // Eliminar
        pila.eliminarElemento();
        pila.imprimirPila();
    }
}
