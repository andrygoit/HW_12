package task2;

public class FizzBuzz {
    private static int number = 0;
    private static int num = 15;
    private static StringBuilder result = new StringBuilder();
    public static void main(String[] args) {

        for (int i = 0; i < num; i++){
            number++;
            FizzBuzzPrinter();
        }
        System.out.println(result.substring(0,result.length()-2).toString());
    }
    public static void FizzBuzzPrinter(){
        // Поток A вызывает fizz() чтобы проверить делимость на 3 и вывести fizz.
        Thread fizzThread = new Thread(() -> {
            if (number % 3 == 0 && number % 5 != 0 ){
                result.append("fizz, ");
            }
        });
       fizzThread.start();
       fizzThread.interrupt();

       //Поток B вызывает buzz() чтобы проверить делимость на 5 и вывести buzz.
        Thread buzzThread = new Thread(() -> {
            if (number % 5 == 0 && number % 3 != 0 ) {
                result.append("buzz, ");
            }
        });
        buzzThread.start();
        try {
            buzzThread.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        buzzThread.interrupt();

        //Поток C вызывает fizzbuzz() чтобы проверить делимость на 3 и 5 и вывести fizzbuzz.
        Thread fizzBuzzThread = new Thread(() -> {
            if (number % 15 == 0 ) {
                result.append("fizzbuzz, ");
            }
        });
        fizzBuzzThread.start();
        try {
            fizzBuzzThread.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        fizzBuzzThread.interrupt();

        // Поток D вызывает number() чтобы вывести число.
        Thread numberThread = new Thread(() -> {
            if (number % 3 != 0 && number % 5 != 0 ) {
                result.append(number + ", ");
            }
        });
        numberThread.start();
        try {
            numberThread.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        numberThread.interrupt();
    }
}
