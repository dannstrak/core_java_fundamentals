package Capitulo_07_Exceptions.Exercise_02_Manejo_de_Excepciones_e_Interfaces_Funcionales;

// 1. TUS EXCEPCIONES PERSONALIZADAS
// TODO: Crea 'ConexionEscanerCaidaException' (Chequeada, hereda de Exception)
// TODO: Crea 'DatasetCorruptoException' (Chequeada, hereda de Exception)
// TODO: Crea 'FalloAnalisisGeneralException' (Chequeada, hereda de Exception).
//       - Asegúrate de darle un constructor que reciba (String mensaje, Throwable causa) para el Chaining.

class ConexionEscanerCaidaException extends Exception{
    public ConexionEscanerCaidaException(String mensaje, Throwable cause){
        super(mensaje, cause);
    }
    public ConexionEscanerCaidaException(String mensaje){
        super(mensaje);
    }
}

class DatasetCorruptoException extends Exception{
    public DatasetCorruptoException(String mensaje, Throwable causa){
        super(mensaje, causa);
    }
    public DatasetCorruptoException(String mensaje){
        super(mensaje);
    }
}

class FalloAnalisisGeneralException extends Exception{
    public FalloAnalisisGeneralException (String mensaje, Throwable cause){
        super(mensaje, cause);
    }
    public FalloAnalisisGeneralException(String mensaje){
        super(mensaje);
    }
}

// 2. RECURSOS DEL SISTEMA (No modificar)
class MotorMatlab implements AutoCloseable {
    public MotorMatlab() { System.out.println("[MATLAB] Iniciando motor de procesamiento matricial..."); }
    @Override
    public void close() { System.out.println("[-] MATLAB apagado y memoria liberada."); }
}

class LectorResonancia implements AutoCloseable {
    public LectorResonancia() { System.out.println("[MRI] Conectando a máquina de resonancia..."); }

    public void leerDatos(String estadoSimulado) throws ConexionEscanerCaidaException, DatasetCorruptoException {
        if (estadoSimulado.equals("DESCONEXION")) {
            throw new ConexionEscanerCaidaException("El cable de red del escáner se desconectó de repente.");
        }
        if (estadoSimulado.equals("RUIDO")) {
            throw new DatasetCorruptoException("Las imágenes DICOM tienen demasiado ruido electromagnético.");
        }
        System.out.println("[+] Datos médicos extraídos con éxito al dataset.");
    }

    @Override
    public void close() { System.out.println("[-] MRI desconectado de forma segura."); }
}

// 3. LA INTERFAZ DEL LABORATORIO (No modificar)
interface ProcesadorMedico {
    // REGLA DEL CONTRATO: El padre dicta que solo puedes lanzar ESTA excepción.
    void ejecutarProcesamiento(String estado) throws FalloAnalisisGeneralException;
}

// 4. TU IMPLEMENTACIÓN
public class Laboratorio implements ProcesadorMedico {

    // TODO: Sobrescribe el método 'ejecutarProcesamiento' de la interfaz.
    // Reglas arquitectónicas estrictas:
    // 1. No olvides la anotación @Override.
    // 2. Debes instanciar MotorMatlab y LectorResonancia en un SOLO bloque try-with-resources.
    //    (Pista de sintaxis: Puedes declarar múltiples recursos separándolos con un punto y coma ';'
    //    dentro de los paréntesis del try).
    // 3. Dentro del try, llama a 'lector.leerDatos(estado)'.
    // 4. Usa un MULTI-CATCH para atrapar ConexionEscanerCaidaException y DatasetCorruptoException en la MISMA línea.
    // 5. Dentro de ese catch, lanza un nuevo FalloAnalisisGeneralException ("Abortando análisis"),
    //    encadenando el error original para no perder la información.

    // ESCRIBE TU CÓDIGO AQUÍ:

    @Override
    public void ejecutarProcesamiento(String estado) throws FalloAnalisisGeneralException {
        try(MotorMatlab motorMatlab = new MotorMatlab() ; LectorResonancia lector = new LectorResonancia()){
            lector.leerDatos(estado);
        }catch (ConexionEscanerCaidaException | DatasetCorruptoException e){
            throw new FalloAnalisisGeneralException("Abortando analisis", e);
        }
    }

    // -------------------------

    public static void main(String[] args) {
        Laboratorio lab = new Laboratorio();

        System.out.println("--- PRUEBA 1: DATASET PERFECTO ---");
        try {
            lab.ejecutarProcesamiento("NORMAL");
        } catch (FalloAnalisisGeneralException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n--- PRUEBA 2: DESCONEXIÓN DE RED ---");
        try {
            lab.ejecutarProcesamiento("DESCONEXION");
        } catch (FalloAnalisisGeneralException e) {
            System.out.println("Fallo Atrapado: " + e.getMessage());
            System.out.println("Causa Real (Chaining): " + e.getCause().getMessage());
        }

        System.out.println("\n--- PRUEBA 3: IMÁGENES CORRUPTAS ---");
        try {
            lab.ejecutarProcesamiento("RUIDO");
        } catch (FalloAnalisisGeneralException e) {
            System.out.println("Fallo Atrapado: " + e.getMessage());
            System.out.println("Causa Real (Chaining): " + e.getCause().getMessage());
        }
    }
}