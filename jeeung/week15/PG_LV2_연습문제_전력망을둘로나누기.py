def solution(n, wires):

    answer = float("inf")

    def dfs(now):
        if visited[now]:
            return 0

        visited[now] = 1

        size = 1
        for next_v in g[now]:
            size += dfs(next_v)

        return size

    for i in range(n-1):
        g = [[] for _ in range(n+1)]

        for j in range(n-1):
            if i == j:
                continue

            a, b = wires[j]
            g[a].append(b)
            g[b].append(a)

        visited = [0] * (n+1)
        sizes = []
        for i in range(1, n+1):
            if visited[i]:
                continue

            sizes.append(dfs(i))

        answer = min(answer, abs(sizes[0] - sizes[1]))

    return answer
