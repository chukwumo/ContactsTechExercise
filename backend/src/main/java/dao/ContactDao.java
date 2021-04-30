package dao;

import model.CallListEntry;
import model.Contact;

import java.util.List;

public interface ContactDao {
    void insertOrUpdateContact(Contact contact, Long id) ;
    void deleteContact(Long id);
    Contact getContact(Long id);
    List<Contact> getContacts();
    List<CallListEntry> getCallList();
}
