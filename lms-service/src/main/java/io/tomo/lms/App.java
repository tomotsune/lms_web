package io.tomo.lms;

import io.tomo.lms.entity.User;
import io.tomo.lms.exception.UsernameExistException;
import io.tomo.lms.factory.ObjectFactory;
import io.tomo.lms.service.UserService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws UsernameExistException {
        UserService userService = (UserService) ObjectFactory.getObject("userService");
        User reader_2 = new User("004",1);
        userService.register(reader_2);

        System.out.println("-----!!!!-----");
        System.out.println(userService.findAll());
        System.out.println("-----!!!!-----");
    }
}
