import java.util.Scanner;
public class WinTheGoBang {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[][] arr = new String[n][n];
        boolean isFlag = true;
        int count;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scan.next();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count = 1;
                if (arr[i][j].equals("N")) {
                    for (int a = 1; a <= 4; a++) {
                        if (i + a < n && arr[i + a][j].equals("O")) {
                            count++;
                        } else break;

                    }
                    for (int b = 1; b <= 4; b++) {
                        if (i - b >= 0 && arr[i - b][j].equals("O")) {
                            count++;
                        } else break;
                    }
                    if (count >= 5) {
                        isFlag = false;
                        System.out.println("(" + (j + 1) + "," + (i + 1) + ")");
                    } else {
                        count = 1;
                        for (int a = 1; a <= 4; a++) {
                            if (j - a >= 0 && arr[i][j - a].equals("O")) {
                                count++;
                            } else break;
                        }
                        for (int b = 1; b <= 4; b++) {
                            if (j + b < n && arr[i][j + b].equals("O")) {
                                count++;
                            } else break;
                        }
                        if (count >= 5) {
                            isFlag = false;
                            System.out.println("(" + (j + 1) + "," + (i + 1) + ")");
                        } else {
                            count = 1;
                            for (int a = 1; a <= 4; a++) {
                                if (i - a >= 0 && j - a >= 0 && arr[i - a][j - a].equals("O")) {
                                    count++;
                                } else break;
                            }
                            for (int b = 1; b <= 4; b++) {
                                if (i + b < n && j + b < n && arr[i + b][j + b].equals("O")) {
                                    count++;
                                } else break;
                            }
                            if (count >= 5) {
                                isFlag = false;
                                System.out.println("(" + (j + 1) + "," + (i + 1) + ")");
                            } else {
                                count = 1;
                                for (int a = 1; a <= 4; a++) {
                                    if (i + a < n && j - a >= 0 && arr[i + a][j - a].equals("O")) {
                                        count++;
                                    } else break;
                                }
                                for (int b = 1; b <= 4; b++) {
                                    if (i - b >= 0 && j + b < n && arr[i - b][j + b].equals("O")) {
                                        count++;
                                    } else break;
                                }
                                if (count >= 5) {
                                    isFlag = false;
                                    System.out.println("(" + (j + 1) + "," + (i + 1) + ")");
                                }
                            }
                        }
                    }
                }
            }
        }
        if (isFlag){
            System.out.println("No");
        }
    }
}