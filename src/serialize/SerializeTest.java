package serialize;

import java.io.*;
import java.util.List;

/**************
* @Author LDN
* @Date 16:35 2020/6/8
* @Description 序列化
 * 1. 理解serialVersionUID的一致性问题
 * 2. transient关键字修饰的作用
**************/
public class SerializeTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 1. 序列化：将对象写入文件中
        Person person = new Person("Tom", 23);
        FileOutputStream fos = new FileOutputStream("out.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(person);
        oos.close();
        fos.close();

        // 2. 反序列化：从文件中读出对象
        FileInputStream fis = new FileInputStream("out.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Person person1 = (Person)ois.readObject();
        ois.close();
        fis.close();
        System.out.println("Name:"+person1.getName()+"\nAge:"+person1.getAge());

        Family family = new Family();
        Person p1 = new Person("父亲", 56);
        Person p2 = new Person("儿子", 34);
        family.addMember(p1);
        family.addMember(p2);
        fos = new FileOutputStream("out.txt");
        oos = new ObjectOutputStream(fos);
        oos.writeObject(family);
        oos.close();
        fos.close();

        fis = new FileInputStream("out.txt");
        ois = new ObjectInputStream(fis);
        Family family11 = (Family)ois.readObject();
        ois.close();
        fis.close();
        System.out.println("Count:"+family11.getCount());//transient修饰的count，没有进行序列化
        Person p3 = family11.getMember().get(0);
        System.out.println("Name:"+p3.getName()+"\nAge:"+p3.getAge());
        Person p4 = family11.getMember().get(1);
        System.out.println("Name:"+p4.getName()+"\nAge:"+p4.getAge());




    }
}
