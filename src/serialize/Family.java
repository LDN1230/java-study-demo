package serialize;

import java.io.Serializable;
import java.util.*;

/**************
* @Author LDN
* @Date 15:49 2020/6/8
* @Description Family实体类
**************/
public class Family implements Serializable {
    private static final long serialVersionUID = 2L;
    private transient int count = 2;
    private List<Person> member = new ArrayList<Person>();

    public void addMember(Person p){
        member.add(p);
    }

    public int getCount() {
        return count;
    }

    public List<Person> getMember(){
        return member;
    }
}
