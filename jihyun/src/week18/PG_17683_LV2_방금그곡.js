let m = "ABC";
let musicinfos = ["12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"];
let result = solution(m, musicinfos);
console.log(result);

//<------------input
function solution(m, musicinfos) {
  let musicplaylist = [];
  m = m.replace(/[A-Z]#/g, (v) => v[0].toLowerCase());

  musicinfos.forEach((e) => {
    let info = e.split(",");

    let time = info[0].split(":");
    let start = time[0] * 1 * 60 + time[1] * 1;
    time = info[1].split(":");
    let end = time[0] * 1 * 60 + time[1] * 1;
    let melody = info[3].replace(/[A-Z]#/g, (v) => v[0].toLowerCase());
    melody =
      melody.repeat(Math.floor((end - start) / melody.length)) +
      melody.substr(0, (end - start) % melody.length);

    let map = new Map();
    map.set("time", end - start);
    map.set("title", info[2]);
    map.set("melody", melody);
    musicplaylist.push(map);
  });

  let musicfinallist = [];
  musicplaylist.forEach((e) => {
    if (e.get("melody").indexOf(m) >= 0) {
      musicfinallist.push(e);
    }
  });
  if (musicfinallist.length === 0) return "(None)";
  musicfinallist.sort((a, b) => {
    return b.get("time") - a.get("time");
  });

  return musicfinallist[0].get("title");
}
