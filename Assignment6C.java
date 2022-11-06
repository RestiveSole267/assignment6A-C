import java.util.Scanner;
public class Assignment6C {
    public static void main(String[] args) {
        String array[][] = new String[4][4];
        for(int i = 0;i < array.length;i++)
            for(int j = 0; j < array[i].length;j++)
                array[i][j] = " ";
        char symbol;
        boolean win = false;
        Scanner scan = new Scanner(System.in);
        int currentPlayer = 1, row;
        System.out.println("[Connect Four]");
        while(!isBoardFull(array))
        {
            symbol = currentPlayer == 1? 'X':'O';
            while(true)
            {
                System.out.print("Player "+currentPlayer+", enter a row: ");
                row = scan.nextInt();
                if(isSlotEmpty(array,row))
                {
                    addDisc(array,row,symbol);
                    break;
                }
                System.out.println("That position is invalid. Try again.");
            }
            System.out.println("");
            printArray(array);
            System.out.println("");
            if(winVertical(array, symbol) || winHorizontal(array, symbol) || winDiagonal(array, symbol))
            {
                System.out.println("Player " + currentPlayer + " wins!");
                win = true;
                break;
            }
            if(currentPlayer == 1)
                currentPlayer = 2;
            else
                currentPlayer = 1;
        }
        if(!win)
            System.out.println("\nIts a Tie!");
    }
    public static void printArray(String [][]array)
    {
        for(int i = 0 ; i < array.length; i++)
        {
            System.out.print("|");
            for(int j = 0; j < array[i].length ;j++)
            {
                System.out.print(array[i][j] + "|");
            }
            System.out.println();
        }
    }
    public static boolean isBoardFull(String[][] array) {
        for(int i = 0; i < array.length; i++)
            for(int j = 0; j < array[i].length; j++)
                if(array[i][j].equals(" "))
                    return false;
        return true;
    }
    public static boolean isSlotEmpty(String[][] array,int row) {
        if(row >= 0 && row < array.length)
        {
            for(int i = 0; i < array.length; i++)
                if(array[i][row].equals(" "))
                    return true;
        }
        return false;
    }
    public static void addDisc(String[][] array, int column, char player) {
        for(int i=array.length-1; i >= 0; i--)
        {
            if(array[i][column].equals(" "))
            {
                array[i][column]=player+"";
                return;
            }
        }
    }
    public static boolean winVertical(String[][] array,char player)
    {
        for(int i = 0; i < array.length; i++)
        {
            if(array[i][0].equals(player+"") && array[i][1].equals(player+"") && array[i][2].equals(player+"") && array[i][3].equals(player+""))
                return true;
        }
        return false;
    }
    public static boolean winHorizontal(String[][] array,char player)
    {
        for(int i = 0; i < array.length; i++)
        {
            if(array[0][i].equals(player+"") && array[1][i].equals(player+"") && array[2][i].equals(player+"") && array[3][i].equals(player+""))
                return true;
        }
        return false;
    }
    public static boolean winDiagonal(String[][] array,char player)
    {
        if(array[0][0].equals(player+"") && array[1][1].equals(player+"") && array[2][2].equals(player+"") && array[3][3].equals(player+""))
            return true;
        if(array[0][3].equals(player+"") && array[1][2].equals(player+"") && array[2][2].equals(player+"") && array[3][0].equals(player+""))
            return true;
        return false;
    }
}