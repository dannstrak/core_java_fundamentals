package Capitulo_06_Interfaces_Lambda_Expresions_and_Inner_Classes.Exercise_01_Monitoreo;

import Capitulo_06_Interfaces_Lambda_Expresions_and_Inner_Classes.Base_Code.alertaStock;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

/**
 * INSTRUCCIONES DEL EJERCICIO:
 * PARTE 1: Metodo Generico
 * 1. Crear un metodo estático llamado 'verificarLote'.
 * 2. Usar un tipo genérico <T>.
 * 3. Parámetros requeridos:
 *    - List<T> lote
 *    - Predicate<T> filtro (Interfaz nativa de Java)
 *    - AlertaStock alerta (Interfaz propia)
 * 4. Lógica: Recorrer el lote con un bucle for-each. Si el elemento cumple la condición
 *    del filtro, convertir el elemento a String, concatenarle "ALERTA DE INVENTARIO: "
 *    y enviarlo al metodo de la interfaz AlertaStock.
 * PARTE 2: Metodo Main (Pruebas)
 * Prueba A (Lote de Precios):
 * - Crear List<Double> con: 65.0, 12.5, 900.0, 45.99, 5000.0
 * - Llamar a verificarLote.
 * - Predicate: true si el precio es mayor a 500.0
 * - AlertaStock: Imprimir el mensaje usando System.out.println()
 * Prueba B (Lote de Marcas):
 * - Crear List<String> con: "Mutant Mass", "Garnier", "Genérico_01", "Breathedivinity"
 * - Llamar a verificarLote.
 * - Predicate: true si el nombre contiene la palabra "Genérico"
 * - AlertaStock: Imprimir el mensaje de forma normal (System.out), pero en MAYÚSCULAS.
 */

public class monitoreoInventario {
    public static <T> void verificarLote(List<T> lote, Predicate<T> filtro, alertaStock alerta) {
        for(T elemento : lote){
            if(filtro.test(elemento)){
                String s = elemento.toString() + " "+ "ALERTA DE INVENTARIO";
                alerta.dispararAlerta(s);
            }
        }
    }

    static void main() {
        System.out.println("-------------------Prueba A----------------------------");
        List<Double> doubleElements = new ArrayList<>();
        doubleElements.add(65.0);
        doubleElements.add(12.5);
        doubleElements.add(900.0);
        doubleElements.add(45.99);
        doubleElements.add(5000.0);
        verificarLote(doubleElements, elemento -> elemento > 500.0, mensaje -> System.out.println(mensaje));

        System.out.println("----------------Prueba B------------------------------");
        List<String> productos = new ArrayList<>();
        productos.add("Mutant_Mass");
        productos.add("Garnier");
        productos.add("Generico_01");
        productos.add("BreatheDivinity");
        verificarLote(productos, producto -> producto.contains("Generico"), mensaje -> System.out.println(mensaje.toUpperCase(Locale.ROOT)));
    }
}
