const fs = require("fs");
let input = fs.readFileSync("input.txt").toString().split("\n");
//let input = fs.readFileSync("/dev/stdin").toString().split('\n');
let line1 = input[0].split(" ");
let size = [line1[0] * 1, line1[1] * 1, line1[2] * 1];
//<------------input
let answer = [];

const maxSize = 201;
let visit = new Array(maxSize);
for (let i = 0; i < maxSize; i++) {
  visit[i] = new Array(maxSize);
  for (let j = 0; j < maxSize; j++) {
    visit[i][j] = Array(maxSize).fill(false);
  }
}

let queue = [];
queue.push([0, 0, size[2]]);
visit[0][0][size[2]] = true;

while (queue.length) {
  let cur = queue.shift();
  if (cur[0] === 0) {
    answer.push(cur[2]);
  }
  //6가지 경우에 대해서 물 이동을 할때
  for (let i = 0; i < 3; i++) {
    for (let j = 0; j < 3; j++) {
      if (i === j) continue;
      let temp = [...cur];
      //cur[i] -> cur[j]
      let jTemp = size[j] - temp[j]; //j의 여유분
      if (temp[i] > jTemp) {
        temp[j] = size[j];
        temp[i] -= jTemp;
      } else {
        temp[j] += temp[i];
        temp[i] = 0;
      }

      //지금까지 방문했었던 패턴이면 continue
      if (visit[temp[0]][temp[1]][temp[2]] === true) {
        continue;
      }
      //아니면 queue에 추가
      visit[temp[0]][temp[1]][temp[2]] = true;
      queue.push([temp[0], temp[1], temp[2]]);
    }
  }
}
console.log(answer.sort((a, b) => a - b).join(" "));
