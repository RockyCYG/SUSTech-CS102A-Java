import java.util.Scanner;
public class Lunch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x=scan.nextInt();
        int y=scan.nextInt();
        String instruct;
        do {
            instruct = scan.next();

            if (instruct.equals("a")){
                x--;
            }else if(instruct.equals("w")){
                y++;
            }else if(instruct.equals("s")){
                y--;
            }else if (instruct.equals("d")){
                x++;
            }
        }
        while (!instruct.equals("E"));

        System.out.println(x+" "+y);
        }
    }
