import java.util.Scanner;

public class StringComparator {

    public static boolean compareStringsUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Pehli string enter karein: ");
        String str1 = scanner.next();

        System.out.print("Dusri string enter karein: ");
        String str2 = scanner.next();

        boolean customMethodResult = compareStringsUsingCharAt(str1, str2);
        System.out.println("Custom charAt() method se comparison result: " + customMethodResult);

        boolean builtInMethodResult = str1.equals(str2);
        System.out.println("Built-in equals() method se comparison result: " + builtInMethodResult);

        if (customMethodResult == builtInMethodResult) {
            System.out.println("Dono methods ke results same hain! ✅");
        } else {
            System.out.println("Dono methods ke results alag hain! ❌");
        }

        scanner.close();
    }
}
