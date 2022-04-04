import java.util.Scanner;
public class User {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        long id = scan.nextLong();
        if (11500000<=id && id<12100000){
            System.out.println(name + ", welcome to Baoneng city!");
        }else{
            System.out.println(id);
        }
    }
}
