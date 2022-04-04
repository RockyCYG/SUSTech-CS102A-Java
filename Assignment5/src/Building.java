import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Building {
    private List<Classroom> rooms = new ArrayList<>();
    private Location location;
    private int id;
    public Building(){
    }

    public Building(Location location, int id) {
        this.location = location;
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public int getId() {
        return id;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setId(int number) {
        this.id = number;
    }

    public List<Classroom> getRooms() {
        return rooms;
    }

    public void setRooms(List<Classroom> rooms) {
        this.rooms = rooms;
    }

    public boolean addRoom(Classroom room ) {
        if (rooms.contains(room)){
            return false;
        }
        if (room.building.equals(this)){
            rooms.add(room);
            return true;
        }
        return false;
    }
    public boolean deleteRoom( Classroom room ) {
        if (rooms.contains(room)){
            rooms.remove(room);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        switch (location) {
            case LycheePark:
                return "LP#" + id;
            case TeachingBuilding:
                return "TB#" + id;
            default:
                return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return id == building.id && Objects.equals(rooms, building.rooms) && location == building.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rooms, location, id);
    }
}
