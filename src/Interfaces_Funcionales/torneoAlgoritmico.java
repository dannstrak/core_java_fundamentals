package Interfaces_Funcionales;

public class torneoAlgoritmico {

    static class Participante {
        private String nombre;
        private int puntaje;
        private boolean resolvioProblemaAvanzado;

        public Participante(String nombre, int puntaje, boolean resolvioProblemaAvanzado) {
            this.nombre = nombre;
            this.puntaje = puntaje;
            this.resolvioProblemaAvanzado = resolvioProblemaAvanzado;
        }

        public String getNombre() { return nombre; }
        public int getPuntaje() { return puntaje; }
        public boolean isResolvioProblemaAvanzado() { return resolvioProblemaAvanzado; }

        @Override
        public String toString() {
            return nombre + " - Pts: " + puntaje;
        }
    }
}