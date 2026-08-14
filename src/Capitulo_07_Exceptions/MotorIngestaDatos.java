package Capitulo_07_Exceptions;
// TODO 1: Crea tu propia excepción UNCHECKED llamada 'UmbralErroresExcedidoException'
// Recuerda: Para que sea Unchecked (no obligatoria de atrapar), debe heredar de la clase correcta, no de 'Exception'.

class UmbralErroresExcedidoException extends RuntimeException{
    public UmbralErroresExcedidoException (String mensaje){
        super(mensaje);
    }
}

public class MotorIngestaDatos implements AutoCloseable{

    // Simulamos un método que limpia métricas antes de pasarlas a un modelo predictivo
    public void limpiarDataset(String[] filasCsv) {
        int erroresPermitidos = 2;
        int contadorErrores = 0;
        int filasValidas = 0;

        System.out.println("Iniciando limpieza del dataset...");

        for (int i = 0; i < filasCsv.length; i++) {
            String fila = filasCsv[i];
            try {
                // TODO 2: Convierte el texto de la 'fila' a un número 'double' usando Double.parseDouble()
                // TODO 3: Si el número extraído es menor a 0.0, lanza una IllegalArgumentException pura de Java con el mensaje "Valor negativo no válido".
                // TODO 4: Si superó las validaciones, incrementa 'filasValidas' e imprime "Fila válida procesada: [valor]".

                double textoANumber = Double.parseDouble(fila);
                if (textoANumber < 0.0) {
                    throw new IllegalArgumentException("Valor negativo no válido");
                }
                filasValidas += 1;

            } catch (NumberFormatException e) {
                // TODO 5: Atrapa el error si la fila contiene texto o basura en lugar de números.
                // Imprime un mensaje de advertencia e incrementa 'contadorErrores'.
                System.out.println(e.getMessage());
                contadorErrores += 1;

            } catch (IllegalArgumentException e) {
                // TODO 6: Atrapa el error de números negativos que tú mismo lanzaste en el TODO 3.
                // Imprime un mensaje de advertencia con el mensaje de la excepción e incrementa 'contadorErrores'.
                System.out.println(e.getMessage());
                contadorErrores += 1;

            } finally {
                // TODO 7: Auditoría incondicional.
                // Este bloque se ejecuta siempre en cada iteración, haya habido error o no.
                // Imprime "--- Auditoría: Fin de iteración ---"
                System.out.println("----Auditoria: Fin de iteracion---------");
            }
            // TODO 8: Control de tolerancia crítico (Fuera del try-catch, pero dentro del for).
            // Si 'contadorErrores' es MAYOR que 'erroresPermitidos',
            // lanza aquí mismo tu 'UmbralErroresExcedidoException' diciendo "El dataset está demasiado sucio. Abortando.".
            if(contadorErrores > erroresPermitidos){
                throw new UmbralErroresExcedidoException("El dataset esta demasiado sucion. Abortando");
            }
        }

        System.out.println("Limpieza finalizada con éxito. Datos listos para el modelo: " + filasValidas);
    }
    @Override
    public void close() throws Exception {
        System.out.println("Cierre del Programa. ");
    }

    public static void main(String[] args) {
        MotorIngestaDatos motor = new MotorIngestaDatos();

        // Este dataset tiene demasiada basura. Debería causar que el programa aborte a la mitad.
        String[] datasetSucio = {
                "45.5",          // Válido
                "ERROR_SENSOR",  // Falla (NumberFormatException)
                "90.2",          // Válido
                "-10.0",         // Falla (IllegalArgumentException)
                "TEXTO_BASURA",  // Falla (Tercer error: Supera el límite permitido)
                "100.0"          // Nunca debería llegar a leer este dato
        };

        var limpiarDatos = new MotorIngestaDatos();
        try (limpiarDatos){
            limpiarDatos.limpiarDataset(datasetSucio);
        }catch (UmbralErroresExcedidoException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        // TODO 9: Llama al método limpiarDataset(datasetSucio) dentro de un bloque try-catch.
        // Atrapa tu 'UmbralErroresExcedidoException' e imprime su mensaje de forma elegante
        // para que la consola no muestre un texto rojo de error del sistema, sino un cierre controlado.
    }


}