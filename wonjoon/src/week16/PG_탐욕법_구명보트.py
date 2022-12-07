from collections import deque


def solution(people, limit):
    people.sort(reverse=True)  # 무거운 순서로 정렬
    people = deque(people)  # pop 연산이 많으므로 속도 증가를 위한 deque로 변환

    cnt = 0  # 배 운반 횟수
    boat = 0  # 보트에 탑승만 사람 무게
    # 1. 무거운 사람먼저 태울 수 있는 만큼 태움
    # 2. 못 태우면 가벼운 사람도 태울 수 있는 만큼 태움
    # 출발

    while True:
        if len(people) == 0:  # 모든 사람이 빠져 나갔으면 종료1
            break

        while True:
            if len(people) == 0:  # 모든 사람이 빠져 나갔으면 종료2
                break
            if boat + people[0] <= limit:  # 무거운 사람 먼저 탈 수 있는 만큼 태우기
                boat += people.popleft()
            else:
                break

        while True:
            if len(people) == 0:  # 모든 사람이 빠져 나갔으면 종료3
                break
            if boat + people[-1] <= limit:  # 가벼운 탈 수 있는 만큼 태우기
                boat += people.pop()
            else:
                break

        # 다 실었으면 배 띄어 보내기
        cnt += 1  # 운반 횟수 증가
        boat = 0  # 보드 무게 초기화

    return cnt
