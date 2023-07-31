import java.util.Scanner;

public class CaserCipherEncrpt {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String message, cipherMessage = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int key;
        System.out.println("Enter the Key value");
        key = reader.nextInt();
        System.out.println("Enter the plain text to be encrpyted: ");
        message = reader.next();

        // encrpytion function
        for (int i = 0; i < message.length(); i++) {
            int p = alphabet.indexOf(message.charAt(i));
            int keyval = (p + key) % 26;
            char replaceCharacter = alphabet.charAt(keyval);
            cipherMessage += replaceCharacter;
        }

        System.out.println("Cipher Text: " + cipherMessage);

        reader.close();
    }
}