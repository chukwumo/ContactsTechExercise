package dao;

import model.CallListEntry;
import model.Contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactDaoImpl implements ContactDao {

    // Simulate a database by using a Map.
    // This does have the issue of entries resetting each time it is run.
    Map<Long, Contact> contacts;
    long tableId;

    public ContactDaoImpl() {
        contacts = new HashMap<>();
        tableId = 0;
    }

    public void insertOrUpdateContact(Contact contact, Long id) {
        if (id == null) {
            if (contact.getId() == null) {
                contact.setId(tableId);
                contacts.put(tableId, contact);
                tableId++;
            } else {
                if (!contacts.containsKey(id)) {
                    contacts.put(contact.getId(), contact);
                }
            }
        } else {
            if (contacts.containsKey(id)) {
                contact.setId(id);
                contacts.put(id, contact);
            }
        }
    }

    public void deleteContact(Long id) {
        contacts.remove(id);
    }

    public List<Contact> getContacts() {
        return new ArrayList<>(contacts.values());
    }

    public Contact getContact(Long id) {
        return contacts.get(id);
    }

    public List<CallListEntry> getCallList() {
        List<CallListEntry> callList = new ArrayList<>();
        for (Contact c : contacts.values()) {
            for (int i = 0; i < c.getPhoneNumbers().size(); i++) {
                if (c.getPhoneNumbers().get(i).getType().equals("home")) {
                    callList.add(new CallListEntry(c.getName(), c.getPhoneNumbers().get(i).
                            getNumber()));
                    break;
                }
            }
        }

        return callList;
    }
}
