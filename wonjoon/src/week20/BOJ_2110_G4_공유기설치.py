import sys

input = sys.stdin.readline
N, C = map(int, input().split())
arr = sorted(list(int(input()) for _ in range(N)))

# print(N, C)
# print(arr)

start = 1  # 최소 거리
end = arr[-1] - arr[0]  # 최대 거리
ans = 0

while start <= end:  # 공유기를 설치할 거리를 이분 탐색으로 구함
    mid = (start + end) // 2  # 최소거리와 최대 거리 중간 값
    now = arr[0]  # 현재 설치할 집의 좌표
    count = 1  # 설치할 수 있는 공유기 개수

    for i in range(1, len(arr)):
        if arr[i] >= now + mid:  # 다음집(arr[i])의 좌표가  현재집 arr[i] + 중간 거리값 보다 크면 설치 할 수 있다.
            count += 1  # 설치 + 1
            now = arr[i]  # 설치 후 현재 좌표 수정

    if count >= C:
        start = mid + 1  # 공유기간 거리를 더 늘릴 수 있다 // 최소 거리 늘리기
        ans = mid  # 현재 최대 거리

    else:
        end = mid - 1  # 공유기간 거리가 너무 멀다 // 거리 좁히기

print(ans)
