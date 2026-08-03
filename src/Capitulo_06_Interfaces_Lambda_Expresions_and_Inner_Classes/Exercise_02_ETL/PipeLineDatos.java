package Capitulo_06_Interfaces_Lambda_Expresions_and_Inner_Classes.Exercise_02_ETL;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * INSTRUCCIONES DEL EJERCICIO (RETO):
 *
 * PARTE 1: Método Genérico
 * 1. Crear un método estático llamado 'procesarColumna'.
 * 2. Usar un tipo genérico <T>.
 * 3. Parámetros:
 *    - List<T> columnaDatos
 *    - Predicate<T> filtroValidos
 *    - LimpiadorDatos limpiador
 * 4. Lógica: Recorrer la lista. Si el elemento pasa el filtro (es válido),
 *    conviértelo a String, pásalo por el método de tu 'limpiador', y
 *    imprime el resultado limpio en consola con System.out.println().
 *
 * PARTE 2: Método Main (Pruebas)
 * Prueba A (Limpieza de Textos con espacios extra):
 * - Crear List<String> con: "   Alejandro  ", " ", "Pepe", "   "
 * - Llamar a procesarColumna.
 * - Predicate: true si el texto NO está vacío ni compuesto solo de espacios
 *   (Pista: usa el método .isBlank() y niégalo con !).
 * - LimpiadorDatos: Usa el método .trim() para quitar los espacios de los bordes
 *   y .toUpperCase() para estandarizar.
 *
 * Prueba B (Limpieza de Identificadores Numéricos):
 * - Crear List<Integer> con: 1050, -1, 4020, 0, 89
 * - Llamar a procesarColumna.
 * - Predicate: true si el número es mayor a 0 (ignoramos IDs corruptos).
 * - LimpiadorDatos: Añade el prefijo "ID-" al número convertido en texto (ej. "ID-1050").
 */

public class PipeLineDatos {
    public static <T> List<String> procesarColumna (List<T> columnaDatos, Predicate<T> filtroValidos, LimpiadorDatos limpiador){
        List<String> listaFinal = new ArrayList<>();
        for(T elementos : columnaDatos){
            if(filtroValidos.test(elementos)){
                var stringConvertido = elementos.toString();
                var StringFinal = limpiador.limpiar(stringConvertido);
                listaFinal.add(StringFinal);
            }
        }
        return listaFinal;
    }

    static void main(String[] args) {
        System.out.println("---------------------Prueba A_Limpieza de Textos con espacios Extra---------------------------");
        List<String> textos = new ArrayList<>();
        textos.add("   Alejandro  ");
        textos.add(" ");
        textos.add("Pepe");
        textos.add("   ");

        // Lista Final y despliege de la lista.
        List<String> listaFinal = new ArrayList<>();
        listaFinal = procesarColumna(textos, texto -> !texto.isBlank() , texto -> {
            var texto_Final = texto.trim().toUpperCase();
            return texto_Final;
        });
        IO.println("-------Lista de Datos Limpos Post-Procesamiento-----------------");
        for(String elemento: listaFinal){
            System.out.println("Elemento Limpio: "  + elemento);
        }

        System.out.println("--------------------Prueba B_Limpieza de Identificadores Numericos---------------------------");
        List<Integer> numericos = new ArrayList<>();
        numericos.add(1050);
        numericos.add(-1);
        numericos.add(4020);
        numericos.add(0);
        numericos.add(89);

        List<String> listaNumericaFinal = new ArrayList<>();
        listaNumericaFinal = procesarColumna(numericos, numero -> numero >0 , stringFinal ->{
            var textoFinal = "ID-"+stringFinal;
            return textoFinal;
        } );
        for(String elemento : listaNumericaFinal){
            System.out.println("Elemento Limpio :" + elemento);
        }
    }
}
