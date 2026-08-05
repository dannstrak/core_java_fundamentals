package Capitulo_06_Interfaces_Lambda_Expresions_and_Inner_Classes.Exercise_07_Reto_Avanzado;

import java.util.ArrayList;
import java.util.List;

// Dos interfaces funcionales genéricas estándar
interface Parser<T> {
    T parse(String s);
}

interface Evaluador<T> {
    boolean evaluar(T obj);
}

public class RetoAvanzadoCap6 {

    public static void analizarCoordenadas(String[] datos) {

        // RETO 1: LA CLASE LOCAL (Local Inner Class)
        // Crea aquí adentro una clase llamada 'Punto'.
        // - Debe tener dos atributos: double x, double y.
        // - Un constructor que reciba un ÚNICO parámetro String (ej: "3.5,4.2"),
        //   lo divida usando .split(",") y asigne x e y (Usa Double.parseDouble).
        // - Un método boolean llamado 'estaEnPrimerCuadrante()' que retorne true si x > 0 e y > 0.

        /* --- ESCRIBE LA CLASE PUNTO AQUÍ --- */
        class Punto{
            double x;
            double y;
            // Constructor
            Punto(String valoresCompletos){
                // split ya te devuelve un arreglo de Strings directo, no necesitas listas
                String[] partes = valoresCompletos.split(",");
                this.x = Double.parseDouble(partes[0]);
                this.y = Double.parseDouble(partes[1]);
            }
            // Metodo Boolean
            boolean estaEnPrimerCuadrante(){
                return (x>0 && y>0);
            }
        }

        // RETO 2: CONSTRUCTOR REFERENCE MODO EXPERTO
        // Instancia la interfaz Parser para que cree objetos 'Punto'.
        // ¡OBLIGATORIO usar Constructor Reference (::new)!
        Parser<Punto> creador = Punto::new;

        // Parser<Punto> creador = ???;


        // RETO 3: METHOD REFERENCE (Clase::metodoInstancia)
        // Instancia la interfaz Evaluador para que ejecute 'estaEnPrimerCuadrante'.
        // ¡OBLIGATORIO usar Method Reference!
        // PISTA: La interfaz Evaluador recibe el objeto por parámetro (T obj).
        // Es tu oportunidad de usar la regla 3 que vimos antes: Clase::metodo
        // Evaluador<Punto> validador = ???;

        Evaluador<Punto> validador = Punto::estaEnPrimerCuadrante;

        // LÓGICA DE EJECUCIÓN (No tocar)
        int puntosValidos = 0;
        for (String d : datos) {
            // El creador invoca Punto::new
            var punto = creador.parse(d);

            // El validador invoca punto.estaEnPrimerCuadrante()
            if (validador.evaluar(punto)) {
                puntosValidos++;
            }
        }
        System.out.println("Puntos en el 1er cuadrante: " + puntosValidos);
    }

    public static void main(String[] args) {
        String[] coordenadas = {"3.0,4.0", "-1.0,5.0", "6.5,2.1", "-2.0,-2.0"};
        // El resultado esperado al ejecutar debería ser: 2
        analizarCoordenadas(coordenadas);
    }
}