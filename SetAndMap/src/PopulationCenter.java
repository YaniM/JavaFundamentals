import java.util.*;

public class PopulationCenter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String,LinkedHashMap<String,Long>> map = new LinkedHashMap<>();

        while (true)
        {
            String[] input = scanner.nextLine().split("\\|");

            if(input[0].equals("report"))
            {
                break;
            }

            String city = input[0];
            String country = input[1];
            Long population = Long.parseLong(input[2]);

            LinkedHashMap<String,Long> temp = new LinkedHashMap<>();

            if(map.containsKey(country))
            {
                temp=map.get(country);
            }

            if(temp.containsKey(city))
            {
                temp.put(city,temp.get(city)+population);
            }else
            {
                temp.put(city,population);
            }

            map.put(country,temp);
        }

        for (String country : map.keySet()) {
            Collection<Long> totalPopulation = map.get(country).values();
            long sum = 0;
            for (Long count : totalPopulation) {
                sum+=count;
            }
            System.out.println(String.format("%s (total population: %d)",country,sum));
        }


        System.out.println();

    }
}
