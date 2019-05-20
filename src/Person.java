/**
 * @ClassName Person
 * @Description TODO
 * @Author 曹博
 * @Date 2019/5/16 17:34
 * @Version 1.0
 */
public class Person {
    String name;
    int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
