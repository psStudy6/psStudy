import java.util.*;

public class Main {
    public int solution(List<String> list){
        Map<Character, Character> map = new HashMap<>();
        int groupCount = 0;

        for (int c=0; c<list.size(); c++){
            String a = list.get(c);

            for (int d=c+1; d<list.size(); d++){
                if (c == d)
                    continue;

                String b = list.get(d);
                map.clear();

                boolean isChangable = true;
                for (int e=0; e<a.length(); e++){
                    char ac = a.charAt(e);
                    char bc = b.charAt(e);

                    if (map.containsKey(ac)){
                        char acKey = map.get(ac);
                        if (acKey != bc) {
                            isChangable = false;
                        }
                    }
                    else if (map.containsValue(bc)){
                        isChangable = false;
                    }

                    if (!isChangable)
                        break;

                    map.put(ac, bc);
                }

                if (isChangable)
                    groupCount++;
            }
        }

        return groupCount;
    }
    public static void main(String [] args){
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<String> list = new ArrayList<>();

        for (int c=0; c<n; c++){
            String s = scanner.nextLine();
            if (s.length() == 0)
                s = scanner.next();

            list.add(s);
        }

        System.out.println(main.solution(list));
    }
}
