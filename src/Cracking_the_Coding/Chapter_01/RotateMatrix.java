package Cracking_the_Coding.Chapter_01;

public class RotateMatrix {
    public static void rotateMatrix (int[][] matrizOriginal) {
        int n = matrizOriginal.length;
        for(int i = 0; i<n; i++){
            for (int j = i; j<n; j++){
                if (i!=j) {
                    int value = matrizOriginal[i][j];
                    matrizOriginal[i][j] = matrizOriginal[j][i];
                    matrizOriginal[j][i] = value;
                    value = 0;
                }
            }
        }
        for (int k = 0; k<n; k++){
            int derecha = n -1 ;
            int izquierda = 0;
            while (izquierda != derecha){
                int value = matrizOriginal[k][izquierda];
                matrizOriginal[k][izquierda] = matrizOriginal[k][derecha] ;
                matrizOriginal[k][derecha] = value;
                izquierda++;
                derecha--;
            }
        }
    }

    static void main(String[] args) {
        int[][] prueba = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotateMatrix(prueba);
        for (int i = 0; i < prueba.length; i++) {
            for (int j = 0; j < prueba[i].length; j++) {
                System.out.print(prueba[i][j] + " ");
            }
            System.out.println();
        }
    }
}
