import java.io.IOException;
import java.util.Scanner;

public class TicTacToe {
    public static String nameX;
    public static String nameO;
    static boolean validMove = false;

    public static void main(String[] args) throws IOException {
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
            boolean isWinner = false;
            boolean full = false;

            // Spieler X
            validMove = false;
            while(!validMove) {
                System.out.println("Enter position of X (1 - 9): ");
                int xPos = scanner.nextInt();
                if(isValidMove(playBoard, xPos)) {
                    play2(playBoard, xPos, "X");
                    validMove = true;
                }
                if(checkWinner(playBoard, 'X')) {
                    System.out.println(nameX + " wins!");
                    isWinner = true;
                    break;
                }
                if(isBoardFull(playBoard)) {
                    System.out.println("No winner. All fields have been used");
                    full = true;
                    break;
                }
            }
            if(isWinner) {
                break;
            }
            if(full) {
                break;
            }
            // Spieler O
            validMove = false;
            while(!validMove) {
                System.out.println("Enter position of O (1 - 9): ");
                int oPos = scanner.nextInt();
                if(isValidMove(playBoard, oPos)) {
                    play2(playBoard, oPos, "O");
                    validMove = true;
                }
                if(checkWinner(playBoard, 'O')) {
                    System.out.println(nameO + " wins!");
                    isWinner = true;
                    break;
                }
                if(isBoardFull(playBoard)) {
                    System.out.println("No winner. All fields have been used");
                    full = true;
                    break;
                }
            }
            if(isWinner) {
                break;
            }
            if(full) {
                break;
            }
        }
    }
    public static boolean isValidMove(char[][] playBoard, int position) {
        switch (position) {
            case 1:
                return playBoard[0][0] == ' ';
            case 2:
                return playBoard[0][2] == ' ';
            case 3:
                return playBoard[0][4] == ' ';
            case 4:
                return playBoard[2][0] == ' ';
            case 5:
                return playBoard[2][2] == ' ';
            case 6:
                return playBoard[2][4] == ' ';
            case 7:
                return playBoard[4][0] == ' ';
            case 8:
                return playBoard[4][2] == ' ';
            case 9:
                return playBoard[4][4] == ' ';
            default:
                break;
        }
        return false;
    }
    public static void play2(char [][] playBoard, int pos, String player) {
        switch (pos) {
            case 1:
                playBoard[0][0] = player.charAt(0);
                break;
            case 2:
                playBoard[0][2] = player.charAt(0);
                break;
            case 3:
                playBoard[0][4] = player.charAt(0);
                break;
            case 4:
                playBoard[2][0] = player.charAt(0);
                break;
            case 5:
                playBoard[2][2] = player.charAt(0);
                break;
            case 6:
                playBoard[2][4] = player.charAt(0);
                break;
            case 7:
                playBoard[4][0] = player.charAt(0);
                break;
            case 8:
                playBoard[4][2] = player.charAt(0);
                break;
            case 9:
                playBoard[4][4] = player.charAt(0);
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
        System.out.println("Name of player X: ");
        nameX = scanner.nextLine();

        System.out.println("Name of player O: ");
        nameO = scanner.nextLine();
        System.out.println("The game starts:");
    }
    public static boolean checkWinner(char [][] playBoard, char pos) {
        if(playBoard[0][0] == pos && playBoard[0][2] == pos && playBoard[0][4] == pos) {
            return true;
        }else if(playBoard[2][0] == pos && playBoard[2][2] == pos && playBoard[2][4] == pos) {
            return true;
        }else if(playBoard[4][0] == pos && playBoard[4][2] == pos && playBoard[4][4] == pos) {
            return true;
        }else if(playBoard[0][0] == pos && playBoard[2][0] == pos && playBoard[4][0] == pos) {
            return true;
        }else if(playBoard[0][2] == pos && playBoard[2][2] == pos && playBoard[4][2] == pos) {
            return true;
        }else if(playBoard[0][4] == pos && playBoard[2][4] == pos && playBoard[4][4] == pos) {
            return true;
        }else if(playBoard[0][0] == pos && playBoard[2][2] == pos && playBoard[4][4] == pos) {
            return true;
        }else if(playBoard[0][4] == pos && playBoard[2][2] == pos && playBoard[4][0] == pos) {
            return true;
        }
        return false;
    }
    // Abbrechen wenn Feld voll ist
    public static boolean isBoardFull(char [][] playBoard) {
        for(int row = 0; row < playBoard.length; row ++) {
            for(int column = 0; column < playBoard[row].length; column++) {
                if(playBoard[row][column] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}