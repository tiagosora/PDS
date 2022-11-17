package Ex2;
import java.util.ArrayList;

public class ContactsImplementer implements ContactsInterface{
    private ArrayList<Contact> contacts;
    private ContactsStorageInterface fileStorage;

    public ContactsImplementer(){
        this.contacts = new ArrayList<>();
    }
    @Override
    public void openAndLoad(ContactsStorageInterface store) {
        this.fileStorage = store;
        this.contacts.addAll(this.fileStorage.loadContacts());
        System.out.println("Contacts have been loaded!");
    }
    @Override
    public void saveAndClose() {
        if (this.fileStorage.saveContacts(contacts)) {
            System.out.println("Data Stored");
        } else {
            System.out.println("Data was not stored");
        }
    }
    @Override
    public void saveAndClose(ContactsStorageInterface store) {
        if (store.saveContacts(contacts)) {
            System.out.println("Data Stored");
        } else {
            System.out.println("Data was not stored");
        }
    }
    @Override
    public boolean exist(Contact contact) {
        for (Contact contactInList : contacts) {
            if(contactInList.getName().equals(contact.getName()) && contactInList.getNumber() == contact.getNumber()){
                return true;
            }
        }
        return false;
    }
    @Override
    public Contact getByName(String name) {
        for (Contact contact : this.contacts) {
            if(contact.getName().equals(name)){
                return contact;
            }
        }
        return null;
    }
    @Override
    public boolean add(Contact contact) {
        return this.contacts.add(contact);
    }
    @Override
    public boolean remove(Contact contact) {
        for (Contact contactInList : contacts) {
            if(contactInList.getName().equals(contact.getName()) && contactInList.getNumber() == contact.getNumber()){
                return this.contacts.remove(contactInList);
            }
        }
        return false;
    }
}