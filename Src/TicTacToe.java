import java.util.Scanner;

public class TicTacToe {

    static boolean validMove = false;

    public static void main(String[] args) {
        // Gerüst aufstellen
        char[][] playBoard = new char[][] {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };

        // Namen der Spieler erhalten
        printText();

        // Spielfeld anzeigen
        printPlayBoard(playBoard);

        // Unendliche Schleife für das Spiel
        while (true) {
            Scanner scanner = new Scanner(System.in);

            // Spieler X
            // validbool = false
            // Schleife unten setzen um x bzw o spieler

            validMove = false;
            while(!validMove) {
                System.out.println("Enter position of X (1 - 9): ");
                int xPos = scanner.nextInt();
                xPlay(playBoard, xPos, "X");
            }
            // Spieler O
            // Schleife unten setzen um x bzw o spieler
            validMove = false;
            while(!validMove) {
                System.out.println("Enter position of O (1 - 9): ");
                int oPos = scanner.nextInt();
                oPlay(playBoard, oPos, "O");
            }

        }
    }

    public static void xPlay(char[][] playBoard, int xPos, String player) {
        switch (xPos) {
            case 1:
                // check used methode
                if(playBoard[0][0] == 'X' || playBoard[0][0] == 'O' ) {
                    playBoard[0][0] = 'X';
                    validMove = true;
                }
                break;
                // Cases anpassen!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            case 2:
                playBoard[0][2] = 'X';
                break;
            case 3:
                playBoard[0][4] = 'X';
                break;
            case 4:
                playBoard[2][0] = 'X';
                break;
            case 5:
                playBoard[2][2] = 'X';
                break;
            case 6:
                playBoard[2][4] = 'X';
                break;
            case 7:
                playBoard[4][0] = 'X';
                break;
            case 8:
                playBoard[4][2] = 'X';
                break;
            case 9:
                playBoard[4][4] = 'X';
                break;
            default:
                break;
        }
        printPlayBoard(playBoard);
    }

    public static void oPlay(char[][] playBoard, int oPos, String player) {
        switch (oPos) {
            case 1:
                playBoard[0][0] = 'O';
                break;
            case 2:
                playBoard[0][2] = 'O';
                break;
            case 3:
                playBoard[0][4] = 'O';
                break;
            case 4:
                playBoard[2][0] = 'O';
                break;
            case 5:
                playBoard[2][2] = 'O';
                break;
            case 6:
                playBoard[2][4] = 'O';
                break;
            case 7:
                playBoard[4][0] = 'O';
                break;
            case 8:
                playBoard[4][2] = 'O';
                break;
            case 9:
                playBoard[4][4] = 'O';
                break;
            default:
                break;
        }
        printPlayBoard(playBoard);
    }

    public static void printPlayBoard(char[][] playBoard) {
        // Durch das Gerüst iterieren
        for (char[] colom : playBoard) {
            for (char rows : colom) {
                System.out.print(rows);
            }
            System.out.println();
        }

    }
    public static void printText() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name des Spielers für X: ");
        String nameX = scanner.nextLine();

        System.out.println("Name des Spielers für O: ");
        String nameO = scanner.nextLine();
        System.out.println("Das Spiel beginnt!");
    }

    // Methode: checkWinner();
}
