const fs = require("fs");
let input = fs.readFileSync("input.txt").toString().split("\n");
//let input = fs.readFileSync("/dev/stdin").toString().split('\n');
let line1 = input[0].split(" ");
let line2 = input[1].split(" ");
let n = line1[0] * 1; //트럭 개수
let w = line1[1] * 1; //다리 길이
let L = line1[2] * 1; //최대 하중
let arr = [];
for (let i = 0; i < n; i++) {
  arr.push(line2[i] * 1);
}
//<------------input
let answer = 0;
let bridgeList = Array.from({ length: w }, () => 0);
let weightSum = 0;
let passTruck = 0;

while (passTruck !== n) {
  answer++;

  let first = bridgeList.shift();
  if (first !== 0) {
    weightSum -= first;
    passTruck++;
  }

  if (weightSum + arr[0] <= L) {
    let truck = arr.shift();
    bridgeList.push(truck);
    weightSum += truck;
  } else {
    bridgeList.push(0);
  }
}

console.log(answer);
