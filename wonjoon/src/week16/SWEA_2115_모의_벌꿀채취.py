from itertools import combinations

T = int(input())


def subset(lst, r, c):
    global C, t1_max_honey, jr, jc
    result = []
    for i in range(len(lst) + 1):
        result += list(combinations(lst, i))  # 부분 집합을 구하는 부분 ex: [1,2] -> [(),(1),(2),(1,2)]

    for li in result[1:]:  # 첫번째는 값이 없으므로 자른다 [1:]
        h = sum(li)
        if h > C:  # 구한 부분집합에서 꿀의 합이 C 이하일 때만 검사한다.
            continue

        tmp = 0  # 제곱된 값을 임시로 담아두기 위한 변수
        for x in li:
            tmp += x ** 2

            if tmp > t1_max_honey:  # 최대값일 경우 좌표, 최대 꿀 갱신
                t1_max_honey = tmp
                jr = r
                jc = c


def subset2(lst):  # 위와 동일
    global C, t1_max_honey
    result = []
    for i in range(len(lst) + 1):
        result += list(combinations(lst, i))

    for li in result[1:]:
        h = sum(li)
        if h <= C:
            tmp = 0
            for x in li:
                tmp += x ** 2

                if tmp > t1_max_honey:
                    t1_max_honey = tmp


for tc in range(1, T + 1):
    ans = 0
    N, M, C = map(int, input().split())  # N M C 입력 받음
    board = [list(map(int, input().split())) for _ in range(N)]  # 꿀판 입력
    t1_max_honey = 0  # 얻을 수 있는 최대 꿀양
    jr = 0  # 최대 꿀양을 갱신할 때 위치 저장하기 위한 변수 jr, jc
    jc = 0

    for a in range(N):  # 첫번째 사람 꿀 얻기
        for b in range(N - M + 1):
            t1 = board[a][b:b + M]  # M 사이즈 만큼 돌면서 꿀얻음
            subset(t1, a, b)  # 모든 경우의 수르 완탐하면서 최대 꿀 저장

    # 두 사람이 겹치는 구간 리스트
    jump = list(range(jc - M + 1, jc + M))

    ans += t1_max_honey
    t1_max_honey = 0

    # 두번째 사람 꿀 채취
    for a in range(N):
        for b in range(N - M + 1):
            if a == jr and b in jump: # 첫번째 사람의 동선과 겹칠 경우 패스
                continue
            t1 = board[a][b:b + M]
            subset2(t1)
    ans += t1_max_honey

    print(f'#{tc} {ans}')
