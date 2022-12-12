import sys

input = sys.stdin.readline
N = int(input())  # 참가자의 수
crime = list(map(int, input().split()))  # 유죄 지수
R = [list(map(int, input().split())) for _ in range(N)]  # 참가자 반응
mafia = int(input())  # 마피아 번호

start = N % 2  # 참가자 수 홀짝 체크
night_cnt = 0  # 지나간 밤 회수
ans = 0  # 최대로 지난 밤
dead = -27  # 죽은 사람


def night(lst):
    global night_cnt, ans
    tmp2 = lst.copy()  # 연산 후 되돌리기 위해 임시 저장
    for a in range(N):  # N 만큼 돌면서 한명씩 죽여보기
        if a == mafia or lst[a] == dead:  # a가 마피아일 때 패스, 죽어있으면 패스
            continue
        lst[a] = dead  # a 번째 사람 죽이기
        night_cnt += 1  # 밤 횟수 증가
        ans = max(ans, night_cnt)  # 최대값 갱신

        # 죽인 다음 유죄 지수 R[i][j]로 셋팅
        for b in range(N):
            if lst[b] == dead:  # 죽은사람 건너뜀
                continue

            lst[b] += R[a][b]

        day(lst)  # 낮 로직 처리
        # 처리 후 원상 복귀
        lst = tmp2.copy()
        night_cnt -= 1


def day(lst):
    idx = lst.index(max(lst))  # 리스트에서 최대값이면서 가장 앞에있는 값의 인덱스
    if idx == mafia or lst[idx] == dead:  # idx가 마피아일 때 패스, 죽어있으면 패스
        return
    lst[idx] = dead  # 죽은 자리는 dead로 바꿈

    night(lst)  # 밤 로직 처리


if start == 0:  # 참가자 수가 짝수일 때는 밤 시작
    tmp = crime.copy()

    # 마피아가 한명 죽임
    for a in range(N):
        if a == mafia:  # a가 마피아일 때 패스
            continue
        crime[a] = dead  # a 번째 사람 죽이기
        night_cnt += 1  # 밤 횟수 증가
        ans = max(ans, night_cnt)  # 최대값 갱신

        # 죽인 다음 유죄 지수 R[a][b]로 셋팅
        for b in range(N):
            if crime[b] == dead:  # 죽은사람 건너뜀
                continue

            crime[b] += R[a][b]

        day(crime)  # 낮 로직 시작

        # 연산 후 원상복귀
        crime = tmp.copy()
        night_cnt -= 1

else:  # 홀수일 때는 낮 시작
    day(crime)

print(ans)
