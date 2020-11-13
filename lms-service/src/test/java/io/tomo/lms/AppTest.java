package io.tomo.lms;

import static org.junit.Assert.assertTrue;

import io.tomo.lms.entity.User;
import io.tomo.lms.exception.UserNotFoundException;
import io.tomo.lms.exception.UsernameExistException;
import io.tomo.lms.factory.ObjectFactory;
import io.tomo.lms.service.UserService;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    UserService userService = (UserService) ObjectFactory.getObject("userService");

    @Test
    public void mainTest() throws UsernameExistException, UserNotFoundException {
       /* User reader_4 = new User("004",1);
        User reader_5 = new User("005",1);*/

        System.out.println(userService.findAll());
        userService.removeById("005");
        System.out.println(userService.findAll());
        System.out.println("-----!!!!-----");

    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
}
