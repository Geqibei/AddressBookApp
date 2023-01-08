package service;

import mapper.ContactMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.Contact;
import util.SqlSessionFactoryUtils;

import java.util.List;

/**
 * this class is used for executing sql to the database
 */

public class ContactServiceImpl implements ContactService{
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Contact> selectAll() {
        SqlSession sqlSession = factory.openSession();
        ContactMapper mapper = sqlSession.getMapper(ContactMapper.class);
        List<Contact> contacts = mapper.selectAll();
        sqlSession.close();
        return contacts;
    }

    @Override
    public void add(Contact contact) {
        SqlSession sqlSession = factory.openSession();
        ContactMapper mapper = sqlSession.getMapper(ContactMapper.class);
        mapper.add(contact);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void update(Contact contact) {
        SqlSession sqlSession = factory.openSession();
        ContactMapper mapper = sqlSession.getMapper(ContactMapper.class);
        mapper.update(contact);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = factory.openSession();
        ContactMapper mapper = sqlSession.getMapper(ContactMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<Contact> selectByCondition(Contact contact) {
        SqlSession sqlSession = factory.openSession();
        ContactMapper mapper = sqlSession.getMapper(ContactMapper.class);

        String firstName = contact.getFirstName();
        System.out.println(firstName);
        if(firstName != null && firstName.length() > 0){
            contact.setFirstName("%" + firstName + "%");
        }
        String lastName = contact.getLastName();
        if(lastName != null && lastName.length() > 0){
            contact.setLastName("%" + lastName + "%");
        }

        List<Contact> rows = mapper.selectByCondition(contact);
        sqlSession.close();
        return rows;
    }

    @Override
    public void delete(int id) {
        SqlSession sqlSession = factory.openSession();
        ContactMapper mapper = sqlSession.getMapper(ContactMapper.class);
        mapper.delete(id);
        sqlSession.commit();
        sqlSession.close();
    }
}
