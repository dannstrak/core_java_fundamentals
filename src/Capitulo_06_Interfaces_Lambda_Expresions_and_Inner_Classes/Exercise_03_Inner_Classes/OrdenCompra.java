package Capitulo_06_Interfaces_Lambda_Expresions_and_Inner_Classes.Exercise_03_Inner_Classes;

/**
 * INSTRUCCIONES DEL EJERCICIO (RETO - CLASES INTERNAS Y EXCEPCIONES):
 *
 * PARTE 1: La Clase Externa
 * 1. La clase principal se llamará 'OrdenCompra'.
 * 2. Define dos atributos privados: 'int idOrden' y 'double total' (inicializado en 0.0).
 * 3. Crea un constructor que reciba solo el 'idOrden'.
 * 4. Crea un método getter público para obtener el 'total'.
 *
 * PARTE 2: La Clase Interna
 * 1. DENTRO de 'OrdenCompra', crea una clase llamada 'ItemSuplemento'.
 *    (No le pongas 'static', debe ser una inner class regular).
 * 2. Atributos propios del ítem: 'String nombreProducto', 'int cantidad', 'double precioUnitario'.
 * 3. Crea su constructor recibiendo los 3 parámetros.
 *    [Regla de Excepción]: Dentro de este constructor, si la cantidad es <= 0,
 *    usa la palabra clave 'throw' para lanzar una nueva IllegalArgumentException
 *    con el mensaje "La cantidad no puede ser cero o negativa".
 * 4. Crea un método 'procesarItem()' dentro de esta clase interna.
 *    Este método debe multiplicar la cantidad por el precio, y SUMAR ese resultado
 *    directamente a la variable 'total' de la clase externa OrdenCompra.
 *
 * PARTE 3: Método Main (Pruebas)
 * 1. Instancia una 'OrdenCompra' con el ID 101.
 * 2. Instancia dos ítems usando la sintaxis especial de inner classes (orden.new ItemSuplemento(...)):
 *    - Item A: "Mutant Mass 10lbs", 2 unidades, precio 65.0
 *    - Item B: "Creatina", 1 unidad, precio 25.5
 * 3. Llama al método 'procesarItem()' en ambos ítems.
 * 4. Imprime en consola el total de la orden. (Debería dar 155.5).
 */

public class OrdenCompra {
    private int idOrden;
    private double total = 0.0;

    public OrdenCompra(int idOrden){
        this.idOrden = idOrden;
    }
    public double getTotal (){
        return this.total;
    }
    class ItemSuplemento{
        private String nombreProducto;
        private int cantidad;
        private double precioUnitario;

        ItemSuplemento(String nombreProducto, int cantidad, double precioUnitario){
            this.nombreProducto = nombreProducto;
            this.cantidad = cantidad;
            this.precioUnitario = precioUnitario;
            if(this.cantidad <= 0){
                throw new IllegalArgumentException("La cantidad no debe ser igual a cero o negativa. ");
            }
        }
        void procesarItem(){
            var cantidadParcial = cantidad * precioUnitario;
            OrdenCompra.this.total += cantidadParcial; // Usamos la sintaxis de OutterClass.this.variable para acceder a un atributo de clase.
        }
    }

    static void main(String[] args) {
        var ordenCompra101 = new OrdenCompra(101);
        OrdenCompra.ItemSuplemento itemSuplemento = ordenCompra101.new ItemSuplemento("Mutant Mass", 2, 65.0 );
        OrdenCompra.ItemSuplemento itemSuplemento2 = ordenCompra101.new ItemSuplemento("Creatina", 1, 25.5);
        itemSuplemento.procesarItem();
        itemSuplemento2.procesarItem();

        System.out.println("Total de la Factura: "+ ordenCompra101.getTotal());

    }
}
