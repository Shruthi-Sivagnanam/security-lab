import java.util.Scanner;

class VignereCipherEncrpyt {

    static char[][] alphabetMatrix = new char[26][26];
    static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    static void matrixFormation() {

        for (int i = 0; i < 26; i++) {
            int index = i;
            for (int j = 0; j < 26; j++) {
                if (index == 26)
                    index = 0;
                alphabetMatrix[i][j] = alphabet.charAt(index);
                index++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String plainText, key;

        matrixFormation();

        System.out.println("Enter the Plain Text: ");
        plainText = reader.next();
        System.out.println("Enter the Key Text: ");
        key = reader.next();

        int j = 0;
        for (int i = 0; i < plainText.length(); i++) {
            if (j == key.length())
                j = 0;
            System.out.print(alphabetMatrix[alphabet.indexOf(key.charAt(j))][alphabet.indexOf(plainText.charAt(i))]);
            j++;

        }

        reader.close();
    }
}