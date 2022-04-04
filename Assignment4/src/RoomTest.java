public class RoomTest {
    public static void main(String[] args) {
        Room r = new Room("R101",Library.Lynn,3);
        System.out.println(r.toString());
        System.out.println(r.toString(8,16));
        System.out.println(r.setApplicant(16,18,"12222222",2));
        System.out.println(r.removeApplicant("12011111"));
        System.out.println(r.setApplicant(8,10,"12011625",2));
    }
}
