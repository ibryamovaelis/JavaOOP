package MilitaryElite;

public class SpyImpl extends SoldierImpl {
    private String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d%n" +
                "Code Number: %s%n", this.getFirstName(), this.getLastName(), this.getId(), this.codeNumber);
    }
}
