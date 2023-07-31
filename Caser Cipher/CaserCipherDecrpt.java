import java.util.Scanner;;

public class CaserCipherDecrpt {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String cipherMessage, plainText = "";
        int key;

        System.out.println("Enter the key value: ");
        key = reader.nextInt();

        System.out.println("Enter the cipher Text: ");
        cipherMessage = reader.next();
        cipherMessage = cipherMessage.toLowerCase();

        // decrpytion
        for (int i = 0; i < cipherMessage.length(); i++) {
            int p = alphabet.indexOf(cipherMessage.charAt(i));
            int keyval = (p - key) % 26;
            if (keyval < 0)
                keyval = alphabet.length() + keyval;
            char replaceCharacter = alphabet.charAt(keyval);
            plainText += replaceCharacter;
        }

        System.out.println("Plain Text: " + plainText);

        reader.close();

    }
}
