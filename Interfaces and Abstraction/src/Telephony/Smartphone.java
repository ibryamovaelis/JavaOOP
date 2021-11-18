package Telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder output = new StringBuilder();
        for (String website : urls) {
            if (!website.matches("\\D+")) {
                output.append("Invalid URL!").append(System.lineSeparator());
            } else {
                output.append(String.format("Browsing: %s!", website)).append(System.lineSeparator());
            }
        }
        return output.toString();
    }

    @Override
    public String call() {
        StringBuilder output = new StringBuilder();
        for (String number : numbers) {
            if (!number.matches("[0-9]+")) {
                output.append("Invalid number!").append(System.lineSeparator());
            } else {
                output.append(String.format("Calling... %s", number)).append(System.lineSeparator());
            }
        }
        return output.toString();
    }
}
