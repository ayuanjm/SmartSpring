
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo {
    public static void main(String[] arg){
        Map<String,Object> map = new HashMap<>();
        map.put("a",1);
        map.put("b","");
        Set<String> strings = map.keySet();
        System.out.println(map.keySet().toArray());
        for(String s : map.keySet()) {
            System.out.println(s + map.get(s));
        }

    }
}
