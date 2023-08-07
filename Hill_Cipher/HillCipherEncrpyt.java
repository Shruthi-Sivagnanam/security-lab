import java.util.Scanner;

class HillCipherEncrpyt {

    static int[][] matrix = new int[3][3];
    static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    static void encrpytion(String plainText) {
        for (int i = 0; i < plainText.length(); i += 3) {
            int p1 = alphabet.indexOf(plainText.charAt(i));
            int p2 = alphabet.indexOf(plainText.charAt(i + 1));
            int p3 = alphabet.indexOf(plainText.charAt(i + 2));

            for (int j = 0; j < 3; j++) {
                int a1 = (matrix[j][0] * p1 + matrix[j][1] * p2 + matrix[j][2] * p3) % 26;
                System.out.print(alphabet.charAt(a1));
            }
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String plainText;
        System.out.println("Enter the plain text: ");
        plainText = reader.next();
        System.out.println("Enter the 3x3 key matrics: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                matrix[i][j] = reader.nextInt();
        }
        if (plainText.length() % 3 != 0) {
            if (plainText.length() % 3 == 1)
                plainText += "x";
            else
                plainText += "xx";
        }

        System.out.print("Cipher Text: ");
        encrpytion(plainText);

        reader.close();
    }
}