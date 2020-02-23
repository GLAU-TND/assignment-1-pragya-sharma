
class Person {
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String anotherNumber;
    private String email_Address;
    private Person next;

    public Person() {
        next = null;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAnotherNumber() {
        return anotherNumber;
    }

    public void setAnotherNumber(String anotherNumber) {
        this.anotherNumber = anotherNumber;
    }

    public String getEmail_Address() {
        return email_Address;
    }

    public void setEmail_Address(String email_Address) {
        this.email_Address = email_Address;
    }

    public Person getNext() {
        return next;
    }

    public void setNext(Person next) {
        this.next = next;
    }

    /*
    @toString Override Method
     */
    public String toString() {
        return "\nFirst Name: " + firstName + "\nLast Name:" + lastName + "\nContact Number: " + contactNumber + " , " + anotherNumber + "\nEmail Address: " + email_Address;
    }
}
