package week18;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)"; // 초기상태
        int maxlength = 0;
        
        for(int i=0;i<musicinfos.length;i++){
            String[] arr = musicinfos[i].split(","); // , 을 기준으로 문자열을 분리 
            
            String[] after = arr[1].split(":");
            String[] before = arr[0].split(":"); // : 을 기준으로 문자열 분리 
            
            int minute = Integer.parseInt(after[1])-Integer.parseInt(before[1]);
            int hour = Integer.parseInt(after[0])-Integer.parseInt(before[0]); // 시간계산 
            if(minute<0){
                minute+=60;
                hour-=1;
            } // 나중시간의 분이 더 작아서 결과값이 마이너스로 나올 경우, 60분을 더해주고 시간에서 1시간 차등시킴 
            
            int time = hour*60+minute; // 전체 시간 계산 
            
            m = change(m);
            arr[3] = change(arr[3]); // #이 붙은 멜로디들을 치환 
            
            String music = "";
            for(int k=0;k<time;k++){
                music+=arr[3].charAt(k%arr[3].length()); // 재생시간만큼의 재생멜로디 저장 
            }
            
            if(music.contains(m)){ // m이 재생된 멜로디 속에 포함될경우 
                if(maxlength<music.length()){ // 재생시간이 더 길면,
                    maxlength = music.length();
                    answer = arr[2]; // max재생길이와 answer을 변경 
                }
            }
        }
        
        return answer;
    }
    String change(String arr){
        arr = arr.replace("C#","c");
        arr = arr.replace("D#","d");
        arr = arr.replace("F#","f");
        arr = arr.replace("G#","g");
        arr = arr.replace("A#","a"); // 치환 메소드 
        
        return arr;
    }
}