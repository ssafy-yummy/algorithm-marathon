from collections import defaultdict


def solution(cacheSize, cities):
    dic = defaultdict(int)

    sets = set()
    cnt = 0
    times = 0
    for i, c in enumerate(cities):

        c = "".join([x.lower() for x in c])
        # print(dic)
        # print(sets)

        if cacheSize == 0:
            times += 5
            continue

        if c in sets:
            times += 1
            dic[c] = i
            continue


        else:

            if cnt < cacheSize:
                sets.add(c)
                cnt += 1
                dic[c] = i
                times += 5
                continue

            mins = 1e9
            key = 0;
            for k in dic:
                idx = dic[k]
                if mins > idx:
                    mins = idx
                    key = k
            sets.remove(key)
            del (dic[key])

            sets.add(c)
            dic[c] = i
            times += 5

    return times