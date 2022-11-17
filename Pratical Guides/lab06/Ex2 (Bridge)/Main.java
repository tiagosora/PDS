package Ex2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File f = new File("contacts.txt");
        f.createNewFile();
        FileWriter writer = new FileWriter(f);
        String baseContacts = "Raquel\t914567784\nTiago\t915463756\nJoão\t965473234\nAlberto\t123456789\n";
        writer.write(baseContacts);
        writer.close();

        StoreImplementerTXT contactsStore = new StoreImplementerTXT("contacts.txt"); // Initial txt storage
        ContactsImplementer contactsList = new ContactsImplementer();

        contactsList.openAndLoad(contactsStore);

        Contact t1 = new Contact("Roberta", 987654321);
        if(contactsList.add(t1)){
            System.out.println("Contact: " + t1.toString() + " added to the list!");
        } else {
            System.out.println("Something went wrong adding " + t1.toString());
        }

        if(contactsList.exist(t1)){
            System.out.println(t1.toString() + " belongs to the list!");
        } else {
            System.out.println(t1.toString() + " doesn't belongs to the list!");
        }

        Contact t2 = new Contact("Raquel", 914567784);
        if(contactsList.exist(t2)){
            System.out.println(t2.toString() + " belongs to the list!");
        } else {
            System.out.println(t2.toString() + " doesn't belongs to the list!");
        }

        if(contactsList.remove(t2)){
            System.out.println("Contact: " + t2.toString() + " removed from the list!");
        } else {
            System.out.println("Something went wrong removing " + t2.toString());
        }

        if(contactsList.exist(t2)){
            System.out.println(t2.toString() + " belongs to the list!");
        } else {
            System.out.println(t2.toString() + " doesn't belongs to the list!");
        }

        System.out.println("Searching for 'Tiago' in the list!");
        Contact searchResult = contactsList.getByName("Tiago");
        if(searchResult !=  null){
            System.out.println("Found this contact for 'Tiago': " + searchResult.toString());
        }

        contactsList.saveAndClose();
        StoreImplementerBinary contactsStoreBinary = new StoreImplementerBinary("contacts.txt");
        contactsList.saveAndClose(contactsStoreBinary);
        StoreImplementerJSON contactsStoreJSON = new StoreImplementerJSON("contacts.txt");
        contactsList.saveAndClose(contactsStoreJSON);
    }
}
