package Telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split("\\s+");
        String[] sites = scanner.nextLine().split("\\s+");

        List<String> numbers = Arrays.asList(nums);
        List<String> websites = Arrays.asList(sites);

        Smartphone smartphone = new Smartphone(numbers, websites);

        System.out.print(smartphone.call());
        System.out.println(smartphone.browse());
    }
}
