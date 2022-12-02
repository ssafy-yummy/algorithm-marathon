def convert(str):  # 음을 한글자로 바꿔주는 함수
    dct = {"C": "A", "C#": "B", "D": "C", "D#": "D", "E": "E", "F": "F", "F#": "G", "G": "H", "G#": "I", "A": "J",
           "A#": "K", "B": "H", "E#": "I"}

    now = ""  # 임시로 음을 저장
    cvt_str = ""  # 변환된 음을 저장
    for i in range(len(str) - 1, -1, -1):  # '#'을 발견하면 그 뒤에 있는 알파벳으로 변환해야 하므로 뒤에서 부터 정렬

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
    m = convert(m)  # m 도 한글자 str로 변환

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

        data.append((find, pt, title))  # 우선 순위로 정답을 나누기 때문에 임시로 리스트에 담아둠

    data = sorted(data, key=lambda x: (-x[0], -x[1]))  # 정답이 같으면 재생시간이 긴 순서대로 정렬

    res = data[0]

    if res[0] == -1:
        return "(None)"
    else:
        return res[2]
