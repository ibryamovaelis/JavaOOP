package word;

public class Initialization {

    static CommandImplementation buildCommandInterface(StringBuilder text) {
        return new CommandImplementation(text);
    }
}
