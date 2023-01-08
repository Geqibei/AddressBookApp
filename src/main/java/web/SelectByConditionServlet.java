package web;

import com.alibaba.fastjson.JSON;
import pojo.Contact;
import service.ContactService;
import service.ContactServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
/**
 * this class is used for dealing with http request and respons when searching some contact records
 *
 * use alibaba's  fastjson to convert a string to a contact object, and get a list of contacts based on this object,
 * then convert the list to string(JSON) and pass it to html.
 */
@WebServlet("/selectByConditionServlet")
public class SelectByConditionServlet extends HttpServlet {
    private ContactService contactService = new ContactServiceImpl();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        System.out.println(params);
        Contact contact = JSON.parseObject(params, Contact.class);
        System.out.println(contact);//
        List<Contact> contacts = contactService.selectByCondition(contact);
        System.out.println(contacts);//
        String jsonString = JSON.toJSONString(contacts);
        System.out.println(jsonString);
        response.getWriter().write(jsonString);


    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);
    }
}
