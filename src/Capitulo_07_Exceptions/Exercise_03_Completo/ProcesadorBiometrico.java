package Capitulo_07_Exceptions.Exercise_03_Completo;

import java.util.function.Consumer;

// Clases de Excepciones.
class ConexionPerdidaException extends Exception{
    public ConexionPerdidaException(String mensaje){
        super(mensaje);
    }
}
class SensorDanadoException extends RuntimeException{
    public SensorDanadoException(String mensaje){
        super(mensaje);
    }
}

// Clase de Recurso.
class BaseDeDatos implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Conexion a Base de Datos Cerrada");
    }
    public void guardarMetrica(double bpm) throws ConexionPerdidaException{
        if(bpm == -1.0){
            throw new ConexionPerdidaException("Timeout: Se perdio conexion con el servidor");
        } else if (bpm > 300.0) {
            throw new SensorDanadoException("El sensor esta enviando basura");
        } else{
            System.out.println("Metrica guardada: "+ bpm +" BPM");
        }
    }
}

public class ProcesadorBiometrico {
    public void analizarLote (double[] lecturas, double umbralPeligro){
        Consumer<Double> alertaMedica = (valor)-> {
            System.out.println("Alerta medica: Ritmo Cardiaco peligroso "+ valor);
        };
        // InnerClass.
        class PipelineInterno{
            public void ejecutar(){
                try(var in = new BaseDeDatos()){
                    for(double lectura : lecturas){
                        if(lectura >= umbralPeligro)
                            alertaMedica.accept(lectura);
                        in.guardarMetrica(lectura);
                    }
                } catch (ConexionPerdidaException e) {
                    System.out.println("Error en lote: "+ e.getMessage());
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
        var pipeInterno = new PipelineInterno();
        pipeInterno.ejecutar();
    }

    public static void main(String[] args) {
        ProcesadorBiometrico procesador = new ProcesadorBiometrico();

        System.out.println("--- ESCENARIO 1: Lote Exitoso con Alerta ---");
        double[] lote1 = {110.5, 125.0, 185.5, 140.2};
        procesador.analizarLote(lote1, 180.0); // 185.5 debe disparar la alerta médica

        System.out.println("\n--- ESCENARIO 2: Caída de Red (Chequeada) ---");
        double[] lote2 = {115.0, -1.0, 130.0};
        // Debe detenerse en -1.0, atrapar el error, cerrar DB y NO procesar el 130.0
        procesador.analizarLote(lote2, 180.0);

        System.out.println("\n--- ESCENARIO 3: Sensor Dañado (Unchecked) ---");
        double[] lote3 = {120.0, 450.0, 110.0};
        try {
            procesador.analizarLote(lote3, 180.0); // 450.0 debe hacer explotar el programa
        } catch (SensorDanadoException e) {
            System.out.println("EXCEPCIÓN FATAL ATRAPADA EN MAIN: " + e.getMessage());
        }
    }
}
