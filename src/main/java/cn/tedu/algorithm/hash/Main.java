package cn.tedu.algorithm.hash;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Date 2020/9/16 21:01
 * @Created by liukaihua
 */
public class Main {
    public static void main(String[] args) {
        int a = 42;
        System.out.println(((Integer)a).hashCode());
        int b = -42;
        System.out.println(((Integer)b).hashCode());
        double c = 3.1415926;
        System.out.println(((Double)c).hashCode());
        String d = "imooc";
        System.out.println(d.hashCode());
        Student student = new Student(3,2,"KAIKAI","liu");
        System.out.println(student.hashCode());
        HashSet<Student> set = new HashSet<>();
        set.add(student);
        HashMap<Student,Integer> map = new HashMap<>();
        map.put(student,100);
        Student student2 = new Student(3,2,"KAIKAI","liu");
        System.out.println(student2.hashCode());
    }

}
