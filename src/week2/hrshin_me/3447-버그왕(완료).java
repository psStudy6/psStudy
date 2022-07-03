import java.util.Scanner;

public class Main {
    public String solution(String lines){
        while(lines.indexOf("BUG") >= 0){
            lines = lines.replace("BUG", "");
        }
      
        return lines;
    }
    public static void main(String [] args){
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            System.out.println(main.solution(line));
        }
    }
}
