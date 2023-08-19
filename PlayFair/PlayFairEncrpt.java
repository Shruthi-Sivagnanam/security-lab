import java.util.Scanner;

class PlayFairEncrpt {
    static char[][] matrix = new char[5][5];

    static void matrixFormation(String key) {
        String alphabet;
        if (key.indexOf('i') != -1 && key.indexOf('j') != -1)
            alphabet = "abcdefghklmnopqrstuv";
        else
            alphabet = "abcdefghiklmnopqrstuvwxyz";

        int m = 0, n = 0;
        for (int i = 0; i < key.length(); i++) {
            if (n >= 5) {
                m++;
                n = 0;
            }
            matrix[m][n] = key.charAt(i);
            n++;
        }

        for (int i = 0; i < alphabet.length(); i++) {
            if (m >= 5 && n >= 5)
                break;
            if (key.indexOf(alphabet.charAt(i)) == -1) {
                if (n >= 5) {
                    m++;
                    n = 0;
                }
                matrix[m][n] = alphabet.charAt(i);
                n++;
            }

        }
    }

    static void encryption(String plainText) {
        int m1 = 0, n1 = 0, m2 = 0, n2 = 0;
        if (plainText.length() % 2 != 0)
            plainText += "x";
        // System.out.println(plainText);
        for (int i = 0; i < plainText.length(); i++) {
            char p1 = plainText.charAt(i);
            char p2 = plainText.charAt(i + 1);
            for (int m = 0; m < 5; m++) {
                for (int n = 0; n < 5; n++) {
                    if (p1 == matrix[m][n]) {
                        m1 = m;
                        n1 = n;
                    } else if (p2 == matrix[m][n]) {
                        m2 = m;
                        n2 = n;
                    }
                }
            }
            // same row
            if (m1 == m2) {
                if (n1 > n2)
                    System.out.print(matrix[m1][n2 + 1] + "" + matrix[m1][n2]);
                else if (n2 > n1)
                    System.out.print(matrix[m1][n1 + 1] + "" + matrix[m1][n1]);
            }
            // same column
            if (n1 == n2) {
                if (m1 > m2)
                    System.out.print(matrix[m2][n1] + "" + matrix[m2 + 1][n1]);
                else if (m2 > m1)
                    System.out.print(matrix[m1 + 1][n1] + "" + matrix[m1][n1]);
            }

            // different row and different column
            if (m1 != m2 && n1 != n2) {
                System.out.print(matrix[m1][n2] + "" + matrix[m2][n1]);
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String plainText, key;

        System.out.println("Enter the plain Text: ");
        plainText = reader.next();
        System.out.println("Enter the key value: ");
        key = reader.next();

        matrixFormation(key);

        System.out.println("Matrix formed with the keyword: ");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++)
                System.out.print(matrix[i][j]);
            System.out.println();
        }
        System.out.println("Cipher Text: ");

        encryption(plainText);

        reader.close();
    }
}