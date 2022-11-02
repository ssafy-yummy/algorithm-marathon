import java.util.*;
import java.io.*;

public class BOJ_2564_S1_경비원 {

    static int w, h, n;

    static class Store {
        int news, dir, dist, x, y;

        public Store(int news, int dir, int dist, int x, int y) {
            this.news = news;
            this.dir = dir;
            this.dist = dist;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        n = Integer.parseInt(br.readLine());

        ArrayList<Store> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if (dir == 1)
                arr.add(new Store(0, dir, dist, dist, 0));
            else if (dir == 2)
                arr.add(new Store(2, dir, dist, dist, h));
            else if (dir == 3)
                arr.add(new Store(1, dir, dist, 0, dist));
            else if (dir == 4)
                arr.add(new Store(3, dir, dist, w, dist));
        }

        Store dong = new Store(
                arr.get(n).news,
                arr.get(n).dir,
                arr.get(n).dist,
                arr.get(n).x,
                arr.get(n).y);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            Store temp = arr.get(i);
            if (dong.dir == temp.dir)
                ans += Math.abs(dong.dist - temp.dist);
            else if ((dong.news + temp.news) % 2 == 1)
                ans += Math.abs(dong.x - temp.x) + Math.abs(dong.y - temp.y);
            else {
                if (temp.dir <= 2)
                    ans += h + Math.min(dong.dist + temp.dist, 2 * w - dong.dist - temp.dist);
                else
                    ans += w + Math.min(dong.dist + temp.dist, 2 * h - dong.dist - temp.dist);
            }
        }
        System.out.println(ans);
    }
}