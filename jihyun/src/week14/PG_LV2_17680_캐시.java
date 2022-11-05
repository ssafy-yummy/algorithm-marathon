package week14;

import java.util.ArrayList;
import java.util.List;

public class PG_LV2_17680_캐시 {
    public static void main(String[] args) {
        int cacheSize = 0;
        String[] cities = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };
        Solution s = new Solution();
        int result = s.solution(cacheSize, cities);
        System.out.println(result);
    }
}

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        List<String> list = new ArrayList<>();
        
        for(int i=0;i<cities.length;i++) { //모든 도시들에 대해서
        	String city = cities[i].toLowerCase();
            boolean flag = false;
            for(int j=0;j<list.size();j++) { //가능한 공간 만큼
                if(list.get(j).equals(city)) { //찾아서 있으면
                    list.remove(j); //해당하는것 빼고
                    list.add(city); //맨 뒤에 넣는다
                    flag=true;
                    answer+=1;
                    break;
                }
            }
            if(cacheSize==0)
            	answer+=5;
            else if(flag==false) { //찾아서 없으면
                if(list.size()==cacheSize)  
                    list.remove(0); //맨 앞 빼고
                list.add(city); //맨 뒤에 넣는다
                answer+=5;
            }
            //System.out.println(city+" "+answer);
        }
        
        return answer;
    }
}



//if(set.contains(cities[i].toUpperCase())) { //이미 가지고 있었다
//answer+=1; //hit
//}
//else { //가지고 있지 않다
//if(set.size()==cacheSize) { //캐시 꽉차있음
//    set.remove(queue.poll()); //맨 앞에 있던거 제거
//    queue.offer(cities[i].toUpperCase()); //맨 뒤에 추가
//    set.add(cities[i].toUpperCase()); //맨 뒤에 추가
//    answer+=5;
//}
//else { //캐시 공간이 남아있다
//    queue.offer(cities[i].toUpperCase()); //맨 뒤에 추가
//    set.add(cities[i].toUpperCase()); //맨 뒤에 추가
//    answer+=5;
//}
//}