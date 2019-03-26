import java.util.*;

public class HandsOfCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Set<String>> map = new LinkedHashMap<>();

        while (true) {
            String[] params = scanner.nextLine().split(":");

            if (params[0].endsWith("JOKER")) {
                break;
            }

            String name = params[0];

            params=params[1].split("[,\\s+]+");
            System.out.println( );

            Set<String> set = new HashSet<>();

            if (map.keySet().contains(name)) {
                set = map.get(name);
            }

            for (int i = 1; i < params.length; i++) {
                set.add(params[i]);
            }

            map.put(name, set);
            
        }

        for (String name : map.keySet()) {
            Set<String> set = map.get(name);

            int sum = 0;

            for (String values : set) {
                String powerCH="";
                char typeCH='\0';
                if(values.length()==3)
                {   powerCH=values.substring(0,2);
                    typeCH=values.charAt(2);
                }else {
                    powerCH = values.charAt(0)+"";
                    typeCH = values.charAt(1);
                }

                int power=0;
                int type=0;

                switch (powerCH){
                    case "2":
                        power=2;
                        break;
                    case "3":
                        power=3;
                        break;
                    case "4":
                        power=4;
                        break;
                    case "5":
                        power=5;
                        break;
                    case "6":
                        power=6;
                        break;
                    case "7":
                        power=7;
                        break;
                    case "8":
                        power=8;
                        break;
                    case "9":
                        power=9;
                        break;
                    case "10":
                        power=10;
                        break;
                    case "J":
                        power=11;
                        break;
                    case "Q":
                        power=12;
                        break;
                    case "K":
                        power=13;
                        break;
                    case "A":
                        power=14;
                        break;
                }

                switch (typeCH)
                {
                    case 'S':
                        type=4;
                        break;
                    case 'H':
                        type=3;
                        break;
                    case 'D':
                        type=2;
                        break;
                    case 'C':
                        type=1;
                        break;
                }

                sum+=power*type;
            }
            System.out.println(String.format("%s: %d",name,sum));
        }
    }
}
