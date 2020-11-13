package action;

import io.tomo.lms.entity.User;
import io.tomo.lms.exception.UsernameExistException;
import io.tomo.lms.service.UserService;
import io.tomo.lms.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/regist")
public class UserAction extends HttpServlet {

    private UserService userService=new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/regist.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        User user = new User(id, pwd);
        try {
            userService.register(user);
            req.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(req,resp);

        } catch (UsernameExistException e) {
            e.printStackTrace();
        }

    }
}
