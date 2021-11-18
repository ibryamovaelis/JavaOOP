package MilitaryElite;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class EngineerImpl extends SpecialisedSoldierImpl {
    private Set<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new LinkedHashSet<>();
    }

    public void addRepair(Repair repair) {
        repairs.add(repair);
    }

    public Collection<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Name: %s %s Id: %d Salary: %.2f%n", this.getFirstName(), this.getLastName(), this.getId(), this.getSalary()));
        output.append("Corps: ").append(this.getCorps().toString()).append(System.lineSeparator());
        output.append("Repairs:").append(System.lineSeparator());
        for (Repair repair : getRepairs()) {
            output.append("  ")
                    .append(repair.toString());
        }
        return output.toString();
    }
}
