import java.util.Scanner;
import java.time.LocalDate;

public class PersonalDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input data
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter gender (M/F): ");
        char gender = scanner.next().charAt(0);

        System.out.print("Enter year of birth: ");
        int yearOfBirth = scanner.nextInt();

        // Menutup scanner setelah selesai
        scanner.close();

        // Menghitung usia berdasarkan tahun lahir
        int currentYear = LocalDate.now().getYear();
        int age = currentYear - yearOfBirth;

        // Menentukan gender dari input
        String genderStr;
        if (gender == 'M' || gender == 'm') {
            genderStr = "Male";
        } else if (gender == 'F' || gender == 'f') {
            genderStr = "Female";
        } else {
            genderStr = "Unknown";
        }

        // Output data pengguna
        System.out.println("\nPersonal Data:");
        System.out.println("Name    : " + name);
        System.out.println("Gender  : " + genderStr);
        System.out.println("Age     : " + age + " years");
    }
}

