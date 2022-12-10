
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
35
36
37
def solution(c, musicinfos):
    answer = ['0000',0]
    shap = c.count('#')
    for i in musicinfos:

        music = i.split(',')
        sh, sm, eh, em = music[0][:2],music[0][-2:],music[1][:2],music[1][-2:]
        m=int(em)-int(sm)
        h=int(eh)-int(sh)
        shp=music[3].count('#')
        if m<0:
            h -= 1
            m = 60+m
        time =h*60+m

        if time + shp < len(music):
            code = music[3][:time]
        else:
            code = music[3]*((time+shp//len(music[3])) + 2)
        for k in range(len(code)):

            if time + shap + 1 < k:
                continue
            if len(c)+1+k > len(code):
                continue

            if ''.join(code[k:len(c)+k]) == c:
                if code[len(c)+k] == '#':
                    continue
                if answer[1]< time:
                    answer = [music[2],time]

    if answer[0] == '0000':
        return '(None)'
    else:
        return answer[0]