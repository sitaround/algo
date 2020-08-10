# 알고리즘 정리
- 빠른 약수 구하기
```java
//기존 약수 구하기
for(int i = 0; i < N; i++)
    if(N % i == 0)
        System.out.println(i);
//최적화
int i;
for(i = 0; i*i < N; i++)
    if(N % i == 0)
        System.out.printf("%d %d", i, N/i);
if(i * i == N)
    System.out.println(i);
```
- 31개 이하에서는 visit 배열보다는 int형으로
```java
int visit;
visit = 1 << map[x][y];                 //map[x][y]를 방문 표시.
if(visit & (1 << map[dx][dy]) == 0)     //0이면 map[dx][dy]를 방문 안 함.
    visit = visit | (1 << map[dx][dy]); //visit 변수에 map[dx][dy] 방문 표시.
/*
마을이 5개가 있다고 하면,
int visit = 0 으로 선언했다고 하면, 00000으로 생각을 할 수 있다. (2진법)
5번 마을을 방문했다고 하면 visit = 1 << 5; 로 visit은 100000로 표시를 할 수 있다.
그 후, 3번 마을을 방문한다고 하면 visit = visit | (1 << 3);으로 101000으로 표시가 가능하다.
이렇게 int 형 하나만으로 31개의 마을에 대해 표시를 할 수가 있다.
*/
```
- 빠른 지수곱 구하기
기존 지수곱을 구하려면 O(n)이 걸리지만, 만약 x^8을 구할 때 x^8 = x^4 * x^4를 이용하여 O(logn)에 구할 수 있다.
<https://en.wikipedia.org/wiki/Addition-chain_exponentiation>도 존재.
```java
int pow(int base, int exp){
    res = 1;
    while(exp > 0){
        if(exp % 2 == 1) res *= base;
        base *= base;
        exp /= 2;
    }
}
```
- 빠른 팰린드롬 구하기
기존 팰린드롬을 구하려면 O(N^2)이 걸리나 manacher's algorithm을 사용하면 O(N)에 구할 수 있다.
- 사이클은 DFS + Backtracking으로
- 유클리드 호제법
두 수의 최대공약수를 구할 때에 빠르게 구할 수 있는 알고리즘이다.<br>
예를들어, 78696과 19932의 최대공약수를 구하면,<br>
78696을 19932로 나눈 나머지에 대해,<br>
**78696** = **19932** X 4 + **1368** 이고, 여기서 19932를 1368로 나눈 나머지에 대해 0이 나올 때까지 반복을 하면 된다.<br>
이를테면,<br>
**78696** = **19932** X 4 + **1368**<br>
**19932** = **1368** X 14 + **180**<br>
**1368** = **180** X 7 + **108**<br>
**180** = **108** X 1 + **72**<br>
**108** = **72** X 1 + **36**<br>
**72** = **36** X 2 + **0**<br>
으로 최대공약수는 36이다.
```java
int euclidean(int a, int b){
    if(b == 0) return a;
    return euclidean(b, a%b);
}
```
- 부동소수점
분수로 극한으로 표현 가능한 어느 실수에 대해 가수를 구하고 싶을 때 생기는 현상.
만약 a = 1.275라는 수에서 소수점 이하의 수를 구하고 싶을 때, a -= (int) a나 a -= 1을 하면 a = 0.2749999..으로 나온다. 
```java
double getDecimalPoint(double a) {
    double b = 1.0;
    while(true) {
        a *= 10.0;
        b *= 10.0;
        if(a % (int)a == 0.0) break; 
    }
    a %= b;
    a /= b;
    return a;
}
```