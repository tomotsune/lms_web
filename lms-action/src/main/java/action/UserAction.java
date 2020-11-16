package action;

import io.tomo.lms.entity.User;
import io.tomo.lms.exception.UsernameExistException;
import io.tomo.lms.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/regist")
public class UserAction extends HttpServlet {

    //获取ioC容器, 读取配置文件, 初始化Spring上下文.
    ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    //根据id获取容器中的bean
    UserService userService = (UserService) ac.getBean("userService");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/regist.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        User user = new User(id, pwd);
        try {
            userService.register(user);
            req.getRequestDispatcher("/WEB-INF/views/success.jsp").forward(req, resp);

        } catch (UsernameExistException e) {
            e.printStackTrace();
        }

    }
}
