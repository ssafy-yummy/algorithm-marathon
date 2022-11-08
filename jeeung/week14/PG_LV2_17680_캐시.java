import java.util.*;

class Solution {
    static class Node {
        String data;
        Node next, prev;

        Node(String data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static class Cache {
        Node head, tail;
        int size, maxSize;
        Map<String, Node> cache;

        Cache(int maxSize) {
            this.head = null;
            this.tail = null;
            this.size = 0;
            this.maxSize = maxSize;
            this.cache = new HashMap<>();
        }

        boolean put(String s) {
            // 초기화
            if (this.head == null) {
                this.head = new Node(null);
                this.tail = new Node(null);
                // 헤드, 테일 연결
                this.head.next = this.tail;
                this.tail.prev = this.head;
            }

            // 데이터가 없다면 temp 포인터를 Node타입으로 선언
            Node temp;
            if (this.cache.get(s) == null) {
                temp = new Node(s);
                this.cache.put(s, temp);
                this.size++;
            }
            // 데이터가 있다면 temp 포인터에 담고 데이터 재연결
            else {
                temp = this.cache.get(s);
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
            }

            // temp를 헤드에 연결하여 최우선순위로 만들어줌
            // tail은 계속 뒤로 미루어짐
            this.head.next.prev = temp;
            temp.next = this.head.next;

            this.head.next = temp;
            temp.prev = this.head;

            // 새로운 데이터가 계속 추가되므로
            // size가 maxSize를 넘어가면 tail을 끊어줌
            if (this.size > this.maxSize) {
                // 지울 위치 포인터
                String data = this.tail.prev.data;

                // 재연결
                this.tail.prev.prev.next = this.tail;
                this.tail.prev = this.tail.prev.prev;

                // 삭제
                this.cache.put(data, null);
                this.size--;
            }

            return true;
        }

        boolean get(String s) {
            if (this.cache.get(s) == null)
                return false;

            return true;
        }

        @Override
        public String toString() {
            return "" + cache;
        }
    }

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        Cache cache = new Cache(cacheSize);

        for (String city : cities) {
            if (cache.get(city.toLowerCase()))
                answer += 1;
            else
                answer += 5;

            cache.put(city.toLowerCase());
        }

        return answer;
    }
}