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
 * this class is used for dealing with http request and respons when deleting a specific contact record
 *
 * use alibaba's  fastjson to convert a string to a contact object
 */
@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    private ContactService contactService = new ContactServiceImpl();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        System.out.println(params);//
        Integer id = JSON.parseObject(params, Integer.class);
        contactService.delete(id);
        response.getWriter().write("success");

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
