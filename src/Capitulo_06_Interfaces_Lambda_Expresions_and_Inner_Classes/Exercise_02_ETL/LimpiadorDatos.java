package Capitulo_06_Interfaces_Lambda_Expresions_and_Inner_Classes.Exercise_02_ETL;

/**
 * INSTRUCCIONES DEL EJERCICIO (BASE):
 * 1. Crear una interfaz funcional llamada LimpiadorDatos.
 * 2. Definir un único método llamado 'limpiar'.
 * 3. El método debe recibir un String (el dato crudo) y devolver un String (el dato limpio).
 * 4. Sin genéricos en esta interfaz.
 */

@FunctionalInterface
public interface LimpiadorDatos {
    abstract String limpiar(String datoSinProcesamiento);
}
