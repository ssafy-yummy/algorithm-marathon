import sys

"""
1) 최소의 키차이를 구하기 위해서 옆의 원생과의 키 차이를 계산한다.
    -> [2,2,1,4]
2) 1, 3 / 5, 6 / 10 이 조 편성 최소 비용일 때 (1,3), (5,6) 의 차이 2개를 뽑는다. 
    즉,N명 중에서 K 개의 조를 짜야하므로 N-K개 만큼의 키 차이 값을 구한다.
3) 최소 값을 구하기 위해 정렬한다
4) N-K개를 뽑아야하므로 [:N-K]만큼 잘라준다.
5) 합 계산 후 출력
"""

input = sys.stdin.readline
N, K = map(int, input().split())  # N : 원생의 수, K : 조의 개수
arr = list(map(int, input().split()))  # 원생들의 키를 담을 배열
team = []  # 인접한 원생들의 키차이를 담을 배열

for i in range(N - 1):  # 다음번 원생과의 키차이 저장
    team.append(arr[i + 1] - arr[i])
team.sort()  # 키 차이 정렬

print(sum(team[:N - K]))  # 티셔츠 비용의 합 계산
