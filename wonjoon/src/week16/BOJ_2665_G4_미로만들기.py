import sys
from collections import deque

input = sys.stdin.readline

N = int(input())  # 보드의 크기
dr = [-1, 0, 1, 0]  # 4방탐색
dc = [0, 1, 0, -1]

board = [list(map(int, list(input().strip()))) for _ in range(N)]  # 미로판 입력 받기
visited = [[-1] * N for _ in range(N)]  # 검은 판 부술 때 마다 부순 횟수를 기록할 배열


def bfs():
    dq = deque()  # dq 생성
    dq.append((0, 0))  # 초기값 입력
    visited[0][0] = 0  # 초기값 부순 횟수는 0

    while dq:
        r, c = dq.popleft()  # 큐 형태로 왼쪽에 있는것 부터 진행

        if r == N - 1 and c == N - 1:  # 도착 지점에 왔다면 부순 횟수 반환
            return visited[r][c]

        for i in range(4):  # 4방탐색 진행
            nr = r + dr[i]
            nc = c + dc[i]

            if 0 <= nr < N and 0 <= nc < N and visited[nr][nc] == -1:  # 방문하지 않은 부분 만 진행
                if board[nr][nc] == 1:
                    dq.appendleft((nr, nc))  # 흰벽 먼저 처리 후에 검은벽을 방문하므로 dq왼쪽에 추가
                    visited[nr][nc] = visited[r][c]  # 흰 벽(1)을 만나면 벽을 부수지 않으므로 이전 값을 그대로 입력
                else:
                    dq.append((nr, nc))  # 검은벽은 dq 오른쪽에 추가
                    visited[nr][nc] = visited[r][c] + 1  # 검은 벽(0)을 만나면 벽을 부수고 이동하므로 이전 값에 +1 입력


print(bfs())
