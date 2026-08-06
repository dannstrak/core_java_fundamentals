package Capitulo_07_Exceptions;

public class TutorialExcepciones {

    // Este método simula leer una puntuación y dividirla para sacar un promedio
    public static int calcularPromedio(String puntosStr, int partidas) {

        // RETO 1: LANZAR UNA EXCEPCIÓN MANUAL (throw)
        // La matemática dice que no puedes dividir por cero.
        // Si la variable 'partidas' es 0, el programa lanzará un ArithmeticException más abajo.
        // Adelántate a eso: Escribe un 'if' que valide si 'partidas' es 0.
        // Si es 0, usa la palabra 'throw' para lanzar una nueva IllegalArgumentException
        // con el mensaje: "Las partidas no pueden ser cero".

        /* --- ESCRIBE TU VALIDACIÓN AQUÍ --- */
        if (partidas == 0){
            throw new IllegalArgumentException("Las partidas no pueden ser cero.");
        }
        /* ---------------------------------- */
        int puntos = Integer.parseInt(puntosStr);
        return puntos / partidas;
    }

    public static void main(String[] args) {
        String[] datos = {"150", "Hola", "200", null};
        int[] partidasJugadas = {3, 2, 0, 5};

        for (int i = 0; i < datos.length; i++) {
            System.out.println("Procesando dato: " + datos[i]);

            // RETO 2: EL BLOQUE TRY-CATCH MULTIPLE
            // Envuelve la llamada al método 'calcularPromedio' en un bloque try.
            // Necesitas capturar y manejar TRES posibles errores distintos usando 'catch':
            // 1. NumberFormatException (Si intentas procesar "Hola")
            // 2. IllegalArgumentException (La que tú mismo lanzaste en el Reto 1)
            // 3. NullPointerException (Si el string es null)

            /* --- INICIA TU TRY-CATCH AQUÍ --- */
            try{
                int resultado = calcularPromedio(datos[i], partidasJugadas[i]);
                System.out.println("Promedio: "+ resultado);
            } catch (NumberFormatException e) {
                System.out.println("Error de formato: " + e.getMessage());
            } catch (IllegalArgumentException e){
                System.out.println("Error matemático: " + e.getMessage());
            } catch (NullPointerException e){
                System.out.println("Error de nulos: " + e.getMessage());
            }
            /* --- TERMINA TU TRY-CATCH AQUÍ --- */

            System.out.println("---");
        }
    }
}