import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {
    static int idCnt = 0;
    int id ;
    String name;
    String abbrevName;
    String code;
    CourseTime time = new CourseTime();
    Teacher teacher = new Teacher();
    Classroom room = new Classroom();
    List<Student> students = new ArrayList<>();
    int capacity;
    CourseType type;
    public Course( String code , String name , String abbrevName , Teacher teacher , int capacity , CourseType type ){
        this.code = code;
        this.name = name;
        this.abbrevName = abbrevName;
        this.teacher = teacher;
        this.capacity = capacity;
        this.type = type;
        idCnt++ ;
        this.id = idCnt;
    }
    public Course( String code , String name , String abbrevName , Teacher teacher , int capacity , CourseType type, CourseTime time , Classroom room){
        this.code = code;
        this.name = name;
        this.abbrevName = abbrevName;
        this.teacher = teacher;
        this.capacity = capacity;
        this.type = type;
        this.time = time;
        this.room = room;
        idCnt++ ;
        this.id = idCnt;
    }

    public String getAbbrevName() {
        String abbreviation = "";
        if (abbrevName.equals("")){
            for (int i = 0;i<name.length();i++){
                if (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z'){
                    abbreviation += String.valueOf(name.charAt(i));
                }
            }
            return abbreviation;
        }
        return abbrevName;
    }

    public void setAbbrevName(String abbrevName) {
        this.abbrevName = abbrevName;
    }
    public void setAbbrevName() { }
    public CourseTime getTime() {
        return time;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public Classroom getRoom() {
        return room;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public static int getIdCnt() {
        return idCnt;
    }

    public static void setIdCnt(int idCnt) {
        Course.idCnt = idCnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTime(CourseTime time) {
        this.time = time;
    }

    public void setRoom(Classroom room) {
        this.room = room;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public CourseType getType() {
        return type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    public void setRoomTime(Classroom room, CourseTime time) {
        this.room = room;
        this.time = time;
    }

    public boolean addStudent(Student student){
        if (students.contains(student)){
            return false;
        }
        students.add(student);
        return true;
    }

    public boolean deleteStudent (Student student){
        if (students.contains(student)){
            students.remove(student);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && capacity == course.capacity && Objects.equals(name, course.name) && Objects.equals(abbrevName, course.abbrevName) && Objects.equals(code, course.code) && Objects.equals(time, course.time) && Objects.equals(teacher, course.teacher) && Objects.equals(room, course.room) && Objects.equals(students, course.students) && type == course.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, abbrevName, code, time, teacher, room, students, capacity, type);
    }
}


