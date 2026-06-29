import java.util.Stack;

public class RemoteControl {

    private Command currentCommand;

    // Stack to keep history of commands for undo
    private Stack<Command> commandHistory = new Stack<>();

    // Set command to a specific slot
    public void setCommand(Command command) {
        this.currentCommand = command;
    }

    // Press button — execute current command
    public void pressButton() {
        if (currentCommand != null) {
            currentCommand.execute();
            commandHistory.push(currentCommand);
        } else {
            System.out.println("[REMOTE] No command assigned!");
        }
    }

    // Press undo button — undo last command
    public void pressUndo() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            System.out.println("[REMOTE] Undoing last command...");
            lastCommand.undo();
        } else {
            System.out.println("[REMOTE] Nothing to undo!");
        }
    }

    // Show history count
    public void showHistory() {
        System.out.println("[REMOTE] Commands in history: " +
                           commandHistory.size());
    }
}