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
/**
 * this class is used for dealing with http request and respons when updating a contact record
 *
 * use alibaba's  fastjson to convert a string(JSON) to a contact object and update it to database
 */
@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    private ContactService contactService = new ContactServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        Contact contact = JSON.parseObject(params, Contact.class);
        contactService.update(contact);
        response.getWriter().write("success");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);
    }
}
