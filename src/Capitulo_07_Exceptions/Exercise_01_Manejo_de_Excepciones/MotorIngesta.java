package Capitulo_07_Exceptions.Exercise_01_Manejo_de_Excepciones;

class RegistroPerdidoException extends Throwable{
    public RegistroPerdidoException(String mensaje){
        super(mensaje);
    }
    public RegistroPerdidoException(){
        super();
    }
}
class FormatoInvalidoException extends RuntimeException{
    public FormatoInvalidoException(String mensaje){
        super(mensaje);
    }
}

class FalloCriticoPipelineException extends Throwable{
    public FalloCriticoPipelineException(String mensaje){
        super(mensaje);
    }
    public FalloCriticoPipelineException(){
        super();
    }
}

// Diseno de recursos.
class LectorCSV implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("Archivo CSV cerrado y memoria Liberada");
    }
    public void leerFila(int numeroFila) throws RegistroPerdidoException{
        if(numeroFila < 0){
            throw new RegistroPerdidoException("Fila no Existe");
        }
        else if (numeroFila > 1000){
            throw new FormatoInvalidoException("Desbordamiento de Datos");
        }else{
            System.out.println("Fila leida Correctamente. ");
        }
    }
}

public class MotorIngesta {
    public void procesarFila(int fila) throws FalloCriticoPipelineException, Exception {
        var leerFila = new LectorCSV();
        try(leerFila){
            leerFila.leerFila(fila);
        } catch (RegistroPerdidoException e) {
            var newException = new FalloCriticoPipelineException("Fallo Critico Pipeline");
            newException.initCause(e);
            throw newException;
        }
    }

    static void main() {
        var LectorCSV = new MotorIngesta();
        try{
            LectorCSV.procesarFila(-5);
        }catch (FalloCriticoPipelineException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
