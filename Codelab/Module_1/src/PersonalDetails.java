import java.util.Scanner; //importing scanner class.
// Unlike C, Java needs programmer to import this for input
import java.time.LocalDate; //localdate is used for getting the current year

public class PersonalDetails { //class is personal details
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);/*assigning variable class from Class
         construction */
        // Input section
        System.out.print("Enter name: "); //output so user can read and give data
        String name = scanner.nextLine(); //variable and scanner
        System.out.print("Enter gender (M/F): ");
        char gender = scanner.next().charAt(0);

        System.out.print("Enter year of birth: ");
        int yearOfBirth = scanner.nextInt();

        // To close scanner. avoiding waste of resources
        scanner.close();

        // variable of year. since we used localdate,
        // we can get the realtime of the year
        int currentYear = LocalDate.now().getYear();
        int age = currentYear - yearOfBirth;

        // variable gender and gender input conditional section
        String genderStr;
        if (gender == 'M' || gender == 'm') { //if user inputs 'M' or 'm'
            genderStr = "Male"; //then assign string varibale of gender
        } else if (gender == 'F' || gender == 'f') { //if user inputs 'F' or 'f'
            genderStr = "Female"; //then assign string varibale of gender
        } else { //other option other than the two above
            genderStr = "Unknown";
        }

        // Output user's data
        System.out.println("\nPersonal Data:"); //\n to give space for output text
        System.out.println("Name    : " + name); //normal output
        System.out.println("Gender  : " + genderStr); //etc
        System.out.println("Age     : " + age + " years");
    }
}

