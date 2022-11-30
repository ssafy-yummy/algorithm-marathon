from collections import defaultdict
from collections import deque

def solution(n, wires):
    m = len(wires)
    min_cnt = 1e9
    for j in range(m):

        cnt = 0
        dic = defaultdict(list)

        for i in range(m):
            if i == j:
                continue
            dic[wires[i][0]].append(wires[i][1])
            dic[wires[i][1]].append(wires[i][0])

        visited = [False for _ in range(n+1)]
        queue = deque()
        queue.append(1)

        while queue:
            c = queue.popleft()
            if visited[c]:
                continue
            visited[c] = True
            cnt += 1
            tmp = dic[c]
            for x in tmp:
                queue.append(x)

        for i in range(n+1):
            if i != 0 and not(visited[i]):
                x = i
                break

        queue.append(x)
        while queue:
            c = queue.popleft()
            if visited[c]:
                continue
            visited[c] = True
            cnt -= 1
            tmp = dic[c]
            for x in tmp:
                queue.append(x)
        cnt = abs(cnt)
        if min_cnt > cnt:
            min_cnt = cnt

    return min_cnt