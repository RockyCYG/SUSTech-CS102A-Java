import java.util.Objects;


public class CourseTime {
    private Day day;
    private int time;

    public CourseTime() {
    }

    public CourseTime( Day day , int time ) {
        this.day = day;
        this.time = time;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass( ) != o.getClass( ) ) return false;
        CourseTime that = (CourseTime) o;
        return time == that.time && day == that.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash( day , time );
    }
}
