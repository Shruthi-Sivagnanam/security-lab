import java.util.Scanner;

public class Encryption {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String plainText;
        int key;
        System.out.println("Enter the plain text: ");
        plainText = reader.nextLine();
        System.out.println("Enter the key value: ");
        key = reader.nextInt();

        for (int i = 0; i < key; i++) {
            for (int j = i; j < plainText.length(); j += (key - 1) * 2) {
                System.out.print(plainText.charAt(j));
            }
        }

        reader.close();
    }
}