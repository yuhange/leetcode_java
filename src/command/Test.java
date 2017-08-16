package command;

/**
 * Created by lenovo on 2017/3/19.
 */
public class Test {
    public static void main(String[] args) {
        Account account = new Account(1000);
        System.out.println(account.getMoney());
        Invoker invoker = new Invoker();
        Command c1 = new InCommand(account, 20000);
        invoker.setCommand(c1);
        invoker.executeCommand();
        System.out.println(account.getMoney());
        invoker.undoCommand();
        System.out.println(account.getMoney());

        Command c2 = new OutCommand(account,23);
        invoker.setCommand(c2);
        invoker.executeCommand();
        System.out.println(account.getMoney());
    }
}
