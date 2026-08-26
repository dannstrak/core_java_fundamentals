public class ZeroMatrix {
    public static void zeroMatrix (int[][] matrizOriginal){
        boolean[] filas = new boolean[matrizOriginal.length];
        boolean[] columnas = new boolean[matrizOriginal[0].length];

        for (int i = 0; i < matrizOriginal.length; i++){
            for (int j = 0; j < matrizOriginal[0].length; j++){
                if (matrizOriginal[i][j] == 0){
                    filas[i] = true;
                    columnas[j] = true;
                }
            }
        }
        for (int k = 0; k < matrizOriginal.length; k++){
            for (int l = 0; l<matrizOriginal[0].length; l++){
                if(filas[k] || columnas[l]){
                    matrizOriginal[k][l] = 0;
                }
            }
        }

        for (int m = 0; m < matrizOriginal.length; m++){
            for (int n = 0; n < matrizOriginal[0].length; n++){
                System.out.print(matrizOriginal[m][n] + " ");
            }
            System.out.println();
        }
    }

    static void main(String[] args) {
        int[][] prueba = {
                {1, 2, 3, 0},
                {4, 5, 6, 1},
        };
        zeroMatrix(prueba);
    }
}
