# 특정 원소가 속한 집합을 찾기
def find(parent, x):
    if parent[x] == x:
        return x

    parent[x] = find(parent, parent[x])
    return parent[x]


# 두 원소가 속한 집합을 합치기 (간선 연결한다고 생각하자!)
def union(parent, a, b):
    rootA = find(parent, a)
    rootB = find(parent, b)

    if rootA < rootB:
        parent[rootB] = rootA
    else:
        parent[rootA] = rootB


def solve():
    import sys

    input = sys.stdin.readline

    # 노드의 개수와 간선(union 연산)의 개수 입력받기
    v, e = map(int, input().split())
    parent = [0] * (v + 1)
    tot = 0

    edges = []

    # 부모 테이블에서, 부모를 자기 자신으로 초기화
    for i in range(1, v + 1):
        parent[i] = i

    # 모든 간선에 대한 정보를 입력받기
    for _ in range(e):
        a, b, cost = map(int, input().split())
        tot += cost
        # 비용순으로 오름차순 정렬하기 위해 튜플의 첫 번째 원소를 비용으로 설정
        edges.append((cost, a, b))

    edges.sort(key=lambda x: x)

    result = 0

    for edge in edges:
        cost, a, b = edge

        # 사이클이 발생하지 않는 경우에만 집합에 포함(= 연결한다.)
        if find(parent, a) != find(parent, b):
            union(parent, a, b)
            result += cost

    for idx in range(2, v + 1):
        if find(parent, 1) != find(parent, idx):
            return False, -1
    return True, tot - result


ans = solve()
if ans[0]:
    print(ans[1])
else:
    print(-1)
