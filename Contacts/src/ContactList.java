public class ContactList {
    private Person head;
    private int ContactListSize;

    public ContactList() {
        head = null;
        ContactListSize = 0;
    }

    public void aaInContactList(String firstName, String lastName, String contactNumber, String anotherContactNumber, String email) {
        Person current = head;
        Person previous = null;
        Person newNode = new Person();
        newNode.setFirstName(firstName);
        newNode.setLastName(lastName);
        newNode.setContactNumber(contactNumber);
        newNode.setAnotherNumber(anotherContactNumber);
        newNode.setEmail_Address(email);
        if (isEmpty()) {
            head = newNode;
        } else {
            for (int i = 0; i < ContactListSize; i++) {
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
                        ContactListSize++;
                        break;
                    }
                    /*
                     *   this section cycles through the "body" of the nodes if
                     *   it's not the tail
                     */
                    previous.setNext(newNode);
                    newNode.setNext(current);
                    ContactListSize++;
                    break;

                } else
                    /*
                     *  if the entry replaces node at the tail,
                     *  this entry becomes the new tail
                     */ {
                    if (current.getNext() == null) {
                        current.setNext(newNode);
                        newNode.setNext(null);
                        ContactListSize++;
                        break;
                    }
                    previous = current;
                    current = current.getNext();
                }
            }
        }
    }

    public boolean isEmpty() {
        return (ContactListSize == 0);
    }

    /*
     *  method to printContactsList
     */
    public void printContactsList() {
        Person tempNode = head;
        if (head == null) {
            System.out.println("The list is empty!");
        } else {
            for (int i = 0; i < ContactListSize; i++) {
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
            System.out.println(" The list is empty! ");
        } else {
            for (int i = 0; i < ContactListSize; i++) {
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
        for (int i = 0; i < ContactListSize; i++) {
            System.out.println((i + 1) + ". " + current.getFirstName() + " " + current.getLastName());
            current = current.getNext();
        }
    }

    public void deleteFromContactsList(int index) {
        Person current = head;
        Person previous = null;
        boolean empty = true;
        if (isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            for (int i = 0; i < ContactListSize; i++) {
                if ((index - 1) == i) {
                    if (previous == null) {
                        head = head.getNext();
                        ContactListSize--;
                        empty = false;
                        break;
                    } else if (current.getNext() == null) {
                        previous.setNext(null);
                        ContactListSize--;
                        empty = false;
                        break;
                    } else {
                        previous.setNext(current.getNext());
                        ContactListSize--;
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

