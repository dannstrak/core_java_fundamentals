package Capitulo_06_Interfaces_Lambda_Expresions_and_Inner_Classes;

import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;

class Producto {
    String nombre;
    double precio;
    String categoria;

    public Producto(String nombre, double precio, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }
}

public class SistemaTienda {
    public static void main(String[] args) {

        // 1. PREDICATE (Evalúa una condición y retorna boolean)
        // Reto: Debe retornar 'true' SOLAMENTE si la categoría del producto es "Suplemento".
        Predicate<Producto> esSuplemento = (categoria) -> {
            if (categoria.categoria == "Suplemento"){
                return true;
            }else
                return false;
        };

        // 2. FUNCTION (Recibe un dato tipo A y retorna un dato tipo B)
        // Reto: Recibe un Producto y retorna su precio aplicándole un 10% de descuento (precio * 0.90).
        Function<Producto, Double> calcularPrecioConDescuento = (Producto) -> {
            var precioActual = Producto.precio;
            var precioFinal = precioActual * 0.90;
            return precioFinal;
        };

        // 3. CONSUMER (Recibe un dato, hace algo con él, no retorna nada)
        // Reto: Imprimir en consola el producto con este formato exacto: "Ticket: [Nombre] -> $[Precio]"
        Consumer<Producto> imprimirTicket = (P)->{
            System.out.println("Ticket: " + P.nombre+  "->" + "$"+ P.precio);
        };


        // 4. SUPPLIER (No recibe nada, pero fabrica y retorna un dato)
        // Reto: Retornar siempre un nuevo Producto de regalo, por ejemplo: nombre "Shaker", precio 0.0, categoría "Accesorio".
        Supplier<Producto> generarRegalo = ()->{
            Random random = new Random();
            var seleccionador = random.nextInt(1, 4);
            switch (seleccionador){
                case 1:
                    return new Producto("Shaker", 0.0, "Accesorio");
                case 2:
                    return new Producto("Camiseta", 0.0 , "Ropa");
                case 3:
                    return  new Producto("Crema de Arroz", 0.0, "Suplemento");
            }
            return null;
        };

        // --- PRUEBA DE ESCRITORIO ---
        Producto p1 = new Producto("Mutant Mass", 65.0, "Suplemento");
        Producto p2 = new Producto("Camiseta Breathedivinity", 25.0, "Ropa");

        System.out.println("¿Mutant Mass aplica para descuento? " + esSuplemento.test(p1)); // Debería dar true
        System.out.println("Precio final: $" + calcularPrecioConDescuento.apply(p1)); // Debería dar 58.5

        imprimirTicket.accept(p2); // Debería imprimir: Ticket: Camiseta Breathedivinity -> $25.0
        imprimirTicket.accept(generarRegalo.get()); // Debería imprimir el regalo
    }
}