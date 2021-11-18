package MilitaryElite;

import java.util.*;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private Map<Integer, PrivateImpl> privateMap;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privateMap = new LinkedHashMap<>();
    }

    public void addPrivate(PrivateImpl priv){
        privateMap.put(priv.getId(), priv);
    }

    public Map<Integer, PrivateImpl> getPrivates() {
        return this.privateMap;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Name: %s %s Id: %d Salary: %.2f%n", this.getFirstName(), this.getLastName(), this.getId(), this.getSalary()));
        output.append("Privates:").append(System.lineSeparator());
        privateMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()));

        for (PrivateImpl priv : getPrivates().values()) {
            output.append("  ")
                    .append(priv.toString());
        }
        return output.toString();
    }
}
