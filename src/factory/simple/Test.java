package factory.simple;

/**
 * Created by lenovo on 2017/3/16.
 */
public class Test {
    public static void main(String[] args) {
        Operation operation = OperationFactory.getOperation(1);
        System.out.println(operation.operation(1,2));
    }
}
