package masterclass.udemy;

public class Printer {
    private double tonerLevel = 100;
    private int numberOfPagesPrinted;
    private boolean isDuplex;

    public Printer(double tonerLevel, boolean isDuplex) {
        this.numberOfPagesPrinted = 0;
        if(tonerLevel > 0 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;        }
        this.isDuplex = isDuplex;
    }

    public double fillToner(double amount){
        if(amount + tonerLevel > 100){
            amount = 100 - tonerLevel;
            tonerLevel = 100;
        }
        else{
            tonerLevel += amount;
        }
        return amount;
    }

    public void print(int numberOfPages){
        if(isDuplex){
            numberOfPages = numberOfPages / 2;
        }
        for(int i = 0; i < numberOfPages; i++){
            numberOfPagesPrinted++;
            System.out.println("printing page " + numberOfPagesPrinted);
            tonerLevel -= 0.1;
        }

        System.out.println("Toner level is " + tonerLevel  + " %");

    }

    public int getNumberOfPagesPrinted() {
        return numberOfPagesPrinted;
    }

    public double getTonerLevel() {
        return tonerLevel;
    }
}
