
package com.tenzin.classroster.service;

import com.tenzin.classroster.dao.ClassRosterDao;
import com.tenzin.classroster.dao.ClassRosterPersistenceException;
import com.tenzin.classroster.dto.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tenzin Woesel
 * Jun 1, 2020
 */
public class ClassRosterDaoStubImpl implements ClassRosterDao{
    
    public Student onlyStudent;
    
    public ClassRosterDaoStubImpl(){
        onlyStudent = new Student("0001");
        onlyStudent.setFirstName("Ada");
        onlyStudent.setLastName("Lovelace");
        onlyStudent.setCohort("Java-May-1845");
    }
    
    public ClassRosterDaoStubImpl(Student testStudent){
        this.onlyStudent = testStudent;
    }
    
    @Override
    public Student addStudent(String studentId, Student student) throws ClassRosterPersistenceException{
        
        if(studentId.equals(onlyStudent.getStudentId())){
            return onlyStudent;
        }else{
            return null;
        }
    }
    
    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException{
        List<Student> studentList = new ArrayList<>();
        studentList.add(onlyStudent);
        return studentList;
    }
    
    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException{
        
        if(studentId.equals(onlyStudent.getStudentId())){
            return onlyStudent;
        }else{
            return null;
        }
    }
    
    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException{
        
        if(studentId.equals(onlyStudent.getStudentId())){
            return onlyStudent;
        }else{
            return null;
        }
    }
    

}
