def solution(name):
    sum_c = 0
    sum_s = 0
    n = len(name)

    for i in name:
        change_n = min(abs(ord('A') - ord(i)), abs(91 - ord(i)))
        sum_c += change_n

    locat = [x for x, v in enumerate(name) if v != "A"]
    m = len(locat)

    if m == 0:
        return sum_c

    if locat[0] != 0:
        locat.insert(0, 0)

    print(locat)
    for i in range(m - 1):
        v1 = abs(locat[0] - locat[1])
        v2 = abs(n + locat[0] - locat[-1])
        if v1 < v2:
            locat.pop(0)
            sum_s += v1

        else:
            a = locat.pop()
            locat[0] = a
            sum_s += v2

        print(locat, v1, v2)

    return sum_s + sum_c