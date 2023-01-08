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
import java.io.IOException;
import java.util.List;
/**
 * this class is used for dealing with http request and respons when showing all contact records
 *
 * use alibaba's  fastjson to convert a list of contacts to a string, and pass the string to html to show data
 */
@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {

    private ContactService contactService = new ContactServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Contact> contacts = contactService.selectAll();
        String jsonString = JSON.toJSONString(contacts);
        response.getWriter().write(jsonString);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);
    }
}
