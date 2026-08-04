package Capitulo_06_Interfaces_Lambda_Expresions_and_Inner_Classes.Integrative_Project_01;

import java.util.ArrayList;
import java.util.List;

public class SistemaJuez {
    // Instance Fields.

    private List<EnvioCodigo> listaEnvio = new ArrayList<>();

    public void registrarEnvio(EnvioCodigo envio){
        listaEnvio.add(envio);
    }

    // Importante
    public void auditar(int limiteTiempo){
        class AuditorInterno{
            // Creamos una Local Inner Class.
            void revisar(){
                for(EnvioCodigo elemento: SistemaJuez.this.listaEnvio){
                    if(elemento.tiempoEjecucion > limiteTiempo){
                        System.out.println("ALERTA:"+ elemento+"excedió el tiempo");
                    }
                }
            }
        }
        // Primero instanciamos un objeto de la clase que creamos.
        AuditorInterno auditor = new AuditorInterno();
        // Luego utilizamos su metodo que debe ser del mismo tipo que el metodo encapsulador.
        auditor.revisar();
    }

    public List<EnvioCodigo> sistemaJuez(){
        return listaEnvio;
    }


    // InnerClass.
    class EnvioCodigo{
        // Instance Fields.
        private String participante;
        public int tiempoEjecucion;
        private int bugs;
        private EstrategiaPuntuacion estrategiaPuntuacion;
        // Constructor.
        EnvioCodigo (String participante, int tiempoEjecucion, int bugs, EstrategiaPuntuacion estrategiaPuntuacion){
            this.participante = participante;
            this.tiempoEjecucion = tiempoEjecucion;
            this.bugs = bugs;
            this.estrategiaPuntuacion = estrategiaPuntuacion;
        }
        public int getTiempoEjecucion(){
            return this.tiempoEjecucion;
        }
        // Metodo para imprimr los datos de envio.
        void mostrarInfo(){
            System.out.printf("""
                    ------ Datos de envio --------
                    Participante: %s .
                    Tiempo de ejecucion: %d
                    Bugs : %d .                
                    """, this.participante, this.tiempoEjecucion, this.bugs );
        }
    }


    public static void main(String[] args) {
        var penalizacionPorBug = 5;
        EstrategiaPuntuacion estrategiaPuntuacion = (int tiempoEjecucion, int bugs)->{
            var resultado =(100-tiempoEjecucion)-(bugs*penalizacionPorBug);
            return resultado;
        };
        /*
        Como penalizacionPorBug es una variable, entonces en un lambda podemos acceder
        desde el metodo que contiene al lambda, siempre y cuando esta sea effectively final
        es decir que su valor no cambie a pesar de no se declarada como FINAl.
         */

        // Creamos objetos de EnvioCodigo.
        var sistemaJuez01 = new SistemaJuez();
        SistemaJuez.EnvioCodigo envioCodigo01 = sistemaJuez01.new EnvioCodigo("Alejandro", 100,2, estrategiaPuntuacion);
        SistemaJuez.EnvioCodigo envioCodigo02 = sistemaJuez01.new EnvioCodigo("Jacob", 500, 1, estrategiaPuntuacion);
        sistemaJuez01.registrarEnvio(envioCodigo01);
        sistemaJuez01.registrarEnvio(envioCodigo02);
    }
}


class Diploma{
    Diploma(SistemaJuez.EnvioCodigo envioParticipante){
        System.out.println("Generando diploma en PDF para: "+ envioParticipante);
    }
}