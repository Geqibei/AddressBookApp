package service;

import pojo.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> selectAll();

    void add(Contact contact);

    void update(Contact contact);


    void deleteByIds(int[] ids);

    List<Contact> selectByCondition(Contact contact);

    void delete(int id);
}
