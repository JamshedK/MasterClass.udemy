package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        printSquareStar(2);
    }
    public static void printSquareStar(int number){
        if(number < 5){
            System.out.println("Invalid Value");
        }

        else {
            int rowCount = 0;
            for (int row = 0; row < number; row++) {
                rowCount++;
                for (int column = 0; column < number; column++) {
                    // if the first row or the last row, print all the stars
                    if (row == 0 || row == number - 1) {
                        System.out.print("*");
                    } else {
                        // starting from the second row, until the pre-last row
                        // if it is the first column, print a start
                        if (column == 0) {
                            System.out.print("*");
                        }
                        // if the row number, equal column number, print the star
                        else if (row == column) {
                            System.out.print("*");
                        }
                        // if the last column, print a star
                        else if (column == number - 1) {
                            System.out.print("*");
                        }
                        // this is the reverse of if(row == column) for printing the other diagonal
                        else if (row == (number - 1) - column) {
                            System.out.print("*");
                        }
                        // if all these conditions fail, print an empty space
                        else {
                            System.out.print(" ");
                        }

                    }
                }
                System.out.println("");
            }
        }
    }
}
