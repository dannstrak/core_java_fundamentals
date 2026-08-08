package Capitulo_06_Interfaces_Lambda_Expresions_and_Inner_Classes;

import java.util.List;
import java.util.ArrayList;

// RETO 1: LA ESTRUCTURA DE LA INTERFAZ
// Convierte esta interfaz normal en una Interfaz Funcional estricta.
// 1. Añade la anotación correcta en la parte superior.
// 2. Crea un único método abstracto llamado 'aplicar' que reciba un 'double' (precio original)
//    y retorne un 'double' (precio final).
// 3. Crea un método 'default' llamado 'generarEtiqueta' que reciba un String (nombre)
//    y un double (precio), y simplemente lo imprima en consola.

/* --- ESCRIBE TU INTERFAZ AQUÍ --- */
@FunctionalInterface
interface ReglaDescuento {
    abstract double aplicar(double precioOriginal);
    default void generarEtiqueta(String nombre, double precio){
        System.out.println("Nombre: "+nombre + "Precio: "+precio);
    }
}
public class MotorDePrecios {
    public static void procesarInventario(List<String> productos, List<Double> precios, ReglaDescuento regla) {
        for (int i = 0; i < productos.size(); i++) {
            // RETO 3: EJECUCIÓN
            // Llama al método abstracto de la regla para calcular el nuevo precio.
            // Luego, usa el método default de la regla para imprimir el resultado.

            /* --- ESCRIBE TU LÓGICA AQUÍ --- */
            regla.aplicar(precios.get(i));
            regla.generarEtiqueta(productos.get(i), precios.get(i) );
            /* ------------------------------ */
        }
    }

    public static void main(String[] args) {
        List<String> inventario = List.of("Creatina Monohidratada 500g", "Camiseta Compresión Breathedivinity", "Proteína Whey 5lbs");
        List<Double> preciosBase = List.of(35.0, 45.0, 70.0);

        // RETO 2: CREACIÓN DE LAMBDAS
        // Instancia la interfaz 'ReglaDescuento' dos veces usando expresiones Lambda puras.

        // a) descuentoVIP: Resta exactamente 10 dólares al precio sin importar el monto.
        /* --- CREA TU PRIMERA LAMBDA AQUÍ --- */

        ReglaDescuento descuentoVIP = (precio)->{
            double precioFinal = precio - 10;
            return precioFinal;};

        // b) descuentoCyberMonday: Aplica un 20% de descuento (es decir, el precio se multiplica por 0.80).
        /* --- CREA TU SEGUNDA LAMBDA AQUÍ --- */

        ReglaDescuento descuentoCyberMonday = precioOriginal -> {
            var descuento = precioOriginal * 0.80;
            var precioFinal = precioOriginal - descuento;
            return precioFinal;
        };

        System.out.println("--- PRECIOS VIP ---");
        // Descomenta y pasa tu lambda descuentoVIP como tercer parámetro
        procesarInventario(inventario, preciosBase, descuentoVIP);

        System.out.println("\n--- PRECIOS CYBER MONDAY ---");
        // Descomenta y pasa tu lambda descuentoCyberMonday como tercer parámetro
        procesarInventario(inventario, preciosBase, descuentoCyberMonday);
    }
}