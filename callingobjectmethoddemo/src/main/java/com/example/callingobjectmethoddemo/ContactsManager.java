package com.example.callingobjectmethoddemo;

/**
 * Program for a contact manager which stores the name of contacts and their details such as;
 * phone numbers and mail address and returns the name of a particular called or when searched
 */

public class ContactsManager {

    //Fields for the Contact Manager
    Contact[] myFriends;
    int friendsCount;

    // Constructor
    ContactsManager() {
        this.friendsCount = 0;
        this.myFriends = new Contact[500];
    }

    //Add Contact and update the count
    void addContact(Contact contact) {
        myFriends[friendsCount] = contact;
        friendsCount++;
    }

    //Search for contact in the list and return the name
    Contact searchContact(String searchName) {
        for (int i = 0; i < friendsCount; i++) {
            if (myFriends[i].name.equals(searchName)) {
                return myFriends[i];
            }
        }
        return null;
    }

}

/**
 * Contact details class
 */
class Contact {
    String name;
    String email;
    String phoneNumber;
}

/**
 * Main class to execute the program
 */
class Main {

    public static void main(String[] args) {

        ContactsManager myContactManager = new ContactsManager();

        //Create a new Contact object for James
        Contact info0 = new Contact();

        //set the contact's fields
        info0.name = "James Lolly";
        info0.phoneNumber = "0823456784";
        info0.email = "jameslolly@mail.com";

        //adding the contact to ContactManager
        myContactManager.addContact(info0);

        //Create a new Contact Object for Tobz
        Contact info1 = new Contact();
        //set the fields
        info1.name = "Tobz Green";
        info1.phoneNumber = "058666445";
        info1.email = "tobz@mail.com";

        //adding the Contact to the ContactManager
        myContactManager.addContact(info1);

        //Create a new Contact Object for Stones
        Contact info2 = new Contact();
        //set the fields
        info2.name = "Stones Mandy";
        info2.phoneNumber = "0998776553";
        info2.email = "stonesmandy@mail.com";

        //adding the Contact to the ContactManager
        myContactManager.addContact(info2);

        Contact result = myContactManager.searchContact("Israel Benjamin");
        System.out.println(result.phoneNumber);
    }

}
