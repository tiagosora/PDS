package Ex2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoreImplementerTXT implements ContactsStorageInterface{
    private String pathfileString;

    public StoreImplementerTXT(String pathfileString){
        this.pathfileString = pathfileString;
    }

    @Override
    public List<Contact> loadContacts() {
        List<Contact> contacts = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(pathfileString));
            while(sc.hasNextLine()){
                String[] lineSplinted = sc.nextLine().split("\t");
                contacts.add(new Contact(lineSplinted[0], Integer.parseInt(lineSplinted[1])));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found during contacts loading!");
            e.printStackTrace();
        }
        return contacts;
    }

    @Override
    public boolean saveContacts(List<Contact> list) {
        String contactsData = "";
        for (Contact contact : list) {
            contactsData = contactsData + contact.getName() + "\t" + contact.getNumber() + "\n";
        }
        try {
            File txtFile = new File(pathfileString + "TXT");
            txtFile.createNewFile();
            FileWriter writer = new FileWriter(txtFile);
            writer.write(contactsData);
            writer.close();
            return true;
        } catch (IOException e) {
            System.out.println("File not found during contacts saving!");
            e.printStackTrace();
            return false;
        }
    }
    
}
