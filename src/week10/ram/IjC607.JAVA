package week10.ram;

import java.util.*;
class Point implements Comparable<Point> {
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Point object) { // 오름차순
		if (this.x==object.x) return this.y - object.y;
		else return this.x - object.x;
	}	
}

public class IjC607 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Point> arr = new ArrayList<>();
		for (int i=0; i<n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr.add(new Point(x,y));
		}
		Collections.sort(arr); // 정렬
		for (Point p : arr) {
			System.out.println(p.x + " " + p.y);
		}
	}

}
