package com.tenzin.classroster.dao;

import com.tenzin.classroster.dto.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Tenzin Woesel May 10, 2020
 */
@Component
public class ClassRosterDaoFileImpl implements ClassRosterDao {

    private Map<String, Student> students = new HashMap<>();

    private final String ROSTER_FILE;
    @Autowired
    public ClassRosterDaoFileImpl() {
        ROSTER_FILE = "roster.txt";
    }

    public ClassRosterDaoFileImpl(String rosterTextFile) {
        ROSTER_FILE = rosterTextFile;
    }
    public static final String DELIMETER = "::";

    @Override
    public Student addStudent(String studentId, Student student)
            throws ClassRosterPersistenceException {
        loadRoster();
        Student newStudent = students.put(studentId, student);
        writeRoster();
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents()
            throws ClassRosterPersistenceException {
        loadRoster();
        return new ArrayList(students.values());
    }

    @Override
    public Student getStudent(String studentId)
            throws ClassRosterPersistenceException {
        loadRoster();
        return students.get(studentId);
    }

    @Override
    public Student removeStudent(String studentId)
            throws ClassRosterPersistenceException {
        loadRoster();
        Student removedStudent = students.remove(studentId);
        writeRoster();
        return removedStudent;
    }

    private Student unmarshallStudent(String studentAsText) {
        String[] studentTokens = studentAsText.split(DELIMETER);

        String studentId = studentTokens[0];

        Student studentFromFile = new Student(studentId);

        studentFromFile.setFirstName(studentTokens[1]);

        studentFromFile.setLastName(studentTokens[2]);

        studentFromFile.setCohort(studentTokens[3]);

        return studentFromFile;

    }

    private void loadRoster() throws ClassRosterPersistenceException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new ClassRosterPersistenceException("-_- Could not load roster data into memory.", e);
        }

        String currentLine;

        Student currentStudent;

        while (scanner.hasNextLine()) {

            currentLine = scanner.nextLine();

            currentStudent = unmarshallStudent(currentLine);

            students.put(currentStudent.getStudentId(), currentStudent);

        }
        scanner.close();
    }

    private String marshallStudent(Student aStudent) {

        String studentAsText = aStudent.getStudentId() + DELIMETER;

        studentAsText += aStudent.getFirstName() + DELIMETER;
        studentAsText += aStudent.getLastName() + DELIMETER;
        studentAsText += aStudent.getCohort() + DELIMETER;

        return studentAsText;
    }

    private void writeRoster() throws ClassRosterPersistenceException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new ClassRosterPersistenceException("Could not save student data.", e);
        }

        String studentAsText;

        List<Student> studentList = new ArrayList(students.values());

        for (Student currentStudent : studentList) {

            studentAsText = marshallStudent(currentStudent);

            out.println(studentAsText);

            out.flush();
        }
        out.close();
    }
}
