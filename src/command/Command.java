package command;

/**
 * Created by lenovo on 2017/3/19.
 */
public interface Command {
    public void execute();
    public boolean undo();
}
