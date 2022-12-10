let n = 6;
let result = solution(n);
console.log(result);

//<------------input
function solution(n) {
  let answer = 0;

  while (n != 0) {
    if (n % 2 === 1) {
      n--;
      answer++;
    }
    n /= 2;
  }

  return answer;
}
