package factory.simple;

/**
 * Created by lenovo on 2017/3/16.
 */
public class OperationFactory {
    public static Operation getOperation(int flag) {
        switch(flag) {
            case 1:
                return new OperationA();
            case 2:
                return new OperationB();
            default:
                return new Operation();
        }
    }
}
