package executors;

import reflection.Person;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoTask {
    ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {

    }

    private void a() {
        long time = System.currentTimeMillis();
        Person person = new Person("yuan",22);
        String name = "a";
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                show(person,name,time);
                System.out.println(person);
            }
        });
        executorService.shutdown();
    }

    public void show(Person person, String name, long time){
        System.out.println(person);
        person.setName("lina");
        System.out.println(person);
        System.out.println(time);
        System.out.println(name);
    }
}
