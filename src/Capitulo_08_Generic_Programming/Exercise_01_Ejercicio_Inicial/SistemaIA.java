package Capitulo_08_Generic_Programming.Exercise_01_Ejercicio_Inicial;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// --- TU RETO EMPIEZA AQUÍ ---

// 1. LÍMITES RECURSIVOS Y MÚLTIPLES
// TODO: Crea una interfaz genérica llamada 'NodoGrafo'.
// Requisitos de su Type Parameter <T>:
// - Debe ser recursivo: 'T' debe estar obligado a ser un hijo de 'NodoGrafo<T>'.
// - Límite múltiple: 'T' también DEBE implementar obligatoriamente la interfaz estándar 'Comparable<T>'.
// Métodos de la interfaz:
// - public double obtenerActivacion();
interface NodoGrafo<T extends NodoGrafo & Comparable>{
    public abstract double obtenerActivacion();
}


// 2. IMPLEMENTACIÓN CONCRETA DEL CONTRATO
// TODO: Crea una clase 'NodoNeuronal' que implemente 'NodoGrafo' cumpliendo todas sus estrictas reglas.
// - Atributo privado: double activacion.
// - Constructor que reciba la activacion.
// - Implementa obtenerActivacion().
// - Implementa compareTo() de la interfaz Comparable, comparando las activaciones (tip: usa Double.compare).

class NodoNeuronal implements NodoGrafo{
    private double activacion;
    NodoNeuronal (double activacion){
        this.activacion = activacion;
    }
    @Override
    public double obtenerActivacion() {
        return 0;
    }

    Comparator<Double> compareTo = (dato)-> {
        Double.compare(dato, );
    }

}



// Subclase simulada para probar la varianza (No modificar)
class NodoOculto extends NodoNeuronal {
    public NodoOculto(double activacion) { super(activacion); }
}

// 3. MÉTODOS GENÉRICOS Y PRINCIPIO PECS
class OptimizadorRed {

    // TODO: Crea un método estático 'transferirNodos' usando el principio PECS.
    // Este método debe copiar todos los elementos de una lista a otra.
    // Requisitos de los parámetros:
    // 1. Una Lista 'origen' de la cual vas a LEER datos (Productor).
    // 2. Una Lista 'destino' en la cual vas a ESCRIBIR datos (Consumidor).
    // Hazlo de tal forma que puedas pasarle un List<NodoOculto> como origen
    // y un List<NodoNeuronal> como destino SIN que Java lance error de compilación.




    // TODO: Crea un método estático 'encontrarMasFuerte'.
    // Requisitos:
    // - Type Parameter: Un genérico 'E' que cumpla con las mismas reglas estrictas de NodoGrafo (Recursivo + Comparable).
    // - Parámetro: Una Lista estricta del tipo <E>.
    // - Retorno: El nodo de tipo 'E' que tenga la mayor activación.
    // Lógica: Usa iteración simple. Debes usar el método compareTo() obligatoriamente para saber cuál es mayor.

    static <E extends Comparable > void encontrarMasFuerte(List<E> lista){

    }


}
// --- TU RETO TERMINA AQUÍ ---

public class SistemaIA {
    public static void main(String[] args) {

        // PRUEBA 1: Varianza PECS
        List<NodoOculto> capaOculta = new ArrayList<>();
        capaOculta.add(new NodoOculto(0.8));
        capaOculta.add(new NodoOculto(0.2));

        List<NodoNeuronal> capaGeneral = new ArrayList<>();
        capaGeneral.add(new NodoNeuronal(0.5));

        // Esto DEBE compilar si aplicaste PECS correctamente
        OptimizadorRed.transferirNodos(capaOculta, capaGeneral);
        System.out.println("Tamaño de capa general (Debe ser 3): " + capaGeneral.size());

        // PRUEBA 2: Límites Recursivos
        // Esto DEBE compilar y devolver el nodo con 0.8
        NodoNeuronal masFuerte = OptimizadorRed.encontrarMasFuerte(capaGeneral);
        System.out.println("Activación más fuerte (Debe ser 0.8): " + masFuerte.obtenerActivacion());
    }
}