package Capitulo_06_Interfaces_Lambda_Expresions_and_Inner_Classes.Method_y_Constructor_References;

class Mensaje {
    String texto;

    public Mensaje(String texto) {
        this.texto = texto;
    }

    public void imprimir() {
        System.out.println(texto);
    }
}

public class Exercise_05_Method_and_Constructor_References {
    // Interfaz funcional propia del Capítulo 6
    interface Creador {
        Mensaje crear(String t);
    }

    public static void main(String[] args) {

        // RETO 1: Reemplaza esta lambda por un Constructor Reference (::new)
        // Pista: Piensa en la clase que quieres instanciar.
        // Creador creador = (texto) -> new Mensaje(texto);

        Creador creador = Mensaje::new; // Constructor Reference.

        Mensaje msj = creador.crear("Probando referencias");

        // RETO 2: Reemplaza esta lambda por un Method Reference apuntando a un objeto
        // Pista: Apunta al método 'imprimir' del objeto 'msj'
        // Runnable accion = () -> msj.imprimir();
        Runnable accion = msj::imprimir;

        accion.run();
    }
}