package web;

import com.alibaba.fastjson.JSON;
import pojo.Contact;
import service.ContactService;
import service.ContactServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * this class is used for dealing with http request and respons when adding a new contact record
 *
 * use alibaba's  fastjson to convert a string to a contact object
 */
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private ContactService contactService = new ContactServiceImpl();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        //System.out.println(params);//
        Contact contact = JSON.parseObject(params, Contact.class);
        //System.out.println(contact);//
        contactService.add(contact);
        response.getWriter().write("success");

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);
    }
}
