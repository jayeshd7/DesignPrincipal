import java.util.*;

public class JavaStreamExample {
    public static void main(String[] args) {

        String [] countries = {"India", "Switzerland","India", "Italy"};
        Integer [] number = {1,2,2,2,3};

        Set<String> set = new HashSet<String>(Arrays.asList(countries));

        Set<Integer> myset = new HashSet<Integer>(Arrays.asList(number));
        System.out.println(set);
        System.out.println(myset);


        List<String> list = new ArrayList<String>();

        list.add("India");
        list.add("Switzerland");
        list.add("Italy");
        list.add("France");

        String [] countrie = list.toArray(new String[list.size()]);

        for(String value  :countrie){

            System.out.println(value);
        }
        System.out.println(countrie);

    }
}