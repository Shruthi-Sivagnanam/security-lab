import java.util.Scanner;

public class Encryption {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String plainText;
        System.out.println("Enter the plain text: ");
        plainText = reader.next();

        int row = plainText.length() / 4 + 1;
        char[][] mat = new char[row][4];

        int k = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < 4; j++) {
                if (k == plainText.length())
                    break;
                mat[i][j] = plainText.charAt(k);
                k++;
            }
        }

        System.out.println("The Cipher text: ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < row; j++)
                System.out.print(mat[j][i]);
        }

        reader.close();
    }
}