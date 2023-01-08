package serviceTest;

import mapper.ContactMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Contact;
import service.ContactServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ContactServiceImplTest {

    @Test
    public void testSelectAll(){

        ContactMapper mapper = mock(ContactMapper.class);

        List<Contact> expectedContacts = Arrays.asList(
                new Contact(1, "John","smith","111","email1"),
                new Contact(1, "hey","jode","222","email2")
        );
        when(mapper.selectAll()).thenReturn(expectedContacts);
        List<Contact> actualContacts = mapper.selectAll();
        // Verify that the selectAll method returns the expected list of contacts
        assertEquals(expectedContacts, actualContacts);


    }

    @Test
    public void testAdd(){
        ContactServiceImpl c = new ContactServiceImpl();
        Contact contact1 = new Contact(1,"kobe","bryant","111","usa@");
        c.add(contact1);

    }

    @Test
    public void testUpdate(){
        ContactServiceImpl c = new ContactServiceImpl();
        Contact contact1 = new Contact(2,"leo","messi","10","Argentina@");
        c.update(contact1);

    }

    @Test
    public void testDeleteByIds(){
        ContactServiceImpl c = new ContactServiceImpl();
        int[] ids = {20,21};
        c.deleteByIds(ids);
    }

    @Test
    public void testSelectByCondition(){
        ContactServiceImpl c = new ContactServiceImpl();
        Contact contact = new Contact();
        contact.setFirstName("c");
        Contact cc = new Contact(22,"cc","cc","cc","cc");
        List<Contact> actulList = c.selectByCondition(contact);
        List<Contact> expectedList = new ArrayList<>();
        expectedList.add(cc);
        assertEquals(actulList.toString(),expectedList.toString());
    }


    @Test
    public void testDelete(){
        ContactServiceImpl c = new ContactServiceImpl();
        int id = 22;
        c.delete(id);
    }




}
