import java.util.Scanner;
public class Kaleidoscope {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt();
        int N = scan.nextInt();
        int[][] arr1 = new int[M][N];
        int[][] arr2 = new int[2 * M][2 * N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr1[i][j] = scan.nextInt();
                arr2[i][j] = arr1[i][j];
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = N; j < 2 * N; j++) {
                arr2[i][j] = arr2[i][2*N-1-j];
            }
        }
        for (int i = M;i<2*M;i++){
            for (int j = 0;j<2*N;j++){
                arr2[i][j] = arr2[2*M-1-i][j];
            }
        }
        for (int i = 0;i<2*M;i++){
            for (int j = 0;j<2*N;j++){
                System.out.print(arr2[i][j]+" ");
            }
            System.out.println();
        }
    }
}
