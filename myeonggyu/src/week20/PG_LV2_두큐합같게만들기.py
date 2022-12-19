from collections import deque


def solution(queue1, queue2):
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    n = len(queue1)
    sum1 = 0
    sum2 = 0
    for i in queue1:
        sum1 += i
    for i in queue2:
        sum2 += i

    cnt = 0
    while sum1 != sum2:

        if sum1 < sum2:
            queue1.append(queue2.popleft())
            sum1 += queue1[-1]
            sum2 -= queue1[-1]
        else:
            queue2.append(queue1.popleft())
            sum1 -= queue2[-1]
            sum2 += queue2[-1]

        cnt += 1
        if cnt >= n * 3:
            return -1

    return cnt