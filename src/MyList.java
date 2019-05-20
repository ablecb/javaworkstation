import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName MyList
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/16 17:33
 * @Version 1.0
 */
public class MyList {
    public static void main(String[] args) {
        Person person=new Person("1",1);
        Person person1=new Person("2",2);
        Person person2=new Person("3",3);
        List<Person> list=new ArrayList();
        list.add(person);
        list.add(person1);
        list.add(person2);
        for (Person person3:
             list) {
            if(person3.getId()==3)
                person3.setId(88);
        }
        System.out.println(list.get(2).getId());
    }
}
