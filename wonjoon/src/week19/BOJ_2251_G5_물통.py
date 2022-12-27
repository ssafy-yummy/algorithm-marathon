from collections import deque

A, B, C = map(int, input().split())  # 리터 입력

arr = (0, 0, C)  # 처음에는 C에만 물이 차있다
dq = deque()  # dq 초기화
dq.append(arr)  # 초반 값 추가
visited = set()  # set으로 방문 체크
visited.add(arr)  # 초반 값 방문 체크


def append(tp):  # tuple 을 입력받아 방문 체크 및 q에 추가
    if tp not in visited:
        visited.add(tp)
        dq.append(tp)


def calc_move(to, end, X):  # 물 옮기는 작업 함수
    if to + end > X:  # 출발점과 도착점이 합이 기준보다 높으면
        t = to + end - X  # 출발점은 나머지 값 저장
        e = X  # 도착점은 최대값 설정
    else:
        t = 0  # 출발점은 다 주므로 0
        e = to + end  # 도착점은 두 값의 합

    return t, e  # 출발, 도착점 데이터 반환


while dq:
    a, b, c = dq.popleft()

    if a != 0:  # A 옮길 수 있는 지 체크
        na, nb = calc_move(a, b, B)  # A->B로 옮기기
        append((na, nb, c))

        na, nc = calc_move(a, c, C)  # A->C로 옮기기
        append((na, b, nc))

    if b != 0:  # B 옮길 수 있는 지 체크
        nb, na = calc_move(b, a, A)  # B->A로 옮기기
        append((na, nb, c))

        nb, nc = calc_move(b, c, C)  # B->C로 옮기기
        append((a, nb, nc))

    if c != 0:  # C 옮길 수 있는 지 체크
        nc, na = calc_move(c, a, A)  # C->A로 옮기기
        append((na, b, nc))

        nc, nb = calc_move(c, b, B)  # C->B로 옮기기
        append((a, nb, nc))

res = set()
for lst in visited:
    if lst[0] == 0:  # A = 0일 때 값 뽑기
        res.add(lst[2])

print(*sorted(res))
