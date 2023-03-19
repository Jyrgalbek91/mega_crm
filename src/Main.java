import service.CommandService;
import service.impl.CommandServiceImpl;

public class Main {
    public static void main(String[] args) {
        CommandService commandService = new CommandServiceImpl();
        commandService.run();

    }
}