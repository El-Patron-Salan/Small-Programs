package challenges.temperature;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class ConvertTemperature {

    static void absoluteZeroInfoNotify(){
        System.out.println("If you would like to know what actually is absolute zero then" +
                " press number '7' in menu at the start");
    }
    //info about temperatures below 0K
    static void belowAbsoluteZeroInfo(){
        System.out.println("It's possible to go below 0K (absolute zero),but it's" +
                " already advanced physics theory ,so I'll pass on explaining that ,but" +
                " if you're interested in it, check 'realm of negative temperatures'");
    }

    static void absoluteZero(int option , double converted){

        //Kelvin case
        if(option == 2 || option == 4) {
            if(converted == 0) {
                System.out.println("It's an absolute zero temperature in Kelvin scale!");
                absoluteZeroInfoNotify();
            } else if(converted < 0) {
                belowAbsoluteZeroInfo();
                absoluteZeroInfoNotify();
            }
        }
        //Celsius case
        else if(option == 1 || option == 6){
            if(converted == -273.15 || converted == -273){
                System.out.println("It's an absolute zero temperature in Kelvin scale!");
                absoluteZeroInfoNotify();
            }else if(converted < -273.15) {
                belowAbsoluteZeroInfo();
                absoluteZeroInfoNotify();
            }
        }
        //Fahrenheit case
        else if(option == 3 || option == 5){
            if(converted == -459.67 || converted == -460){
                System.out.println("It's an absolute zero temperature in Kelvin scale!");
                absoluteZeroInfoNotify();
            }else if(converted < -460) {
                belowAbsoluteZeroInfo();
                absoluteZeroInfoNotify();
            }
        }
    }

    static void actionMenu(int option,double tempInput){

        double converted;

        switch(option){

            case 1:
                converted = (((tempInput - 32) * 5) / 9);
                System.out.printf("%10.1f%S = %.1f%S%n",tempInput,"°F",converted,"°C");
                absoluteZero(option,converted);
                break;

            case 2:
                converted = (tempInput + 459.67) * (5.0/9);
                System.out.printf("%10.1f%S = %.1f%S%n",tempInput,"°F",converted,"K");
                absoluteZero(option,converted);
                break;

            case 3:
                converted = (((tempInput / 5) * 9) + 32);
                System.out.printf("%10.1f%S = %.1f%S%n",tempInput,"°C",converted,"°F");
                absoluteZero(option,converted);
                break;

            case 4:
                converted = tempInput + 273.15;
                System.out.printf("%10.1f%S = %.1f%S%n",tempInput,"°C",converted,"K");
                absoluteZero(option,converted);
                break;
            case 5:
                converted = (9.0 / 5) * (tempInput - 273.15) + 32;
                System.out.printf("%10.1f%S = %.1f%S%n",tempInput,"K",converted,"°F");
                absoluteZero(option,converted);
                break;
            case 6:
                converted = tempInput - 273.15;
                System.out.printf("%10.1f%S = %.1f%S%n",tempInput,"K",converted,"°C");
                absoluteZero(option,converted);
                break;
            case 7:
                System.out.println("\nAbsolute zero is the lowest possible temperature " +
                        "where nothing could be colder and no heat energy remains in a substance." +
                        " Absolute zero is the point at which the fundamental particles of nature have " +
                        "minimal vibrational motion, retaining only quantum mechanical, " +
                        "zero-point energy-induced particle motion.");
                break;
            default:
                System.out.println("Such an option doesn't exist yet");
                break;
        }
    }

    public static void main(String[] args) throws NoSuchElementException {

        Scanner input = new Scanner(System.in);
        Calendar cal = Calendar.getInstance();
        //print actual date with hour
        System.out.printf("%n%tb %te  %tl:%tM %tp%n",cal,cal,cal,cal,cal);

        System.out.println("\n******************************");
        System.out.println("Types of conversion: ");
        System.out.println("\n1.°F to °C" +
                "\n2.°F to K" +
                "\n3.°C to °F" +
                "\n4.°C to K" +
                "\n5.K to °F" +
                "\n6.K to °C");
        System.out.println("******************************");

        System.out.print("Provide temperature: ");
        try {
            double tempInput = input.nextDouble();

            System.out.print("Choose conversion method: ");
            int option = input.nextInt();

            actionMenu(option, tempInput);
        }catch(InputMismatchException e) {
            System.out.println(e + " - wrong input!");
        }
    }

}

