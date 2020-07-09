package cn.tedu.algorithm.array;

/**
 * @Date 2020/7/7 0:26
 * @Created by liukaihua
 */
public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static void main(String[] args) {
        Array<Student> array = new Array<>();
        array.addLast(new Student("Alice",100));
        array.addLast(new Student("Bob",66));
        array.addLast(new Student("Charlie",88));
        System.out.println(array.toString());
    }
}
