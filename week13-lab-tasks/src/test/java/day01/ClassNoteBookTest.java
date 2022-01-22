package day01;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ClassNoteBookTest {
    @Test
    void testClassNoteBook() {
        ClassNoteBook classNoteBook = new ClassNoteBook();

        classNoteBook.addStudent(new Student(1, "Anna"));
        classNoteBook.addStudent(new Student(3, "Cecil"));
        classNoteBook.addStudent(new Student(5, "Elek"));
        classNoteBook.addStudent(new Student(2, "Béla"));
        classNoteBook.addStudent(new Student(4, "Dániel"));

        classNoteBook.addMark(1, 2);
        classNoteBook.addMark(1, 4);
        classNoteBook.addMark(2, 3);
        classNoteBook.addMark(2, 5);
        classNoteBook.addMark(2, 1);

        Student student = new Student(2, "Kati");
        classNoteBook.addStudent(student);

        assertEquals(List.of(3, 5, 1), classNoteBook.getMarks().get(classNoteBook.getStudentById(2)));
        assertEquals(Collections.EMPTY_LIST, classNoteBook.getMarks().get(classNoteBook.getStudentById(3)));
        assertTrue(classNoteBook.getMarks().containsKey(student));
        assertEquals("Béla", classNoteBook.getStudentById(2).getName());
    }
}