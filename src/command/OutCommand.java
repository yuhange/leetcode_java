package command;

/**
 * Created by lenovo on 2017/3/19.
 */
public class OutCommand implements Command{

    Account account;
    int total;

    public OutCommand(Account account, int total) {
        this.account = account;
        this.total = total;
    }

    @Override
    public void execute() {
        account.withDraw(total);
    }

    @Override
    public boolean undo() {
        account.dropIn(total);
        return true;
    }
}
