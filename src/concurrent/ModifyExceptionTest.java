package concurrent;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Administrator on 2016-6-21.
 */
public class ModifyExceptionTest {
    public static void test (){
        Collection<User> collection = new CopyOnWriteArrayList<>();
        collection.add(new User("张三"));
        collection.add(new User("李四"));
        collection.add(new User("王五"));
        Iterator<User> iterator = collection.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if("张三".equals(user.getName())){
                collection.remove(user);
            } else {
                System.out.println(user);
            }
        }
    }
}

class User {
    private String name;
    private String pwd;

    public User(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        return !(getPwd() != null ? !getPwd().equals(user.getPwd()) : user.getPwd() != null);

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getPwd() != null ? getPwd().hashCode() : 0);
        return result;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}