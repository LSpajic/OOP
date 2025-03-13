package hr.fer.oop.ZI2024.zad3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class STEMGames {
    List<Student> students;

    public STEMGames() {
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(String name, int pointsEng, int pointsMath){
        students.add(new Student(name,pointsEng,pointsMath));
    }

    public int getHighestScoreInEng(){
        int max = 0;
        for (Student student : students){
            if (student.getPointsEng() > max){
                max = student.getPointsEng();
            }
        }
        return max;
    }

    public int getHighestScoreInMath(){
        int max = 0;
        for (Student student : students){
            if (student.getPointsMath() > max){
                max = student.getPointsMath();
            }
        }
        return max;
    }
    public int getHighestScoreInTotal(){
        int max = 0;
        for (Student student : students){
            if (student.getTotalPoints() > max){
                max = student.getTotalPoints();
            }
        }
        return max;
    }
    public Map<String, List<String>> getTopStudents(){
        Map<String, List<String>> mapa = new HashMap<>();
        List<String> lista = new ArrayList<>();
        List<String> lista1 = new ArrayList<>();
        List<String> lista2 = new ArrayList<>();

        int math = 95;
        int eng = 95;
        int total = 190;
        for (Student student : students){
            if (student.getPointsMath() >= math){
                lista.add(student.getName());
                mapa.put("math", lista);
            }
            if (student.getPointsEng() >= eng){
                lista1.add(student.getName());
                mapa.put("eng",lista1);
            }
            if (student.getTotalPoints() >= total){
                lista2.add(student.getName());
                mapa.put("total",lista2);
            }
        }
        return mapa;
    }

    public int getTopEngStudentCount(int threshold) {
        int num = 0;
        for (Student student : students){
            if (student.getPointsEng() >= threshold){
                num +=1;
            }
        }
        return num;
    }

    public int getTopMathStudentCount(int threshold) {
        int num = 0;
        for (Student student : students){
            if (student.getPointsMath() >= threshold){
                num +=1;
            }
        }
        return num;
    }

    public int getTopTotalStudentCount(int threshold) {
        int num = 0;
        for (Student student : students){
            if (student.getPointsMath()+student.getPointsEng() >= threshold){
                num +=1;
            }
        }
        return num;
    }
}
