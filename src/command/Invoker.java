package command;

/**
 * Created by lenovo on 2017/3/19.
 */
public class Invoker {
    private Command command;
    public Invoker(){}
    public void setCommand(Command command){
        this.command = command;
    }
    public void executeCommand() {
        this.command.execute();
    }
    public void undoCommand() {
        this.command.undo();
    }
}
