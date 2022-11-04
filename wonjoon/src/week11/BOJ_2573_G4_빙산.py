from collections import deque
import copy

N, M = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(N)]
visited = [[False] * M for _ in range(N)]
clone = copy.deepcopy(board)
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]


# 1. 빙산을 찾으면 4방향 체크해서 물과 인접한 부분을 확인하고 복사한 보드에 그만큼 빼준다 x>=0
# 2. 녹였으면 합쳐준다.
# 3. 두 덩어리로 분리되었는 지 탐색한다.

def checkNext(nr, nc):
    return 0 <= nr < N and 0 <= nc < M


def bfs(r, c):
    q = deque()
    q.append((r, c))
    visited[r][c] = True

    while q:
        r, c = q.popleft()
        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if checkNext(nr, nc):
                if not visited[nr][nc] and board[nr][nc] != 0:
                    visited[nr][nc] = True
                    q.append((nr, nc))


def melt(r, c):
    sea = 0
    for i in range(4):
        nr = r + dr[i]
        nc = c + dc[i]
        if checkNext(nr, nc):
            if board[nr][nc] == 0:
                sea += 1
    clone[r][c] -= sea
    if clone[r][c] < 0:
        clone[r][c] = 0


# def dfs_stack(r, c):
#     visited[r][c] = True
#     stack = [(r, c)]
#     while len(stack) != 0:
#         r, c = stack.pop(0)
#
#         for i in range(4):
#             nr = r + dr[i]
#             nc = c + dc[i]
#             if checkNext(nr, nc) and not visited[nr][nc] and board[nr][nc] != 0:
#                 visited[nr][nc] = True
#                 stack.append((nr, nc))


def solve():
    global board, visited
    clear = True
    cnt = 0

    # for a in board:
    #     for b in a:
    #         print(b, end=" ")
    #     print()
    # print("--------------")

    while clear:
        clear = False
        cnt += 1
        for i in range(N):
            for j in range(M):
                if board[i][j] != 0:
                    clear = True
                    # bfs(i, j)
                    melt(i, j)  # 녹이기

                    # for a in board:
                    #     for b in a:
                    #         print(b, end=" ")
                    #     print()
                    # print("--------------", cnt)
        board = copy.deepcopy(clone)
        visited = [[False] * M for _ in range(N)]

        island = 0
        for i in range(N):
            for j in range(M):
                if board[i][j] != 0 and not visited[i][j]:
                    bfs(i, j)
                    island += 1
                    if island == 2:
                        return cnt

    return 0


print(solve())
