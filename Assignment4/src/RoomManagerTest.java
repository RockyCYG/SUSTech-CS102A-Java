import java.util.ArrayList;
public class RoomManagerTest {
    public static void main(String[] args) {
        RoomManager r = new RoomManager();
        System.out.println(RoomManager.addRoom("R101",Library.Lynn,3));
        System.out.println(RoomManager.addRoom("R101",Library.Yidan,3));
        System.out.println(RoomManager.addRoom("R101",Library.LearningNexus,3));
        System.out.println(RoomManager.addRoom("R999",Library.Lynn,3));
        System.out.println(RoomManager.addRoom("R999",Library.LearningNexus,3));
        System.out.println(RoomManager.addRoom("R666",Library.Lynn,3));
        System.out.println(RoomManager.addRoom("R888",Library.Yidan,3));

        System.out.println(RoomManager.orderRoom(Library.Yidan,"R101","10101010",8,10,2));
        System.out.println(RoomManager.orderRoom(Library.Lynn,"R101","10101010",9,11,1));
        System.out.println(RoomManager.orderRoom(Library.LearningNexus,"R101","10101010",15,16,2));
        System.out.println(RoomManager.orderRoom(Library.Lynn,"R101","10111111",17,18,2));
        System.out.println(RoomManager.orderRoom(Library.Lynn,"R101","10101010",21,22,2));
        System.out.println(RoomManager.orderRoom(Library.Lynn,"R999","10101010",9,10,2));
        System.out.println(RoomManager.showOrder(RoomManager.searchRoom(13,15)));
        System.out.println(RoomManager.showOrder(RoomManager.searchRoom(8,11,Landmark.TaizhouFloor)));
    }
}
