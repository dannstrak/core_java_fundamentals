package Capitulo_06_Interfaces_Lambda_Expresions_and_Inner_Classes.Exercise_10_Inner_Classes;

public class SesionEntrenamiento {
    private String grupoMuscular;
    private double volumenTotalKg; // Se debe actualizar automáticamente

    public SesionEntrenamiento(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
        this.volumenTotalKg = 0.0;
    }

    public double getVolumenTotal() {
        return volumenTotalKg;
    }

    // --- TU RETO EMPIEZA AQUÍ ---
    // Crea una Inner Class (NO estática) llamada 'Serie'
    // Debe tener dos atributos privados: double peso, int repeticiones
    // En su constructor, debe:
    // 1. Asignar el peso y repeticiones.
    // 2. Sumar el cálculo (peso * repeticiones) directamente al 'volumenTotalKg' de la clase externa.
    // 3. Imprimir: "Registrado: [repeticiones]x[peso]kg para [grupoMuscular]"

    // TODO: Escribe la clase interna Serie aquí

    class Serie{
        private double peso;
        private int repeteciones;
        // Constructor.
        Serie(double peso, int repeteciones){
            this.peso = peso;
            this.repeteciones = repeteciones;
            // 2.
            SesionEntrenamiento.this.volumenTotalKg += (peso * repeteciones);
            System.out.println("Registrado: " + repeteciones + "x" + peso + "kg para " + SesionEntrenamiento.this.grupoMuscular);
        }

    }

    public static void main(String[] args) {
        SesionEntrenamiento sesion = new SesionEntrenamiento("Espalda y Bíceps");

        // TODO: Instancia 3 series utilizando la sintaxis correcta para Inner Classes
        // Serie 1: 80.0 kg, 10 reps
        // Serie 2: 85.0 kg, 8 reps
        // Serie 3: 90.0 kg, 6 reps
        SesionEntrenamiento.Serie Serie01 = sesion.new Serie(80.0, 10);
        SesionEntrenamiento.Serie Serie02 = sesion.new Serie(85.0, 8);
        SesionEntrenamiento.Serie Serie03 = sesion.new Serie(90.0, 6);

        // Prueba de fuego: El volumen total debe ser automáticamente 2020.0 kg
        System.out.println("Volumen total de la sesión: " + sesion.getVolumenTotal() + " kg");
    }
}