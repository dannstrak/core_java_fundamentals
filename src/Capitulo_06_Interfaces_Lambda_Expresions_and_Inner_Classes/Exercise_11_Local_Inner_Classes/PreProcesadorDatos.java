package Capitulo_06_Interfaces_Lambda_Expresions_and_Inner_Classes.Exercise_11_Local_Inner_Classes;

import java.util.ArrayList;
import java.util.List;

public class PreProcesadorDatos {

    // Método que procesa una columna de datos.
    // Los parámetros 'minimoFiltro' y 'maximoFiltro' actuarán como variables effectively final.
    public List<Double> limpiarOutliers(List<Double> columnaRaw, double minimoFiltro, double maximoFiltro) {

        List<Double> datosLimpios = new ArrayList<>();

        // --- TU RETO EMPIEZA AQUÍ ---
        // Crea una Local Inner Class llamada 'Validador'
        // 1. Atributo privado: double valor;
        // 2. Constructor: Solo asigna el valor.
        // 3. Método: public boolean esValido()
        //    Lógica: Debe retornar true SOLAMENTE si su 'valor' es mayor o igual a 'minimoFiltro'
        //            Y menor o igual a 'maximoFiltro'.
        //            Nota cómo la clase interna lee las variables del método envolvente.

        // TODO: Escribe la Local Inner Class Validador aquí
        class Validador{
            private double valor;
            Validador(double valor){
                this.valor = valor;
            }
            boolean esValido(){
                if(valor >= minimoFiltro && valor <= maximoFiltro)
                    return true;
                else
                    return false;
            }
        }
        // TODO: Recorre la lista 'columnaRaw' con un bucle for-each.
        // En cada iteración, instancia un 'Validador' pasándole el valor actual.
        // Si el método esValido() devuelve true, agrega el valor a 'datosLimpios'.

        for(Double e : columnaRaw){
            var validador = new Validador(e);
            if(validador.esValido()){
                datosLimpios.add(e);
            }
        }
        return datosLimpios;
    }

    public static void main(String[] args) {
        PreProcesadorDatos pipeline = new PreProcesadorDatos();

        // Simulamos un dataset sucio con errores de medición
        List<Double> dataset = List.of(-50.5, 12.0, 15.5, 14.2, 999.9, 13.8, -10.0);

        // Queremos filtrar valores irreales. Solo aceptamos datos entre 0.0 y 100.0
        List<Double> resultado = pipeline.limpiarOutliers(dataset, 0.0, 100.0);

        // Esperado: [12.0, 15.5, 14.2, 13.8]
        System.out.println("Dataset procesado: " + resultado);
    }
}