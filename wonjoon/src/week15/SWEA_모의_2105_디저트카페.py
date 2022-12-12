"""
1. 첫번째 열부터 n-1열까지 탐색을 진행한다. 마지막, 마지막-1 행도 제외 (절대 마름모 형태가 나올 수 없다~)!
2. dr,dc 방향으로 탐색 진행
3. 반드시 마름모 형태로 탐색해야하므로 직진하거나, 오른 방향으로 돌린다.
4. 총 3번 을 돌면 원점 좌표로 갈 수 있다.

"""
T = int(input())
dr = [1, 1, -1, -1]
dc = [1, -1, -1, 1]


def checkNext(nr, nc):
    return 0 <= nr < N and 0 <= nc < N


def dfs(r, c, _dir, check):
    global ans

    if _dir == 3:  # 3번의 방향 전환을 했는지
        if r == i and c == j:  # 시작점에 도달했는지
            if len(check) > 2:  # 3개 이상, 즉 마름모 형태로 이동했는지 체크
                ans = max(ans, len(check))  # 최대로 먹은 개수

    if checkNext(r, c) and board[r][c] not in check:
        nr = r + dr[_dir]
        nc = c + dc[_dir]

        dfs(nr, nc, _dir, check + [board[r][c]])  # 직진

        if _dir < 3:
            nd = _dir + 1
            nr = r + dr[nd]
            nc = c + dc[nd]
            dfs(nr, nc, nd, check + [board[r][c]])  # 방향 전환


for tc in range(T):
    N = int(input())
    board = [list(map(int, input().split())) for _ in range(N)]

    ans = -1
    for i in range(N - 2):
        for j in range(N):
            if j == 0 or j == N - 1:
                continue
            dfs(i, j, 0, [])

    print(f'#{tc + 1} {ans}')
