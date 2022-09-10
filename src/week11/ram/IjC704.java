package week11.ram;
/* 팩토리얼(재귀)
 * DFS(1)은 1을 리턴하고 DFS(2)에 2*1이 담긴다.
 * DFS(2)는 2를 리턴하고 DFS(3)에 3*2가 담긴다.
 * DFS(3)은 6을 리턴하고 DFS(4)에 4*6이 담긴다.
 * DFS(4)는 24를 리턴하고 DFS(5)에 5*24가 담긴다.
 */
import java.util.*;
import java.io.*;
public class IjC704 {
	public static int DFS(int n) {
		if(n==1) return 1;
		else return n*DFS(n-1);
	}
	public static void main(String[] args) {
		System.out.println(DFS(5));
	}

}
