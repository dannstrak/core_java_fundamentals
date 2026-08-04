package Capitulo_06_Interfaces_Lambda_Expresions_and_Inner_Classes.Integrative_Project_01;

/*
 * PARTE 1: Tu Propia Interfaz Funcional
 * 1. Fuera de la clase principal (o dentro, como prefieras), crea tu propia
 *    interfaz llamada 'EstrategiaPuntuacion'.
 * 2. Anótala con la etiqueta correcta para asegurar que sea funcional.
 * 3. Define un único método abstracto 'int calcularPuntaje(int tiempoEjecucion, int bugs)'.
 */

@FunctionalInterface
public interface EstrategiaPuntuacion {
    abstract int calcularPuntaje(int tiempoEjecucion, int bugs);
}
