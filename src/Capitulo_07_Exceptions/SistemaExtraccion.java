package Capitulo_07_Exceptions;

// 1. Excepciones Chequeadas (Checked Exceptions) Personalizadas
class ServidorCaidoException extends Exception {
    public ServidorCaidoException(String mensaje) { super(mensaje); }
}

class ArchivoCorruptoException extends Exception {
    public ArchivoCorruptoException(String mensaje) { super(mensaje); }
}

// 2. Simulador de la conexión (El recurso que debemos cuidar)
class ConexionAPI {
    private String id;

    public ConexionAPI(String id) {
        this.id = id;
        System.out.println("\n[+] Abriendo conexión API-" + id + "...");
    }

    // Este método es inestable. Puede lanzar dos tipos de errores distintos.
    public void descargarDataset(String estadoSimulado) throws ServidorCaidoException, ArchivoCorruptoException {
        System.out.println("Intentando descargar dataset...");

        if (estadoSimulado.equals("ERROR_RED")) {
            throw new ServidorCaidoException("Fallo de ping. El servidor no responde.");
        }
        else if (estadoSimulado.equals("ERROR_DATOS")) {
            throw new ArchivoCorruptoException("El archivo JSON está incompleto o corrupto.");
        }

        System.out.println("¡Descarga exitosa del dataset!");
    }

    // Este método SIEMPRE debe ejecutarse para no dejar la memoria ocupada
    public void desconectar() {
        System.out.println("[-] Conexión API-" + id + " cerrada de forma segura.");
    }
}

// 3. Clase Principal
public class SistemaExtraccion {

    public void procesarLote(String estadoSimulado) {
        ConexionAPI conexion = new ConexionAPI("109-X");

        // --- TU RETO EMPIEZA AQUÍ ---
        // Arquitectura requerida:
        // 1. Crea un bloque try externo.
        // 2. DENTRO de ese bloque try, crea un SEGUNDO bloque try-finally.
        // 3. En el try interno, llama a conexion.descargarDataset(estadoSimulado).
        // 4. En el finally interno, asegúrate de llamar a conexion.desconectar().
        // 5. En el catch externo, utiliza MULTI-CATCH para atrapar tanto
        //    ServidorCaidoException como ArchivoCorruptoException en la MISMA LÍNEA.
        // 6. Dentro del catch, imprime: "Alerta en el Pipeline: " + e.getMessage()
        // 7. Añade un último catch genérico (Exception e) por si ocurre un error inesperado,
        //    imprimiendo "Error crítico desconocido".

        // TODO: Escribe la arquitectura de excepciones aquí
        try {
            try{
                conexion.descargarDataset(estadoSimulado);
            }finally {
                conexion.desconectar();
            }
        }
        catch (ServidorCaidoException | ArchivoCorruptoException e){
            System.err.println("Alerta en el PipeLine: " + e.getMessage());
        }catch (Exception e) {
            System.err.println("Error Critico Desconocodigo");
        }
        // --- TU RETO TERMINA AQUÍ ---
    }

    public static void main(String[] args) {
        SistemaExtraccion sistema = new SistemaExtraccion();

        // Prueba 1: Todo funciona bien
        sistema.procesarLote("EXITO");

        // Prueba 2: Falla la red (Debe atraparse en el multi-catch, pero la conexión DEBE cerrarse)
        sistema.procesarLote("ERROR_RED");

        // Prueba 3: Falla el formato (Debe atraparse en el mismo multi-catch, y la conexión DEBE cerrarse)
        sistema.procesarLote("ERROR_DATOS");
    }
}