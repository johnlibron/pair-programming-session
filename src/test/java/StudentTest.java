import org.junit.Test;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

public class StudentTest {

    @Test
    public void shouldAddOneStudent() {
        Students students = new Students();
        students.add("John");
//        assertEquals(1, students.studentsCount());
        assertThat(students.getStudents(), hasItems("John"));
    }
}
