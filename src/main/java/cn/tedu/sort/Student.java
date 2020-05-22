package cn.tedu.sort;


/**
 * @Author lkh
 */
public class Student implements  Comparable<Student> {
    private String name;
    private int scores;
    public Student(){
        
    }

    public Student(String name, int scores) {
        this.name = name;
        this.scores = scores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public int compareTo(Student o) {
        return scores-o.scores;
    }

    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", scores=" + scores +
                '}';
    }
}
