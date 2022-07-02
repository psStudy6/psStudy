import java.util.*;

class Data implements Comparable<Data> {
    private String s;
    public Data(String s){
        this.s = s;
    }

    public String getS() {
        return s;
    }

    public int size(){
        return s.length();
    }

    @Override
    public int compareTo(Data o2) {
        if (size() == o2.size()){
            String a = getS();
            String b = o2.getS();

            if (a.equals(b))
                return 0;

            return (a.compareTo(b) < 0) ? -1 : 1;
        }
        return (size() < o2.size()) ? -1 : 1;
    }

    @Override
    public boolean equals(Object obj) {
        Data dt = (Data) obj;
        return getS().equals(dt.getS());
    }

    @Override
    public int hashCode() {
        return s.hashCode();
    }
}
public class Main {
    public List<String> solution(List<Data> arr){
        ArrayList<String> result = new ArrayList<>();

        Collections.sort(arr);
        for(Data d : arr){
            result.add(d.getS());
        }
        return result;
    }

    public static void main(String [] args){
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Set<Data> input = new HashSet<>();
        for (int c=0; c<n; c++){
            String s = scanner.nextLine();
            if (s.length() == 0)
                s = scanner.next();
            input.add(new Data(s));
        }

        ArrayList<Data> datas = new ArrayList<>();
        for (Data d : input){
            datas.add(d);
        }

        List<String> result = main.solution(datas);
        for (String r : result){
            System.out.println(r);
        }
    }
}
