def solution(rows, columns, queries):
    maps = [[i * columns + j for j in range(1, columns + 1)] for i in range(rows)]
    diff = [[1, 0], [0, 1], [-1, 0], [0, -1]]
    answer = []

    for r1, c1, r2, c2 in queries:
        r1 -= 1
        c1 -= 1
        r2 -= 1
        c2 -= 1
        mins = 1e9
        start = maps[r1][c1]
        nr = r1
        nc = c1
        for d in diff:
            while nr + d[0] <= r2 and nr + d[0] >= r1 and nc + d[1] <= c2 and nc + d[1] >= c1:
                pr = nr
                pc = nc
                nr += d[0]
                nc += d[1]
                maps[pr][pc] = maps[nr][nc]
                mins = min(mins, maps[pr][pc])

        maps[r1][c1 + 1] = start
        mins = min(mins, start)

        answer.append(mins)

    return answer