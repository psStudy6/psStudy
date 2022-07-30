package week6.soram;
import java.util.*;
import java.io.*;
//프로그래머스.폰켓몬
//최대한 다양한 종류의 폰켓몬을 가질 것
//Map<Integer,Integer> map = new HashMap<>(); 
//key : 종류 value : 가짓수
//중복을 허용하지 않는 HashSet으로 수정
public class PrG1845 {
	public int solution(int[] nums) {
		//HashMap<Integer,Integer> map = new HashMap<>();
		HashSet<Integer> set = new HashSet<>();//집합의 내용물의 자료가 무엇인지 알아야한다
		int pick = nums.length/2;
		//int count = 1;//같은 종류의 폰켓몬이 몇개인지 넣는 변수
		
		for(int i =0;i<nums.length;i++) {
			set.add(nums[i]);
		}
		if(set.size()>pick) return pick;//중복되지 않고 포켓몬을 가져오는 case
		else return set.size(); //집합에 들어있는 포켓몬 종류만큼만 가져오는 case
		
		
	}

	public static void main(String[] args) throws IOException {
		

	}

}
