package Ex2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StoreImplementerBinary implements ContactsStorageInterface{
    private String pathfileString;

    public StoreImplementerBinary(String pathfileString){
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
            contactsData = contactsData + convertStringToBinary(contact.getName() + "\t" + contact.getNumber()) + "\n";
        }
        try {
            File txtFile = new File(pathfileString + "Binary");
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
    public static String convertStringToBinary(String input) {
        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result.append(String.format("%8s", Integer.toBinaryString(aChar)).replaceAll(" ", "0"));
        }
        return result.toString();
    }
}