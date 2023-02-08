import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        String alphabet = "abcdefghjklmnopqrstuvwxyz";//A aB bC cD dE eF fG gH hI iJ jK kL lM mN nO oP pQ qR rS sT tU uV vW wX xY yZ z

        if (alphabet.contains(input)) {
            System.out.println(true);
        } else System.out.println(false);
    }
}