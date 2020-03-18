package masterclass.udemy;

public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer(80, true);
        System.out.println(printer.getTonerLevel());
        System.out.println(printer.fillToner(30));
        System.out.println(printer.getNumberOfPagesPrinted());
        printer.print(4);
        System.out.println(printer.getNumberOfPagesPrinted());
    }
}
