package week6.soram;
import java.io.*;
import java.util.*;

public class IjC401 {
	public char solution(int n,String s) {
		char ans = ' ';
		HashMap<Character,Integer> map = new HashMap<>();
		for(char x : s.toCharArray()) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		//System.out.println(map.size());
		//System.out.println(map.remove('A'));
		//System.out.println(map.size());
		
		int max = Integer.MIN_VALUE;
		for(char key : map.keySet()) {
			if(map.get(key)>max) {
				max = map.get(key);
				ans = key;
			}
		}
		return ans;
	}
	public static void main(String[] args) throws IOException {
		IjC401 T = new IjC401();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();
		System.out.println(T.solution(n, str));
		
		
	}

}
