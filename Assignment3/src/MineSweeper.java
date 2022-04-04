import java.util.Scanner;
public class MineSweeper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 0;
        char[][] square = new char[n][n];
        String[] s = new String[n];
        for (int i = 0;i<n;i++){
            s[i] = scan.next();
        }
        for (int i = 0;i<n;i++){
            for (int j = 0;j<n;j++){
                square[i][j] = s[i].charAt(j);
            }
        }
        for (int i = 0;i<n;i++){
            for (int j = 0;j<n;j++){
                if (square[i][j] == '*'){
                    square[i][j] = 'F';
                }
            }
        }
        for (int i = 0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                count = 0;
                if (square[i][j] == '-') {
                    if (i - 1 >= 0 && j - 1 >= 0 && square[i - 1][j - 1] == 'F') {
                        count++;
                    }
                    if (i - 1 >= 0 && square[i - 1][j ] == 'F') {
                        count++;
                    }
                    if (i - 1 >= 0 && j+1<n && square[i - 1][j + 1] == 'F') {
                        count++;
                    }
                    if ( j - 1 >= 0 && square[i][j - 1] == 'F') {
                        count++;
                    }
                    if ( j + 1 < n && square[i][j + 1] == 'F') {
                        count++;
                    }
                    if (i + 1 < n && j - 1 >= 0 && square[i + 1][j - 1] == 'F') {
                        count++;
                    }
                    if (i + 1 < n && square[i+1][j] == 'F') {
                        count++;
                    }
                    if (i + 1 < n && j + 1 < n && square[i + 1][j + 1] == 'F') {
                        count++;
                    }
                    square[i][j] = (char)(count+48);
                }
            }
        }
        for (int i = 0;i<n;i++){
            for (int j = 0;j<n;j++){
                System.out.print(square[i][j]);
            }
            System.out.println();
        }
        }
    }