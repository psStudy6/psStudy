package week9.yumi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 프로그래머스 17686 파일명 정렬
 * 레벨2
 * 
 * 문제 : 파일명에 포함된 숫자를 반영한 정렬 기능을 저장소 관리 프로그램에 구현
 * 		소스 파일 저장소에 저장된 파일명은 100 글자 이내로, 영문 대소문자, 숫자, 공백(" "), 마침표("."), 빼기 부호("-")만으로 이루어져 있다. 
 * 		파일명은 영문자로 시작하며, 숫자를 하나 이상 포함하고 있다.
 * 		HEAD는 숫자가 아닌 문자로 이루어져 있으며, 최소한 한 글자 이상이다
 * 		NUMBER는 한 글자에서 최대 다섯 글자 사이의 연속된 숫자로 이루어져 있으며, 앞쪽에 0이 올 수 있다.
 * 		TAIL은 그 나머지 부분으로, 여기에는 숫자가 다시 나타날 수도 있으며, 아무 글자도 없을 수 있다.
 * 		문자열 비교 시 대소문자 구분을 하지 않는다
 * 		두 파일의 HEAD 부분과, NUMBER의 숫자도 같을 경우, 원래 입력에 주어진 순서를 유지한다.
 * 
 * 핵심 : 		
*/

class File implements Comparable<File> {
	String fileName;
	String head;
	int number;
	
	public File(String fileName) {
		this.fileName = fileName;
		
		// head :  숫자가 아닌 문자로 이루어져 있음 - 숫자를 처음 만나는 곳에서 문자열을 자름
		this.head = fileName.split("[0-9]")[0];
		
		// number : 최대 다섯 글자 사이의 연속된 숫자
		String tmp = "";
		int len = this.head.length();
		for (int i = len; i < fileName.length(); i++) {
			char ch = fileName.charAt(i);
			if (!Character.isDigit(ch) || i > len+5)  {
				tmp = fileName.substring(len, i);
			}
		}
		this.number = Integer.parseInt(tmp);
	}

	@Override
	public int compareTo(File o) {
		// head 비교
		int result = head.toLowerCase().compareTo(o.head.toLowerCase());
		// head가 같을 시 number 비교
		if (result == 0) {
			return number - o.number;
		} 
		return result;
	}
}

public class PrG17686 {
	
	// 방법 1 : File 객체 compareTo 비교
	public String[] solution(String[] files) {
		List<File> list = new ArrayList<File>();
		for (String fileName : files) {
			list.add(new File(fileName));
		}
		// 정렬
		Collections.sort(list);
		return files;
	}
	
	
	
	
	
	// 방법 2 : Comparator 비교, Pattern & Matcher 사용 - 정규표현식
	public String[] solution2(String[] files) {
		
		// head : 최소 1글자([]+)이고 (\ 확장문장) 
		// 		  영문 대소문자(a-z), 공백(\s), 마침표(.), 빼기(-) 부호만으로 이루어짐 
		// number : 최소 1글자 ~ 최대 5글자 사이의 연속된 숫자 ([0-9]{1,5})
		Pattern p = Pattern.compile("([a-z\\s.-]+)([0-9]{1,5})");
		
		Arrays.sort(files, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				Matcher m1 = p.matcher(o1.toLowerCase());
				Matcher m2 = p.matcher(o1.toLowerCase());
				
				m1.find();
				m2.find();
				
				// head 비교
				if (!m1.group(1).equals(m2.group(1))) {
					return m1.group(1).compareTo(m2.group(1));
				}
				// number 비교
				return Integer.parseInt(m1.group(2)) - Integer.parseInt(m2.group(2));
			}
		});
		return files;
	}
	
	
	
	
	
	
	// 방법 3 : Comparator 비교, o1.split("[0-9]")[0] 로 head 찾기
	public String[] solution3(String[] files) {
		Arrays.sort(files, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// 숫자를 처음 만나는 곳에서 문자열을 자름
				String head1 = o1.split("[0-9]")[0];
				String head2 = o2.split("[0-9]")[0];
				
				// head 비교
				int result = head1.toLowerCase().compareTo(head2.toLowerCase());
				// head가 같을 시 number 비교
				if (result == 0) {
					return findNum(o1, head1) - findNum(o2, head2);
				}
				return result;
			}
		});
		return files;
	}
	
	public int findNum(String file, String head) {
		String numTail = file.substring(head.length());
		int i = 0;
		// 최대 다섯 글자 사이의 연속된 숫자
		for (char ch : numTail.toCharArray()) {
			if (!Character.isDigit(ch) || i >= 5) {
				break;
			} 
			i++;
		}
		// 숫자로 형변환(0 제거)
		return Integer.parseInt(numTail.substring(0, i));
	}
	
	public static void main(String[] args) {
		PrG17686_F prg = new PrG17686_F();
		String[] arr = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		String[] arr2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		String[] arr3 = {"O00321", "O49qcGPHuRLR5FEfoO00321"};
		prg.solution(arr);
		prg.solution(arr2);
		prg.solution(arr3);
	}
}
