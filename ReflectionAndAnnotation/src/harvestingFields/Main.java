package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Class<RichSoilLand> clazz = RichSoilLand.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        String input = scanner.nextLine();

        while (!input.equals("HARVEST")) {
            switch (input) {
                case "public":
                    Arrays.stream(declaredFields)
                            .filter(field -> Modifier.isPublic(field.getModifiers()))
                            .forEach(field -> System.out.printf("%s %s %s%n",
                                    Modifier.toString(field.getModifiers()),
                                    field.getType().getSimpleName(),
                                    field.getName()));
                    break;
                case "private":
                    Arrays.stream(declaredFields)
                            .filter(field -> Modifier.isPrivate(field.getModifiers()))
                            .forEach(field -> System.out.printf("%s %s %s%n",
                                    Modifier.toString(field.getModifiers()),
                                    field.getType().getSimpleName(),
                                    field.getName()));

                    break;
                case "protected":
                    Arrays.stream(declaredFields)
                            .filter(field -> Modifier.isProtected(field.getModifiers()))
                            .forEach(field -> System.out.printf("%s %s %s%n",
                                    Modifier.toString(field.getModifiers()),
                                    field.getType().getSimpleName(),
                                    field.getName()));
                    break;
                case "all":
                    Arrays.stream(declaredFields)
                            .forEach(field -> System.out.printf("%s %s %s%n",
                                    Modifier.toString(field.getModifiers()),
                                    field.getType().getSimpleName(),
                                    field.getName()));
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
