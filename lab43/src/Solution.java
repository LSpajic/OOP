
import java.util.*;

class Solution implements StudentScoreStatistics{

    Map<String, List<Integer>> studentScores = new LinkedHashMap<>();

    @Override
    public void addStudentScores(String student, Integer... scores) {
        if (!studentScores.containsKey(student)){
            studentScores.put(student, new LinkedList<>());
        }
        studentScores.get(student).addAll(List.of(scores));
    }

    @Override
    public Collection<String> getInsertionOrderedStudents() {
        return studentScores.keySet();
    }

    @Override
    public Collection<Integer> getNaturallySortedPointsForStudent(String student) {
        if (!studentScores.containsKey(student)){
            return null;
        }

        Collections.sort(studentScores.get(student));
        return studentScores.get(student);
    }
}
