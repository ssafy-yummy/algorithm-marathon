def convert(str):
    dct = {"C": "A", "C#": "B", "D": "C", "D#": "D", "E": "E", "F": "F", "F#": "G", "G": "H", "G#": "I", "A": "J",
           "A#": "K", "B": "H", "E#": "I"}

    now = ""
    cvt_str = ""
    for i in range(len(str) - 1, -1, -1):

        if now != "":
            now = str[i] + "#"
        else:
            now += str[i]

        if str[i] == "#":
            continue

        cvt_str += dct[now]
        now = ""

    return cvt_str


def solution(m, musicinfos):
    # ans = ''
    m = convert(m)

    data = []
    for i in range(len(musicinfos)):

        d = musicinfos[i].split(",")  # ',' 기준으로 잘라서 데이터 얻기
        t = d[0].split(":")  # 시간 자르기
        t2 = d[1].split(":")  # 시간 구하기
        st = int(t[0]) * 60 + int(t[1])  # 시작 시간
        et = int(t2[0]) * 60 + int(t2[1])  # 끝 시간
        pt = et - st  # 플레이 시간

        title = d[2]  # 제목

        full_melody = convert(d[3]) * pt  # 전체 멜로디
        melody = full_melody[len(full_melody) - pt:]  # 들을 수 있는 멜로디

        find = -1
        if melody.find(m) != -1:
            find = 1

        data.append((find, pt, title))

    data = sorted(data, key=lambda x: (-x[0], -x[1]))

    res = data[0]

    if res[0] == -1:
        return "(None)"
    else:
        return res[2]
