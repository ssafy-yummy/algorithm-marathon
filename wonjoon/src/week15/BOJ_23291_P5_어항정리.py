from copy import *

data1 = "8 0"
data2 = "5 2 3 14 9 2 11 8"
data3 = "10 9 6 3 8 9 5 6"
data4 = "5 5 6 9 6 8 9 9"
data5 = "9 9 6 6 9 6 8 6"
N, K = map(int, input().split())
arr = [list(map(int, input().split()))]
# N, K = map(int, data1.split())
# arr = [list(map(int, data2.split()))]

dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]


# 1. 최소값에 물고기 채워 넣기
def fish_up():
    global arr
    _min = min(arr[0])
    for i in range(len(arr[0])):
        if _min == arr[0][i]:
            arr[0][i] += 1


def first_fish_raise():
    arr.append([arr[0].pop(0)])


def roll_fish():
    while True:
        r = len(arr)
        c = len(arr[-1])

        if r > len(arr[0]) - r + 1:
            return

        tmp = []
        for i in range(r):
            dq = list(arr.pop(0))
            tmp.append(dq[:c])

            del dq[:c]
            if len(dq) > 0:
                arr.append(dq)

        for i in range(len(tmp[0]) - 1, -1, -1):
            t = []
            for j in range(len(tmp)):
                t.append(tmp[j][i])
            arr.append(t)


def flat(r, c, clone, visited):
    visited[r][c] = 1

    for i in range(4):
        nr = r + dr[i]
        nc = c + dc[i]
        if 0 <= nr < len(arr) and 0 <= nc < len(arr[nr]) and visited[nr][nc] != 0:
            diff = abs(arr[nr][nc] - arr[r][c])
            d = diff // 5
            if diff >= 5:
                # 내가 주기
                if arr[r][c] > arr[nr][nc]:
                    clone[nr][nc] += d
                    clone[r][c] -= d
                else:  # 받기
                    clone[r][c] += d
                    clone[nr][nc] -= d


def flat_run():
    global arr
    clone = deepcopy(arr)
    visited = [[0] * len(arr[x]) for x in range(len(arr))]
    for a in range(len(arr)):
        for b in range(len(arr[a])):
            if arr[a][b] != 0 and visited[a][b] == 0:
                flat(a, b, clone, visited)

    arr = deepcopy(clone)


def down_fish():
    global arr
    t = []
    for i in range(len(arr[0])):
        for j in range(len(arr)):
            if i >= len(arr[j]):
                break

            t.append(arr[j][i])
    arr = [t]


def roll_180():
    global arr
    t = list(arr[0])
    div = len(arr[0]) // 2

    t2 = list(reversed(t[:div]))
    del t[:div]

    div = len(t2) // 2
    t3 = list(reversed(t2[:div]))
    del t2[:div]

    t4 = list(reversed(t[:div]))
    del t[:div]

    arr = [t, t2, t3, t4]


def solve():
    fish_up()
    first_fish_raise()
    roll_fish()
    flat_run()
    down_fish()
    roll_180()
    flat_run()
    down_fish()


cnt = 0
while True:
    m = list(arr[0])
    res = max(m) - min(m)
    if res <= K:
        break
    solve()
    cnt += 1
print(cnt)
