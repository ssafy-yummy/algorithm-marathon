def solution(n):
    cnt = 1
    while n > 0:

        if n % 2 == 0:
            n //= 2
        else:
            n -= 1
            cnt += 1

    return cnt - 1