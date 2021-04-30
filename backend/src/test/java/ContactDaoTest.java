import dao.ContactDao;
import dao.ContactDaoImpl;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactDaoTest {
    private ContactDao contactDao;

    @BeforeEach
    public void setUp() throws Exception {
        contactDao = new ContactDaoImpl();
    }

    @Test
    public void testInsertContact() {
        Contact contact =
                new Contact(null, new Name(), new Address(), new ArrayList<>(), "");
        contactDao.insertOrUpdateContact(contact, null);
        assertEquals(1, contactDao.getContacts().size());

        Contact contactTwo =
                new Contact(0L, new Name(), new Address(), new ArrayList<>(), "");
        contactDao.insertOrUpdateContact(contactTwo, null);
        assertEquals(1, contactDao.getContacts().size());

        Contact contactThree =
                new Contact(1L, new Name(), new Address(), new ArrayList<>(), "");
        contactDao.insertOrUpdateContact(contactThree, null);
        assertEquals(2, contactDao.getContacts().size());

        Contact contactFour =
                new Contact(1L, new Name(), new Address(), new ArrayList<>(), "");
        contactDao.insertOrUpdateContact(contactFour, 1L);
        assertEquals(2, contactDao.getContacts().size());
    }

    @Test
    public void testDeleteContact() {
        Contact contact =
                new Contact(null, new Name(), new Address(), new ArrayList<>(), "");
        contactDao.insertOrUpdateContact(contact, null);
        contactDao.deleteContact(0L);
        assertEquals(0, contactDao.getContacts().size());

        contactDao.insertOrUpdateContact(contact, null);
        contactDao.deleteContact(null);
        assertEquals(1, contactDao.getContacts().size());
    }

    @Test
    public void testCallList() {
        List<Phone> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(new Phone("555-555-5555", "home"));
        Contact contact =
                new Contact(null, new Name(), new Address(), phoneNumbers, "");
        contactDao.insertOrUpdateContact(contact, null);

        Contact contactTwo =
                new Contact(null, new Name(), new Address(), new ArrayList<>(), "");
        contactDao.insertOrUpdateContact(contactTwo, null);

        List<CallListEntry> callList = contactDao.getCallList();
        assertEquals(1, callList.size());
    }
}
