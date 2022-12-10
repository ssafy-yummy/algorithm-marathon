import sys
from collections import deque

r = sys.stdin.readline
N, M, K = map(int, r().split())
data = [list(map(int, r().split())) for _ in range(N)]

# (땅의 양분, 나무 나이, 죽은 나무 나이)
board = list([[5, deque()] for _ in range(N)] for _ in range(N))  # 초기 땅의 양분 = 5 / 나무 나이 목록

for i in range(M):
    x, y, z = map(int, r().split())
    board[x - 1][y - 1][1].append(z)  # 땅에 있는 나무 나이 표시


# 입력 끝


# 봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가
# 여러 개의 나무가 있다면, 나이가 어린 나무부터 양분을 먹는다.
# 만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
def spring():
    for a in range(N):
        for b in range(N):
            live_tree = deque()
            # dead_tree = deque()
            dead_energy = 0

            board[a][b][1] = sorted(board[a][b][1])  # 어린 나무부터 성장시키므로 정렬 / 죽은 나무는 빼야 하므로 인덱스 때문에 뒤에서 부터 시작
            tmp = board[a][b][1]
            for c in range(len(tmp)):  # 나무에서 양분으로 성장
                if board[a][b][0] >= tmp[c]:
                    board[a][b][0] -= tmp[c]  # 먹은 양분 차감
                    live_tree.append(tmp[c] + 1)  # 나무 나이 1 증가

                else:
                    dead_energy += tmp[c] // 2  # summer 여름에 죽은 나무로 양분 추가

            board[a][b][1] = live_tree
            board[a][b][0] += dead_energy


# 가을에는 나무가 번식한다.
# 번식하는 나무는 나이가 5의 배수이어야 하며,
# 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
# 땅을 벗어나는 칸에는 나무가 생기지 않는다.
dr = [-1, -1, -1, 0, 1, 1, 1, 0]
dc = [-1, 0, 1, 1, 1, 0, -1, -1]


def spread(r, c):  # 8방향으로 나무 추가
    for d in range(8):
        nr = r + dr[d]
        nc = c + dc[d]
        if 0 <= nr < N and 0 <= nc < N:  # 테두리 체크
            board[nr][nc][1].append(1)  # 나무 나이는 1


def fall():
    for a in range(N):
        for b in range(N):
            for c in range(len(board[a][b][1])):  # 나이가 5의 배수면 8방향 나무 심기
                if board[a][b][1][c] % 5 == 0:
                    spread(a, b)
            board[a][b][0] += data[a][b]  # 겨울 양분 뿌리기


def count_tree():  # 살아있는 나무 개수 세기
    cnt = 0
    for a in range(N):
        for b in range(N):
            cnt += len(board[a][b][1])
    return cnt


for _ in range(K):
    spring()  # 나이만큼 양분을 먹고, 나이가 1 증가
    fall()  # 5의 배수 / 인접한 8개의 칸에 나이가 1인 나무 추가

print(count_tree())
