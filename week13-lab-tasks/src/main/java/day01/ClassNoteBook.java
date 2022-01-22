package day01;

import java.util.*;

public class ClassNoteBook {
    private Map<Student, List<Integer>> marks = new TreeMap<>();

    public void addStudent(Student student) {
        marks.computeIfAbsent(student, k -> new ArrayList<>());
    }

    public void addMark(int id, int mark) {
//        marks.get(new Student(id, null)).add(mark);
        marks.get(getStudentById(id)).add(mark);
    }

    public Student getStudentById(int id) {
        for (Student actual : marks.keySet()) {
            if (actual.getId() == id) {
                return actual;
            }
        }
        throw new IllegalArgumentException("Student not found");
    }

    public Map<Student, List<Integer>> getMarks() {
        return marks;
    }
}
