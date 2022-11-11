"""
1. 처음 lt = rt = 0 셋팅
2. rt를 늘려가며 K이상 중복 발생 시 길이 확인
3. 중복 숫자를 찾을 때까지 lt를 뒤로(->) 당긴다
4. 다시 rt를 증가시키며 탐색
"""
data = list(map(int, input().split()))
N, K = data[0], data[1]
arr = list(map(int, input().split()))
all_num = [0] * 100_001
ans = 0

lt = 0
rt = 0

for i in range(N):
    all_num[arr[i]] += 1
    if all_num[arr[i]] == K + 1:
        rt = i
        ans = max(ans, rt - lt)
        # lt 당기기
        for j in range(lt, rt):
            all_num[arr[j]] -= 1
            if arr[j] == arr[i]:
                lt = j + 1
                break
ans = max(ans, N - lt)
print(ans)
