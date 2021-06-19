package org.hthu.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

import javax.management.RuntimeErrorException;

/**
 *
 * @author 小明
 * 往TreeSet集合中存储自定义对象学生;想按照学生的年龄进行排序
 */
class Student implements Comparable{//该接口强制比较性
    private String name;
    private int age;
    Student(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Student)){
            return false;
        }
        Student p = (Student) obj;
        System.out.println(this.name+"-equals--"+p.name);
        return this.name.equals(p.name) && this.age==p.age;
    }

    @Override
    public int hashCode() {
        System.out.println(this.name+"...hashcode...");
        //return 60;
        return name.hashCode()+age;
    }
    @Override
    public int compareTo(Object obj) {
        if(!(obj instanceof Student)){
            throw new RuntimeException("不是学生")	;
        }

        Student s = (Student) obj;

        System.out.println(this.name +" comp.."+s.name);
        if(this.age >s.age){
            return 1;
        }

        if(this.age==s.age){
            return this.name.compareTo(s.name);
        }

        return -1;
    }

}
public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Student> hs = new TreeSet<Student>();
        hs.add(new Student("zhangsan", 20));
        hs.add(new Student("lisi", 30));
        hs.add(new Student("lisi01", 40));
        hs.add(new Student("xiao", 50));
        hs.add(new Student("xiao", 51));
        hs.add(new Student("xiao003", 50));
        hs.add(new Student("xiao001", 50));

        System.out.println("===================================");
        Iterator<Student> iterator = hs.iterator();
        while(iterator.hasNext()){
            Student p = iterator.next();
            System.out.println(p.getName()+"   "+p.getAge());
        }

//        ConcurrentHashMap
    }
}
