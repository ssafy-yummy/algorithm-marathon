from collections import deque

T = int(input())

for tc in range(1, T + 1):
    ans = 0

    N, K = map(int, input().split())  # N: 비밀번호 개수 , K : K번째로 큰 수
    pwd = input()  # 비밀번호
    rot = N // 4  # 회전할 횟수
    pattern = [deque(list(pwd)[x * rot: x * rot + rot]) for x in range(4)]  # 한 면에 해당하는 패턴

    st = {}  # 중복되지 않게 비밀번호를 저장한 set
    for i in range(rot):  # rot 번 회전하면서 얻을 수 있는 비밀번호 보기

        for k in range(4): # dict에 넣기 위해 각 패턴을 한 문자열로 합쳐준다.
            tmp = list(pattern[k])
            s = ""
            for x in range(rot):
                s += tmp[x]

            st[s] = int(s, 16) # 딕셔너리에 문자열 : 값 (1F7 : 503) 식으로 넣어준다.
        for j in range(4):
            pattern[(j + 1) % 4].appendleft(pattern[j].pop()) # 뒤에 숫자를 빼서 다음 패턴의 앞자리에 넣어준다.

    print(f'#{tc} {sorted(list(st.values()), reverse=True)[K - 1]}') # 내림차순으로 정렬하고 K번째 값을 출력
