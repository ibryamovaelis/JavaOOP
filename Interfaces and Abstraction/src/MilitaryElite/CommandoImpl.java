package MilitaryElite;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class CommandoImpl extends SpecialisedSoldierImpl {
    private Set<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedHashSet<>();
    }

    public void addMission(Mission mission) {
        missions.add(mission);
    }

    public Collection<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Name: %s %s Id: %d Salary: %.2f%n", this.getFirstName(), this.getLastName(), this.getId(), this.getSalary()));
        output.append("Corps: ").append(this.getCorps().toString()).append(System.lineSeparator());
        output.append("Missions:").append(System.lineSeparator());
        for (Mission mission : getMissions()) {
            output.append("  ")
                    .append(mission.toString());
        }
        return output.toString();
    }
}
