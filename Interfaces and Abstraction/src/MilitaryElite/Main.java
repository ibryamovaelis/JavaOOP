package MilitaryElite;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<Integer, PrivateImpl> privateMap = new LinkedHashMap();
        Map<Integer, SoldierImpl> soldiers = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String[] soldierInfo = input.split("\\s+");
            String rank = soldierInfo[0];
            int id = Integer.parseInt(soldierInfo[1]);
            String firstName = soldierInfo[2];
            String lastName = soldierInfo[3];
            double salary = 0;
            String corpsName = "";
            switch (rank) {
                case "Private":
                    salary = Double.parseDouble(soldierInfo[4]);
                    PrivateImpl priv = new PrivateImpl(id, firstName, lastName, salary);
                    privateMap.put(id, priv);
                    soldiers.put(id, priv);
                    break;
                case "LieutenantGeneral":
                    salary = Double.parseDouble(soldierInfo[4]);
                    LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);
                    soldiers.put(id, lieutenantGeneral);
                    addPrivates(soldierInfo, privateMap, lieutenantGeneral);
                    break;
                case "Engineer":
                    salary = Double.parseDouble(soldierInfo[4]);
                    corpsName = soldierInfo[5];
                    boolean corpsNameCheck = checkCorps(corpsName);
                    if (!corpsNameCheck) {
                        break;
                    }
                    Corps corps = Corps.valueOf(corpsName);
                    EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary, corps);
                    addRepairs(soldierInfo, engineer);
                    soldiers.put(id, engineer);
                    break;
                case "Commando":
                    salary = Double.parseDouble(soldierInfo[4]);
                    corpsName = soldierInfo[5];
                    corpsNameCheck = checkCorps(corpsName);
                    if (!corpsNameCheck) {
                        break;
                    }
                    corps = Corps.valueOf(corpsName);
                    CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary, corps);
                    addMission(soldierInfo, commando);
                    soldiers.put(id, commando);
                    break;
                case "Spy":
                    String codeNumber = soldierInfo[4];
                    SpyImpl spy = new SpyImpl(id, firstName, lastName, codeNumber);
                    soldiers.put(id, spy);
                    break;
            }
            input = scanner.nextLine();
        }
        printOutput(soldiers);
    }

    private static boolean checkCorps(String corpsName) {
        if (!corpsName.equals("Airforces") && !corpsName.equals("Marines")) {
            return false;
        }
        return true;
    }

    private static void printOutput(Map<Integer, SoldierImpl> soldiers) {
        soldiers.values().stream().forEach(soldier -> System.out.print(soldier));
    }

    private static void addPrivates(String[] soldierInfo, Map<Integer, PrivateImpl> privateMap, LieutenantGeneralImpl lieutenantGeneral) {
        int privateId = 0;
        for (int i = 5; i < soldierInfo.length; i++) {
            privateId = Integer.parseInt(soldierInfo[i]);
            PrivateImpl privateToAdd = privateMap.get(privateId);
            lieutenantGeneral.addPrivate(privateToAdd);
        }
    }

    private static void addMission(String[] soldierInfo, CommandoImpl commando) {
        String missionName = "";
        String stateName = "";
        for (int i = 6; i < soldierInfo.length; i += 2) {
            missionName = soldierInfo[i];
            stateName = soldierInfo[i + 1];
            if (!stateName.equals("inProgress") && !stateName.equals("finished")) {
                continue;
            }
            State state = State.valueOf(stateName);
            Mission mission = new Mission(missionName, state);
            commando.addMission(mission);
        }
    }

    private static void addRepairs(String[] soldierInfo, EngineerImpl engineer) {
        String partName = "";
        int hoursRequired = 0;
        for (int i = 6; i < soldierInfo.length; i += 2) {
            partName = soldierInfo[i];
            hoursRequired = Integer.parseInt(soldierInfo[i + 1]);
            Repair repair = new Repair(partName, hoursRequired);
            engineer.addRepair(repair);
        }
    }
}
