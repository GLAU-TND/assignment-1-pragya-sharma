


public class ContactList {
    private Person head;
    private int contactLintLength;

    /*
     *   initialize of instance for contactsList
     */
    public ContactList() {
        head = null;
        contactLintLength = 0;
    }

    // method to add firstName,lastName,contactNumber,anotherContactNumber,emailAddress and anotherEmailAddress in String form
    public void addInContactsLast(String firstName, String lastName, String contactNumber, String anotherContactNumber, String emailAddress) {
        Person current = head;
        Person previous = null;
        Person newNode = new Person();

        /*
         setting the data
         */
        newNode.setFirstName(firstName);
        newNode.setLastName(lastName);
        newNode.setContactNumber(contactNumber);
        newNode.setAnotherNumber(anotherContactNumber);
        newNode.setEmail_Address(emailAddress);

        if (isEmpty()) {
            head = newNode;
            contactLintLength++;
        } else {

            /*
             compare firstName of entries for priority by first letter in firstName
             */
            for (int i = 0; i < contactLintLength; i++) {
                String[] ourNames1 = current.getFirstName().split(" ");
                String[] ourNames2 = newNode.getFirstName().split(" ");

                int result = ourNames1[ourNames1.length - 1].compareToIgnoreCase(ourNames2[ourNames2.length - 1]);

                /*
                 *  if First Name entered goes before what's stored in the head,
                 *  new entry becomes the head
                 */
                if (result > 0) {
                    if (previous == null) {
                        newNode.setNext(current);
                        head = newNode;
                        contactLintLength++;
                        break;
                    }
                    /*
                     *   this section cycles through the "body" of the nodes if
                     *   it's not the tail
                     */
                    previous.setNext(newNode);
                    newNode.setNext(current);
                    contactLintLength++;
                    break;
                } else
                    /*
                     *  if the entry replaces node at the tail,
                     *  this entry becomes the new tail
                     */ {
                    if (current.getNext() == null) {
                        current.setNext(newNode);
                        newNode.setNext(null);
                        contactLintLength++;
                        break;
                    }
                    previous = current;
                    current = current.getNext();
                }
            }
        }
    }

    /*
     *  method to use if the linked list is empty
     */
    public boolean isEmpty() {
        return (contactLintLength == 0);
    }

    /*
     *  method to printContactsList
     */
    public void printContactsList() {
        Person tempNode = head;
        if (head == null) {
            System.out.println("OPPss!!  The list is empty!");
        } else {
            for (int i = 0; i < contactLintLength; i++) {
                System.out.print("-------- * -------- * -------- * --------");
                //System.out.print("Contact No. " + (i + 1));
                System.out.println(tempNode);
                tempNode = tempNode.getNext();
                System.out.println("-------- * -------- * -------- * --------");
            }

        }
        System.out.println();
    }

    /*
     *  method used to search through the names in the string
     */
    public void searchByFirstName(String firstName) {
        Person current = head;
        boolean empty = true;
        if (isEmpty()) {
            System.out.println("OPPss!!  The list is empty!");
        } else {
            for (int i = 0; i < contactLintLength; i++) {
                if (current.getFirstName().toLowerCase().contains(firstName.toLowerCase())) {
                    System.out.println((i + 1) + " match found!");
                    System.out.print("-------- * -------- * -------- * --------");
                    System.out.println(current);
                    //current = current.getNext();
                    System.out.println("-------- * -------- * -------- * --------");
                    empty = false;
                }
                // go to the next node
                current = current.getNext();
            }
            /*
             * if condition for contact doesn't found
             */
            if (empty) {
                System.out.println("NO RESULTS FOUND!");
            }
        }

    }

    /*
     *   method to delete contact by using index concept
     */
    public void displayContactsName() {
        Person current = head;
        System.out.println("Here are all your contacts:");
        for (int i = 0; i < contactLintLength; i++) {
            System.out.println((i + 1) + ". " + current.getFirstName() + " " + current.getLastName());
            current = current.getNext();
        }
    }

    public void deleteFromContactsList(int index) {
        Person current = head;
        Person previous = null;
        boolean empty = true;
        if (isEmpty()) {
            System.out.println("***************************************\n|    OPPss!!  The list is empty!      |\n***************************************\n");
        } else {
            for (int i = 0; i < contactLintLength; i++) {
                if ((index - 1) == i) {
                    if (previous == null) {
                        head = head.getNext();
                        contactLintLength--;
                        empty = false;
                        break;
                    } else if (current.getNext() == null) {
                        previous.setNext(null);
                        contactLintLength--;
                        empty = false;
                        break;
                    } else {
                        previous.setNext(current.getNext());
                        contactLintLength--;
                        empty = false;
                        break;
                    }
                } else {
                    previous = current;
                    current = current.getNext();
                }
            }
            if (empty) {
                System.out.println("Contact Not Found");
            } else {
                /*
                 * Notification of Successfully deletion of Contacts
                 */
                System.out.println(current.getFirstName() + " " + current.getLastName() + "'s contact deleted from list!");
            }
        }
    }
}