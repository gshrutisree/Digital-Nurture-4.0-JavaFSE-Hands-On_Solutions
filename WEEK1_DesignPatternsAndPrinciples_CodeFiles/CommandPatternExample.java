interface Command {
    void execute();
}
class Light {
    public void on() {
        System.out.println("Light is ON");
    }
    public void off() {
        System.out.println("Light is OFF");
    }
}
class LightOnCommand implements Command {
    Light lgt;
    LightOnCommand(Light lgt) {
        this.lgt = lgt;
    }
    public void execute() {
        lgt.on();
    }
}
class LightOffCommand implements Command {
    Light lgt;
    LightOffCommand(Light lgt) {
        this.lgt = lgt;
    }
    public void execute() {
        lgt.off();
    }
}
class RemoteControl {
    Command cmd;
    void setCommand(Command cmd) {
        this.cmd = cmd;
    }
    void pressButton() {
        cmd.execute();
    }
}
public class CommandPatternExample {
    public static void main(String[] args) {
        Light lgt = new Light();

        Command onCmd = new LightOnCommand(lgt);
        Command offCmd = new LightOffCommand(lgt);

        RemoteControl rmt = new RemoteControl();

        rmt.setCommand(onCmd);
        rmt.pressButton();

        rmt.setCommand(offCmd);
        rmt.pressButton();
    }
}
