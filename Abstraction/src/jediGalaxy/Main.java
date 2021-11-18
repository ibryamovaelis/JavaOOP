package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readPositions(scanner.nextLine());
        int rows = dimensions[0];
        int cols = dimensions[1];

        Field field = new Field(rows, cols);
        Galaxy galaxy = new Galaxy(field);

        String command = scanner.nextLine();
        long starsCollected = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] jediPosition = readPositions(command);
            int[] evilPosition = readPositions(scanner.nextLine());

            int rowEvil = evilPosition[0];
            int colEvil = evilPosition[1];
            galaxy.moveEvil(rowEvil, colEvil);

            int rowJedi = jediPosition[0];
            int colJedi = jediPosition[1];
            starsCollected += galaxy.moveJedi(rowJedi, colJedi);

            command = scanner.nextLine();
        }
        System.out.println(starsCollected);
    }

    private static int[] readPositions(String command) {
        return Arrays.stream(command.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}