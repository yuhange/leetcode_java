package command;

/**
 * Created by lenovo on 2017/3/19.
 */
public class InCommand implements Command {

    private Account account;
    private int total;

    public InCommand(Account account, int total) {
        this.account = account;
        this.total = total;
    }

    @Override
    public void execute() {
        account.dropIn(total);
    }

    @Override
    public boolean undo() {
        account.withDraw(total);
        return true;
    }
}
