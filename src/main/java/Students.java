import java.util.ArrayList;
import java.util.List;

public class Students {

    private final List<String> students;

    public Students() {
        this.students = new ArrayList<>();
    }

    public List<String> getStudents() {
        return students;
    }

    public void add(String name) {
        this.students.add(name);
    }

    public int studentsCount() {
        return this.students.size();
    }
}
