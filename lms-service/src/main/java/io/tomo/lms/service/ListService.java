package io.tomo.lms.service;
import java.util.List;
import io.tomo.lms.exception.BookNotFoundException;
import io.tomo.lms.exception.TableNotFoundException;
import io.tomo.lms.exception.UserNotFoundException;

public interface ListService {
    void lendBook(String id, int no, String op) throws BookNotFoundException, UserNotFoundException;

    void returnBack(int serialNo) throws TableNotFoundException, BookNotFoundException;

    List<io.tomo.lms.entity.List> findAll() throws TableNotFoundException;

    List<io.tomo.lms.entity.List> findId(String id) throws TableNotFoundException;

    List<io.tomo.lms.entity.List> findNo(int no) throws TableNotFoundException;

    io.tomo.lms.entity.List findSerialNo(int serialNo) throws TableNotFoundException;
}
