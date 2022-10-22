def live_check(live, board):
    li = []  # 활동중인 활성 세포
    ld = []  # 추가될 비활 세포
    live = sorted(live, key=lambda x: -board[x[0]][x[1]])  # 생명력 내림차순 정렬

    while len(live) > 0:
        r, c, level = live.pop(0)
        if level > 1:
            li.append((r, c, level - 1))

        for i in range(4):
            nr = r + dr[i]
            nc = c + dc[i]
            if board[nr][nc] == 0:
                board[nr][nc] = board[r][c]
                ld.append((nr, nc, board[r][c]))

    return li, ld


def dead_check(dead, board):
    dl = []  # 비활 -> 활성화 리스트
    dd = []  # 아직 활동중인 세포 리스트
    while len(dead) > 0:
        r, c, level = dead.pop()
        if level > 1:
            dd.append((r, c, level - 1))  # 생명력 감소
        else:
            dl.append((r, c, board[r][c]))
    return dl, dd


T = int(input())
for tc in range(1, T + 1):
    N, M, K = map(int, input().split())
    board = [[0] * (M + K) for _ in range(N + K)]  # 최대 크기 배열 +K
    dr = [-1, 0, 1, 0]
    dc = [0, 1, 0, -1]
    live = []  # 활성화
    dead = []  # 비활성화

    for i in range(N):
        tmp = list(map(int, input().split()))
        for j in range(M):
            if tmp[j] != 0:
                r = i + (K // 2)
                c = j + (K // 2)
                board[r][c] = tmp[j]
                dead.append((r, c, tmp[j]))  # r, c, level

    for t in range(K):
        ll, ld = live_check(live, board)  # 활성화 세포 관리 | ll : 활동중인 세포 / ld : 추가 비활성 세포
        dl, dd = dead_check(dead, board)  # 비활성화 세포 관리 | dl : 추가된 활성 세포 / dd: 활성 대기중 세포
        live = ll + dl
        dead = ld + dd
        # print(live)
        # print(dead)

    print("#" + str(tc), len(live) + len(dead))
