import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.next();
        StringBuilder result = new StringBuilder();

        if (input.length() % 2 == 0) {
            for (int i = 0; i < input.length(); i++) {
                if (i == input.length() / 2 - 1) {
                    ++i;
                    continue;
                }
                result.append(input.charAt(i));
            }
        } else {
            for (int i = 0; i < input.length(); i++) {
                if (i == input.length() / 2) {
                    continue;
                }
                result.append(input.charAt(i));
            }
        }
        System.out.println(result);
    }
}