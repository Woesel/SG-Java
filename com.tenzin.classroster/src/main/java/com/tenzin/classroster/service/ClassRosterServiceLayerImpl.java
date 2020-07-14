package com.tenzin.classroster.service;

import com.tenzin.classroster.dao.ClassRosterAuditDao;
import com.tenzin.classroster.dao.ClassRosterDao;
import com.tenzin.classroster.dao.ClassRosterPersistenceException;
import com.tenzin.classroster.dto.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Tenzin Woesel May 26, 2020
 */
@Component
public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer {

    ClassRosterDao dao;
    private ClassRosterAuditDao auditDao;
    @Autowired
    public ClassRosterServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void createStudent(Student student) throws ClassRosterDuplicateIdException, ClassRosterDataValidationException, ClassRosterPersistenceException {

        //Check to see if there is already a student associated with the given student's id
        //If so, throw ClassRosterDuplicateIdException
        if (dao.getStudent(student.getStudentId()) != null) {
            throw new ClassRosterDuplicateIdException(
                    "Error: could not create student. Student Id" + student.getStudentId() + " already exists");
        }

        //Validate all the fields on the given Student Object.
        //This menthod will throw an exception if any of the validation rules are violated.
        validateStudentData(student);

        //We passed allour business rules checks so go ahead and persist
        //the Student Object
        dao.addStudent(student.getStudentId(), student);

        //The student was successfully created, now write to the audit log
        auditDao.writeAuditEntry("Student " + student.getStudentId() + " CREATED.");
    }

    @Override
    public List<Student> getAllStudent() throws ClassRosterPersistenceException {
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        return dao.getStudent(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        Student removedStudent = dao.removeStudent(studentId);

        //Write to the audit log
        auditDao.writeAuditEntry("Student " + studentId + " REMOVED.");
        return removedStudent;
    }

    private void validateStudentData(Student student) throws ClassRosterDataValidationException {
        if (student.getFirstName() == null
                || student.getFirstName().trim().length() == 0
                || student.getLastName() == null
                || student.getLastName().trim().length() == 0
                || student.getCohort() == null
                || student.getCohort().trim().length() == 0) {
            throw new ClassRosterDataValidationException(
                    "Error: All fields{First Name, Last Name, Cohort} are required.");
        }
    }
}
