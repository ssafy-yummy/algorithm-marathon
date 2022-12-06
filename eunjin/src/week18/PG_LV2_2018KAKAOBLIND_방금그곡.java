package week18;

import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class PG_LV2_2018KAKAOBLIND_방금그곡 {
	
    static class Music implements Comparable<Music> {
        int playtime, inputtime;
        String title, info;
        public Music(int playtime, int inputtime, String title, String info) {
            this.playtime = playtime;
            this.inputtime = inputtime;
            this.title = title;
            this.info = info;
        }
        public int compareTo(Music o) {
            if(o.playtime == this.playtime) return this.inputtime-o.inputtime;
            return o.playtime-this.playtime;
        }
    }
    static int N;
    static PriorityQueue<Music> pq;
    static List<String> M;
    static String answer;


	public static void main(String[] args) {	// main 함수 테스트 케이스 2번
		String m = "CC#BCC#BCC#BCC#B";
		String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
		System.out.println(solution(m, musicinfos));
	}
	
    public static String solution(String m, String[] musicinfos) {
        answer = "(None)";
        
        makepq(musicinfos);   // pq에 곡 정보를 저장한다.
        M = makelist(m); // 네오가 기억한 멜로디(String)를 새로운 리스트 M에 저장한다.
        go();  // 네오가 기억한 멜로디(M)와 pq에 저장한 곡 정보를 하나씩 비교한다.
        
        return answer;
    }
    
    public static void makepq(String[] musicinfos) {
        pq = new PriorityQueue<Music>();
        for (int i=0, n=musicinfos.length; i<n; i++) {
            String sstart = musicinfos[i].split(",")[0];
            String send = musicinfos[i].split(",")[1];
            int istart = Integer.parseInt(sstart.split(":")[0]) * 60 
                + Integer.parseInt(sstart.split(":")[1]);
            int iend = Integer.parseInt(send.split(":")[0]) * 60 
                + Integer.parseInt(send.split(":")[1]);
            int playtime = iend - istart;   // 라디오에서 음악이 재생된 시간(분)
            String title = musicinfos[i].split(",")[2]; // 음악 제목
            String info = musicinfos[i].split(",")[3];  // 악보 정보
            pq.add(new Music(playtime,i,title,info));
        }
    }
    
    public static List makelist(String str) {
        char[] carr = str.toCharArray();
        List<String> list = new ArrayList<>();
        for (int i=0, j=0, n=carr.length; i<n; i++) {
            if(carr[i]=='#') {  // '#'은 무조건 앞에 있는 문자와 붙여준다.
                list.set(j-1,list.get(j-1)+"#");
            } else {
                list.add(Character.toString(carr[i]));
                j++;
            }
        }
        return list;
    }
    
    public static void go() {
        while(!pq.isEmpty()) {
            Music music = pq.poll();
            List<String> infoList = makelist(music.info);
            int is = infoList.size();   // 곡 정보에 담긴 악보의 멜로디 길이
            
            int time = Math.max(music.playtime, M.size()*2);
            // 라디오에 재생된 시간(분)과 네오가 들은 멜로디 길이의 배수 중 더 큰 값을 배열의 크기로 정함
            String[] infoArr = new String[time];
            for (int i=0, n=infoArr.length; i<n; i++) {
                infoArr[i] = infoList.get(i%is);
            }

            if(isSame(infoArr)) {
                answer = music.title;
                break;   // 음악을 찾은 경우 while문을 벗어난다.
            }
        }
    }
    
    public static boolean isSame(String[] infoArr) {
        // infoArr에 M을 포함한 경우 true를 반환한다.
        // infoArr : 방송된 곡의 악보 멜로디 (array)
        // M : 네오가 기억한 멜로디 (list)
        
        for (int i=0, j=0, n=infoArr.length-M.size(); i<=n; i++) {
            if(infoArr[i].equals(M.get(0))) {
                while(j<M.size() && infoArr[i+j].equals(M.get(j))) j++;
                if(j==M.size()) return true;
                i+=j-1;
                j=0;
            }
        }
        return false;
    }
}