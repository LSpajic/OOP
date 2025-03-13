import java.util.*;

class Solution implements StudentDatabase{

    public Map<String, Map<String, Integer>> subjectStudentGrades = new LinkedHashMap<>();
    public Set<String> students = new LinkedHashSet<>();

    @Override
    public void addEntry(String student, String course, int score) {
        if (!subjectStudentGrades.containsKey(course)){
            subjectStudentGrades.put(course, new LinkedHashMap<>());
        }
        subjectStudentGrades.get(course).put(student, score);
        students.add(student);


    }



    @Override
    public Integer getScore(String student, String course) {
        return subjectStudentGrades.get(course).get(student);
    }

    @Override
    public Collection<String> getInsertionOrderedStudentsByCourse(String course) {
        return students;
    }
}
