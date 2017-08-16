package strategy;

        import java.util.HashSet;
        import java.util.Set;

/**
 * Created by lenovo on 2017/3/13.
 */
public class Test {
    public static void main(String[] args) {
        People student = new People(new ByNotebook());
        People teacher = new People(new ByTablet());
        People officer = new People(new ByComputer());
        student.record();
        teacher.record();
        officer.record();

    }
}
