import sys

r = sys.stdin.readline
N, W, L = map(int, r().split())
trucks = list(map(int, r().split()))

arr = [0] * W  # 다리 위의 차 리스트
time = 0  # 걸린 시간
weight = 0

while arr:
    time += 1
    weight -= arr.pop(0)

    if trucks:
        if weight + trucks[0] <= L:
            weight += trucks[0]
            arr.append(trucks.pop(0))
        else:
            arr.append(0)

print(time)
