/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tenzin.classroster.service;

import com.tenzin.classroster.dao.ClassRosterPersistenceException;
import com.tenzin.classroster.dto.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author Tenzin Woesel
 */
public class ClassRosterServiceLayerImplTest {
    private ClassRosterServiceLayer service;
    
    public ClassRosterServiceLayerImplTest() {
//        ClassRosterDao dao = new ClassRosterDaoStubImpl();
//        ClassRosterAuditDao auditDao = new ClassRosterAuditDaoStubImpl();
//
//        service = new ClassRosterServiceLayerImpl(dao, auditDao);
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        service
                = ctx.getBean("serviceLayer", ClassRosterServiceLayer.class);
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testCreateValidStudent() {

        //Arrange
        Student student = new Student("0002");
        student.setFirstName("Charles");
        student.setLastName("Babbage");
        student.setCohort(".NET-May-1845");

        //ACT
        try {
            service.createStudent(student);
        } catch (ClassRosterDuplicateIdException | ClassRosterDataValidationException | ClassRosterPersistenceException e) {
            //ASSERT
            fail("Student was valid. No exception should have been thrown.");
        }

    }

    @Test
    public void testCreateDuplicateIdStudent() {
        //ARRANGE
        Student student = new Student("0001");
        student.setFirstName("Charles");
        student.setLastName("Babbage");
        student.setCohort(".NET-May-1845");

        //ACT
        try {
            service.createStudent(student);
            fail("Expected dupeId exception was not thrown.");
        } catch (ClassRosterDataValidationException | ClassRosterPersistenceException e) {
            //ASSERT
            fail("Incorrect exception was thrown.");
        } catch (ClassRosterDuplicateIdException e) {
            return;
        }
    }

    @Test
    public void testCreateStudentInvaliddDta() throws Exception {
        //ARRANGE
        Student student = new Student("0002");
        student.setFirstName("");
        student.setLastName("Babbage");
        student.setCohort(".NET-May-1845");

        //ACT
        try {
            service.createStudent(student);
            fail("Expected Validation was not thrown.");
        } catch (ClassRosterDuplicateIdException | ClassRosterPersistenceException e) {
            //ASSERT
            fail("Incorrect exception was thrown.");
        } catch (ClassRosterDataValidationException e) {
            return;
        }
    }

    @Test
    public void testGetAllStudents() throws Exception {
        //ARRANGE
        Student testClone = new Student("0001");
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setCohort("Java-May-1845");

        //ACT & ASSERT
        assertEquals(1, service.getAllStudent().size(), "Should only have one student.");
        assertTrue(service.getAllStudent().contains(testClone), "The one student should be Ada.");

    }

    @Test
    public void testGetStudent() throws Exception {
        //ARRANGE
        Student testClone = new Student("0001");
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setCohort("Java-May-1845");

        //ACT & ASSERT
        Student shouldBeAda = service.getStudent("0001");
        assertNotNull(shouldBeAda, "Getting 0001 should not be null.");
        assertEquals(testClone, shouldBeAda, "Student stored under 0001 should be Ada.");
    }

    @Test
    public void testRemoveStudent() throws Exception {

        //ARRANGE
        Student testClone = new Student("0001");
        testClone.setFirstName("Ada");
        testClone.setLastName("Lovelace");
        testClone.setCohort("Java-May-1845");

        //ACT & ASSERT
        Student shouldBeAda = service.removeStudent("0001");
        assertNotNull(shouldBeAda, "Removing 0001 should not be null");
        assertEquals(testClone, shouldBeAda, "Student removed from 0001 should be Ada.");

        Student shouldBeNull = service.removeStudent("0042");
        assertNull(shouldBeNull, "Removing 0042 should be null.");

    }

}
