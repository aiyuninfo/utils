import com.aiyun.utils.ListUtils;
import com.aiyun.utils.impl.ListUtilsImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by zhaoy on 2016/12/8.
 */
public class TestCase {
    public static void main(String[] args) {
        ManMapper manMapper = new ManMapper();
        List<String> list = new ArrayList<>();
        List<Person> personList = new ArrayList<>();
        Person person;
        for(int i = 0; i < 20; i++){
            list.add(i + "");
            person = new Person();
            person.setAge(i);
            person.setName("age of " + i + " person");
            personList.add(person);
        }
        ListUtilsImpl<String> list2 = new ListUtilsImpl<>(list);
        ListUtils<Boolean> list1 = list2.map(item -> item.contains("2"));
        Optional<List<String>> list3 = new ListUtilsImpl<>(list).map(item -> {
            if ("1".equals(item)) {
                return "it is 1 !!!!!!!!!!!";
            }
            return item;
        }).getList();
        Optional<List<String>> list4 = new ListUtilsImpl<>(personList).map(person1 -> person1.getName()).getList();
        Optional<List<Integer>> list6 = new ListUtilsImpl<>(personList).map(Person::getAge).getList();
        Optional<List<String>> list5 = list4.filter(strings -> !strings.contains("1"));
        list6.orElse(new ArrayList<>()).forEach(item -> {
            System.out.println(item);
        });
        ListUtils<Man> list7 = new ListUtilsImpl<>(personList).map(person1 -> manMapper.convertManFromPerson(person1));
        System.out.println(list7);
    }
}

class Person{
    private String name;
    private int age;

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
}

enum Sex{
    MALE,FEMALE
}

class Man{

    private String manName;
    private Sex sex;
    private int age;

    public String getManName() {
        return manName;
    }

    public void setManName(String manName) {
        this.manName = manName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class ManMapper{

    public Man convertManFromPerson(Person person){
        Man man = new Man();
        man.setAge(person.getAge());
        man.setSex(Sex.MALE);
        man.setManName(person.getName());
        return man;
    }

}