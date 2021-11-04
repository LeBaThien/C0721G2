package controller;

import bean.customer.Customer;
import bean.customer.CustomerType;
import repository.impl.CustomerRepository;
import service.impl.CustomerService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customerServlet")
public class CustomerServlet extends HttpServlet {
    private CustomerRepository customerRepository = new CustomerRepository();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
//            case "edit":
//                try {
//                    update(request, response);
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//                break;
            case "edit":
                update(request, response);
                break;
            case "delete":
                delete(request, response);
//            default:
//                showList(request, response);
//                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "edit":
                showUpdate(request, response);
                break;
            case "delete":
                showDelete(request, response);
                break;
            default:
                showList(request, response);
                break;
//        }
        }
    }

    public void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList;
        customerList = customerRepository.showList();
//        for (Customer c:
//             customerList) {
//            System.out.println(c);
//        }
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer_jsp/customer.jsp");
        dispatcher.forward(request,response);
    }

    public void showCreate(HttpServletRequest request, HttpServletResponse response){
        List<CustomerType> customerTypeList ;
        customerTypeList = customerRepository.showCustomerType();
        request.setAttribute("customerType", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer_jsp/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    public void create(HttpServletRequest request, HttpServletResponse response) {
//        String customerType = request.getParameter("customerType");
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthDay");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
//
        int id = Integer.parseInt(request.getParameter("customerType"));
        Customer customer = new Customer(name, birthDay, gender,
                idCard, phone, address, new CustomerType(id));
        try {
            customerRepository.insert(customer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer_jsp/create.jsp");
//            request.setAttribute("message", "Da xoa");
            dispatcher.forward(request, response);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showUpdate(HttpServletRequest request, HttpServletResponse response){
//        List<Customer> customerList ;
        Customer customer = customerRepository.findById();
        request.setAttribute("customerType", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer_jsp/update.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void update(HttpServletRequest request, HttpServletResponse response){
//        String name = request.getParameter("name");
//        String birthDay = request.getParameter("birthDay");
//        String gender = request.getParameter("gender");
//        String idCard = request.getParameter("idCard");
//        String phone = request.getParameter("phone");
//        String address = request.getParameter("address");
////
//        int id = Integer.parseInt(request.getParameter("customerType"));
//        Customer customer = new Customer(name, birthDay, gender,
//                idCard, phone, address, new CustomerType(id));
        try {
//            customerRepository.insert(customer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer_jsp/update.jsp");
//            request.setAttribute("message", "Da xoa");
            dispatcher.forward(request, response);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showDelete(HttpServletRequest request, HttpServletResponse response){

    } public void delete(HttpServletRequest request, HttpServletResponse response){

    }

}
