import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ContactList newList = new ContactList();
        int userPressed = 0;
        String option;
        boolean bye = false;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Welcome to Rakesh's Contact List App\n" +
                    "Press 1 to add a new contact\n" +
                    "Press 2 to view all contacts\n" +
                    "Press 3 to search for a contact\n" +
                    "Press 4 to delete a contact\n" +
                    "Press 5 to exit program ");
            try {
                userPressed = scan.nextInt();
            } catch (Exception e) {
                System.out.println("An Error occurred " + e);
            }

            switch (userPressed) {

            }
        } while (!bye);
    }
}
