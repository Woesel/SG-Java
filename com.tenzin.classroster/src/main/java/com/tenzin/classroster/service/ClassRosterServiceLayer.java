package com.tenzin.classroster.service;

import com.tenzin.classroster.dao.ClassRosterPersistenceException;
import com.tenzin.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author Tenzin Woesel
 */
public interface ClassRosterServiceLayer {

    void createStudent(Student student) throws ClassRosterDuplicateIdException, ClassRosterDataValidationException, ClassRosterPersistenceException;

    List<Student> getAllStudent() throws ClassRosterPersistenceException;

    Student getStudent(String studentId) throws ClassRosterPersistenceException;

    Student removeStudent(String studentId) throws ClassRosterPersistenceException;

}
