import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class Person {
    String id;
    String name;
    Map<CourseTime, Course> schedule = new HashMap<>();

    public Person(){}
    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(schedule, person.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, schedule);
    }
}
