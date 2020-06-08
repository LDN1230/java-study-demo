package serialize;

import java.io.Serializable;

/**************
* @Author LDN
* @Date 15:15 2020/6/8
* @Description Person实体类
**************/
public class Person implements Serializable {
    // 序列号：序列化和反序列化时的序列号必须一致
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;

    public Person(String name, int age){
        this.age = age;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }
}
