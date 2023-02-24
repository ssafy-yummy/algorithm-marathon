const fs = require("fs");
let input = fs.readFileSync("input.txt").toString().split("\n");
//let input = fs.readFileSync("/dev/stdin").toString().split('\n');
let line1 = input[0].split(" ");
let line2 = input[1].split(" ");

let n = line1[0];
let k = line1[1];
let arr = line2.map((v) => {
  return v * 1;
});
//<------------input
let answer = 0;
let chai = [];

for (let i = 1; i < arr.length; i++) {
  chai.push(arr[i] - arr[i - 1]);
}
chai.sort((a, b) => a - b);

for (let i = 0; i < n - k; i++) {
  answer += chai[i];
}

console.log(answer);
