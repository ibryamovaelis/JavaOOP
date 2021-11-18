package MilitaryElite;

public class Mission {
    private String codeName;
    private State state;

    public Mission(String codeName, State state) {
        this.codeName = codeName;
        this.state = state;
    }

    public void completeMission() {
        this.state = State.finished;
    }
    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s%n", this.codeName, this.state.toString());
    }
}
