package numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Methods {
    static String[] availableProperties = {"BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY", "EVEN", "ODD", "JUMPING", "HAPPY", "SAD",
    "-BUZZ", "-DUCK", "-PALINDROMIC", "-GAPFUL", "-SPY", "-SQUARE", "-SUNNY", "-EVEN", "-ODD", "-JUMPING", "-HAPPY", "-SAD"};

    public static void properties(long value) {
        System.out.println("even: " + checkParity(value));
        System.out.println("odd: " + !checkParity(value));
        System.out.println("buzz: " + checkBuzz(value));
        System.out.println("duck: " + checkDuck(value));
        System.out.println("palindromic: " + checkPalindrome(value));
        System.out.println("gapful: " + checkGapful(value));
        System.out.println("spy: " + checkSpy(value));
        System.out.println("square: " + checkSquare(value));
        System.out.println("sunny: " + checkSunny(value));
        System.out.println("jumping: " + checkJumping(value));
        System.out.println("happy: " + checkHappy(value));
        System.out.println("sad: " + !checkHappy(value));
    }
    public static boolean checkParity (long value) {
        return value % 2 == 0;
    }

/*    public static boolean checkOdd (long value) {
        return value % 2 == 1;
    }*/

    public static boolean checkBuzz(long value) {
        String testText = Long.toString(value);
        return (value % 7 == 0 || testText.endsWith("7"));
    }

    public static boolean checkDuck(long value) {
        String testText = Long.toString(value);
        boolean valueDuck = false;
        if (testText.startsWith("0")) {
            if (testText.substring(1).contains("0")) {
                valueDuck = true;
            }
        } else valueDuck = testText.contains("0");
        return valueDuck;
    }

    public static boolean checkPalindrome(long value) {
        String testText = Long.toString(value);
        StringBuilder userNumberI = new StringBuilder();
        userNumberI.append(testText);
        userNumberI.reverse();

        return testText.equals(userNumberI.toString());
    }

    public static boolean checkGapful(long value) {
        String testText = Long.toString(value);
        if (testText.length() > 2) {
            String[] userNumberArray = testText.split("");
            long divisor = Long.parseLong(userNumberArray[0] + userNumberArray[userNumberArray.length-1]);

            return (Long.parseLong(testText) % divisor == 0);
        } else
            return false;
    }

    public static boolean checkSpy(long value) {
        char[] array = (Long.toString(value)).toCharArray();
        long sum = 0;
        long product = 1;
        for (char c : array) {
            sum += Character.getNumericValue(c);
            product *= Character.getNumericValue(c);
        }
        return (sum == product);
    }

    public static boolean checkSunny(long value) {
        return (sqrt(value + 1) % 1 == 0);

    }

    public static boolean checkSquare(long value) {
        return (sqrt(value) % 1 == 0);
    }

    public static boolean checkJumping(long value) {
        String testText = Long.toString(value);
        char[] array = (Long.toString(value)).toCharArray();
        boolean jumping = false;
        if (testText.length() == 1) {
            jumping = true;
        } else {
            for (int i = 0; i < testText.length()-1; i++) {
                if (abs(array[i] - array[i + 1]) == 1) {
                    jumping = true;
                } else {
                    jumping = false;
                    break;
                }
            }
        }
        return jumping;
    }

    public static boolean checkHappy(long value) {
        char[] array = (Long.toString(value)).toCharArray();
        int checkValue = 0;
        if (value == 1) {
            return true;
        }
        while (checkValue != value && checkValue != 4) {
            if (checkValue == 1) {
                return true;
            } else {
                checkValue = 0;
                for (char c : array) {
                    checkValue += Character.getNumericValue(c) * Character.getNumericValue(c);
                }
                array = (Long.toString(checkValue)).toCharArray();
            }
        }
        return false;
    }

    public static boolean checkMutuallyExclusive(String[] request) {
        for (int i = 0; i < request.length; i++) {
            request[i] = request[i].toUpperCase();
        }
        if (Arrays.asList(request).contains("ODD") && Arrays.asList(request).contains("EVEN")) {
            System.out.println("The request contains mutually exclusive properties: [ODD, EVEN]");
            System.out.println("There are no numbers with these properties.");
            return true;
        } else if (Arrays.asList(request).contains("DUCK") && Arrays.asList(request).contains("SPY")) {
            System.out.println("The request contains mutually exclusive properties: [DUCK, SPY]");
            System.out.println("There are no numbers with these properties.");
            return true;
        } else if (Arrays.asList(request).contains("SQUARE") && Arrays.asList(request).contains("SUNNY")) {
            System.out.println("The request contains mutually exclusive properties: [SQUARE, SUNNY]");
            System.out.println("There are no numbers with these properties.");
            return true;
        } else if (Arrays.asList(request).contains("HAPPY") && Arrays.asList(request).contains("SAD")) {
            System.out.println("The request contains mutually exclusive properties: [HAPPY, SAD]");
            System.out.println("There are no numbers with these properties.");
            return true;
        } else if (Arrays.asList(request).contains("-ODD") && Arrays.asList(request).contains("-EVEN")) {
            System.out.println("The request contains mutually exclusive properties: [-ODD, -EVEN]");
            System.out.println("There are no numbers with these properties.");
            return true;
        } else if (Arrays.asList(request).contains("-DUCK") && Arrays.asList(request).contains("-SPY")) {
            System.out.println("The request contains mutually exclusive properties: [-DUCK, -SPY]");
            System.out.println("There are no numbers with these properties.");
            return true;
        } else if (Arrays.asList(request).contains("-SQUARE") && Arrays.asList(request).contains("-SUNNY")) {
            System.out.println("The request contains mutually exclusive properties: [-SQUARE, -SUNNY]");
            System.out.println("There are no numbers with these properties.");
            return true;
        } else if (Arrays.asList(request).contains("-HAPPY") && Arrays.asList(request).contains("-SAD")) {
            System.out.println("The request contains mutually exclusive properties: [-HAPPY, -SAD]");
            System.out.println("There are no numbers with these properties.");
            return true;
        } else {
            String[] positiveProperties = {"BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY", "EVEN", "ODD", "JUMPING", "HAPPY", "SAD"};

            for (String s : positiveProperties){
                if (Arrays.asList(request).contains(s) && Arrays.asList(request).contains("-" + s)) {
                    System.out.println("The request contains mutually exclusive properties: [" + s + ", -" + s + "]");
                    System.out.println("There are no numbers with these properties.");
                    return true;
                }
            }
        } return false;
    }

    public static boolean checkCorrect(String[] request) {
        StringBuilder wrong = new StringBuilder();
        for (int i = 2; i < request.length; i++) {
            if (!Arrays.asList(availableProperties).contains(request[i].toUpperCase())) {
                wrong.append(request[i].toUpperCase());
                wrong.append(", ");
            }
        }

        int spaces = 0;
        String wrongString = wrong.toString();
        if (wrongString.length() != 0) {
            spaces = wrongString.split(" ").length;
        }

        if (spaces == 1) {
            wrong.delete(wrong.length()-2, wrong.length()-1);
            System.out.println("The property [" + wrong + "] is wrong.");
            System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD, JUMPING, HAPPY, SAD]");
            return false;
        } else if (wrong.length() > 1) {
            wrong.delete(wrong.length()-2, wrong.length()-1);
            System.out.println("The properties [" + wrong + "] are wrong.");
            System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD, JUMPING, HAPPY, SAD]");
            return false;
        } else return true;
    }
    public static String virtues(long value) {

        List<String> list = new ArrayList<>();

        if (checkParity(value)) list.add("even");
            else list.add("odd");
        if (checkDuck(value)) list.add("duck");
        if (checkBuzz(value)) list.add("buzz");
        if (checkPalindrome(value)) list.add("palindromic");
        if (checkGapful(value)) list.add("gapful");
        if (checkSpy(value)) list.add("spy");
        if (checkSquare(value)) list.add("square");
        if (checkSunny(value)) list.add("sunny");
        if (checkJumping(value)) list.add("jumping");
        if (checkHappy(value)) list.add("happy");
            else list.add("sad");

        StringBuilder sb = new StringBuilder(value + " is ");
        sb.append(list.get(0));
        list.remove(0);
        for (String virtue : list) {
            sb.append(", ").append(virtue);
        }
        return sb.toString();
    }

    public static void showNumberInfo(long value, long amount) {
        System.out.println();
        for (int i = 0; i < amount; i++) {
            System.out.println(virtues(value));
            value++;
        }
        System.out.println();
    }

    public static void showNumberInfo(long value, long amount, String property) {
        int counter = 0;
        value -= 1;

        System.out.println();
        while (counter < amount) {
            if (!Arrays.asList(availableProperties).contains(property)) {
                System.out.println();
                System.out.println("The property [" + property + "] is wrong.");
                System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
                System.out.println();
                break;
            }
            value++;
            String checker = virtues(value);
            if (!property.contains("-")) {
                if (checker.contains(property.toLowerCase())) {
                    System.out.println(virtues(value));
                    counter++;
                }
            } else {
                StringBuilder exclude = new StringBuilder(property);
                exclude.deleteCharAt(0);
                if (!checker.contains(exclude.toString().toLowerCase())) {
                    System.out.println(virtues(value));
                    counter++;
                }
            }
            System.out.println();
        }
    }

    public static void showNumberInfo(long value, long amount, String[] request, String property1, String property2){
        int counter = 0;
        value -= 1;
        System.out.println();
        while (counter < amount) {
            if (!checkCorrect(request)) {
                break;
            }
            value++;
            String checker = virtues(value);
            if (checker.contains(property1.toLowerCase()) && checker.contains(property2.toLowerCase())) {
                System.out.println(virtues(value));
                counter++;
            }
        }
        System.out.println();
    }

    public static void showNumberInfo(long value, long amount, String[] request){
        int counter = 0;
        value -= 1;
        System.out.println();
        List<String> neededProperties = new ArrayList<>();
        List<String> excludeProperties = new ArrayList<>();
        for (int i = 2; i < request.length; i++) {
            if (!request[i].contains("-")) {
                neededProperties.add(request[i].toLowerCase());
            } else {
                StringBuilder excludeThisProperty = new StringBuilder(request[i]);
                excludeThisProperty.deleteCharAt(0);
                excludeProperties.add(excludeThisProperty.toString().toLowerCase());
            }
        }

        String[] needed = neededProperties.toArray(new String[0]);
        String[] excluded = excludeProperties.toArray(new String[0]);
        boolean containsProperties = false;

        while (counter < amount) {
            boolean breaknow = false;
            if (!checkCorrect(request)) {
                break;
            }
            value++;
            String checker = virtues(value);
            for (String property : needed) {
                if (checker.contains(property)) {
                    containsProperties = true;
                } else {
                    containsProperties = false;
                    breaknow = true;
                    break;
                }
            }
            if (breaknow == true) {
                continue;
            }

            for (String exProperty : excluded) {
                if (!checker.contains(exProperty)) {
                    containsProperties = true;
                } else {
                    containsProperties = false;
                    break;
                }
            }

            if (containsProperties) {
                System.out.println(virtues(value));
                counter++;
            }
        }
        System.out.println();
    }
}
