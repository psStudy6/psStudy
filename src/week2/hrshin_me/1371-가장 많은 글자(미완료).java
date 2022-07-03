import java.util.Scanner;

import java.util.Scanner;

public class Main {
    private int [] alpha = new int[26];
    public void addSentence(String str){
        for (int c=0; c<str.length(); c++){
            int index = str.charAt(c) - 'a';
            alpha[index]++;
        }
    }
    public String solution(){
        String answer = "";
        int max = 0;
        for (int c=0; c<alpha.length; c++){
            if (alpha[c] > max) {
                max = alpha[c];
            }
        }

        for (int c=0; c<alpha.length; c++){
            if (alpha[c] == max){
                answer += (char)(c+'a');
            }
        }

        return answer;
    }

    public static void main(String [] args){
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line == null)
                break;

            if (line.isEmpty())
                break;

            line = line.replaceAll(" ", "");
            main.addSentence(line);
        }

        System.out.println(main.solution());
    }
}
