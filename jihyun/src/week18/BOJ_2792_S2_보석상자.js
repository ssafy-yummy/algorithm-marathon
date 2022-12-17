const fs = require("fs");
let input = fs.readFileSync("input.txt").toString().split("\n");
//let input = fs.readFileSync("/dev/stdin").toString().split('\n');
let line1 = input[0].split(" ");
let n = line1[0] * 1; //아이들 수
let m = line1[1] * 1; //색상 수
let arr = [];
for (let i = 1; i < m + 1; i++) {
  arr.push(input[i] * 1);
}

//<------------input
let answer = 0;

let left = 1;
let right = Math.max(...arr);

while (left <= right) {
  let mid = Math.floor((left + right) / 2);

  let flag = true;
  let cnt = 0;
  for (let i = 0; i < m; i++) {
    cnt += Math.ceil(arr[i] / mid);
    if (cnt > n) {
      flag = false;
      break;
    }
  }
  if (flag) {
    //질투심을 낮춘다
    right = mid - 1;
    answer = mid;
  } else {
    //질투심을 높인다
    left = mid + 1;
  }
}

console.log(answer);
