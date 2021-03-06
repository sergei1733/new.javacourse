package com.company.dao;

import com.company.studentOrder.domain.*;
import com.company.studentOrder.exception.DaoException;
import org.junit.BeforeClass;
import org.junit.Test;
import java.time.LocalDate;
import java.util.List;

public class StudentOrderDaoImplTest {

    @BeforeClass
    public static void startup() throws Exception {
        DBinit.startUp();
    }

    @Test
    public void saveStudentOrder() throws DaoException {
        StudentOrder so = buildStudentOrder(10);
        long id = new StudentOrderDaoImpl().saveStudentOrder(so);
    }
    @Test(expected = DaoException.class)
    public void saveStudentOrderError() throws DaoException {
            StudentOrder so = buildStudentOrder(10);
            so.getHusband().setSorName(null);
            long id = new StudentOrderDaoImpl().saveStudentOrder(so);
    }

    @Test
    public void getStudentOrders() throws DaoException {
        List<StudentOrder> list = new StudentOrderDaoImpl().getStudentOrders();
    }

    public StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificateId("" + (123456000 + id));
        so.setMarriageDate(LocalDate.of(2016, 7, 4));
        RegisterOffice ro = new RegisterOffice(1l, "", "");
        so.setMarriageOffice(ro);

        Street street = new Street(1l, "First street");
        Address address = new Address("195000", street, "10", "2", "121");
        //муж
        Adult husband = new Adult("Васильев", "Павел", "Николаевич", LocalDate.of(1995, 3, 18));
        husband.setPassportSeria("" + (1000 + id));
        husband.setPassportNumber("" + (10000 + id));
        husband.setIssueDate(LocalDate.of(2017, 9, 15));
        PassportOffice po1 = new PassportOffice(1l, "", "");
        husband.setIssueDepartment(po1);
        husband.setStudentId("" + (10000 + id));
        husband.setAddress(address);
        husband.setUnivesity(new University(2L, ""));
        husband.setStudentId("HH12345");
        //жена
        Adult wife = new Adult("Васильева", "Ирина", "Петровна", LocalDate.of(1997, 8, 21));
        wife.setPassportSeria("" + (2000 + id));
        wife.setPassportNumber("" + (20000 + id));
        wife.setIssueDate(LocalDate.of(2018, 4, 5));
        PassportOffice po2 = new PassportOffice(2l, "", "");
        wife.setIssueDepartment(po2);
        wife.setStudentId("" + (20000 + id));
        wife.setAddress(address);
        wife.setUnivesity(new University(1L, ""));
        wife.setStudentId("WW12345");
        //ребенок
        Child child1 = new Child("Васильева", "Евгения", "павловна", LocalDate.of(2016, 1, 11));
        child1.setCertificateNumber("" + (30000 + id));
        child1.setIssueDate(LocalDate.of(2018, 6, 11));
        RegisterOffice ro2 = new RegisterOffice(2l, "", "");
        child1.setIssueDepartment(ro2);
        child1.setAddress(address);
        //ребенок
        Child child2 = new Child("Васильев", "Александр", "Павлович", LocalDate.of(2018, 11, 9));
        child2.setCertificateNumber("" + (40000 + id));
        child2.setIssueDate(LocalDate.of(2018, 7, 19));
        RegisterOffice ro3 = new RegisterOffice(3l, "", "");
        child2.setIssueDepartment(ro3);
        child2.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);

        return so;
    }
}