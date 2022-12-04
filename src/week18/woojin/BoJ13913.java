package week18.woojin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BoJ13913 {
    static class Pos{
        int x;
        ArrayList<Integer> list;

        public Pos(int x, ArrayList<Integer> list) {
            this.x = x;
            this.list = new ArrayList<>(list);
        }
    }

    static Queue<Pos> q = new LinkedList<Pos>();
    static int[] map = new int[100001];
    static boolean[] visit = new boolean[100001];
    static int n,k;

    static void bfs(){

        while(!q.isEmpty()){
            Pos pos = q.poll();
            visit[pos.x]=true;

            if(pos.x == k) {
                System.out.println(map[k]);
                for (int i = 0; i < pos.list.size(); i++) {
                    System.out.print(pos.list.get(i) + " ");
                }
            }

            if(n==k) {
                break;
            }

            if(0<=pos.x-1 && !visit[pos.x-1]) {
                Pos npos = new Pos(pos.x-1, pos.list);
                npos.list.add(pos.x-1);
                q.add(npos);
                visit[pos.x-1] = true;
                map[pos.x-1] = map[pos.x]+1;
            } if(pos.x+1<=100000 && !visit[pos.x+1]) {
                Pos npos = new Pos(pos.x+1, pos.list);
                npos.list.add(pos.x+1);
                q.add(npos);
                visit[pos.x+1] = true;
                map[pos.x+1] = map[pos.x]+1;
            } if(pos.x*2<=100000 && !visit[pos.x*2]) {
                Pos npos = new Pos(pos.x*2, pos.list);
                npos.list.add(pos.x*2);
                q.add(npos);
                visit[pos.x-1] = true;
                map[pos.x*2] = map[pos.x]+1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] Input = br.readLine().split(" ");
        n = Integer.parseInt(Input[0]);
        k = Integer.parseInt(Input[1]);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(n);
        q.add(new Pos(n, list));
        bfs();
    }
}

