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
        System.out.printf("%d %d", i, n/i);
if(i * i == N)
    System.out.println(i);
```
- 31개 이하에서는 visit 배열보다는 int형으로
```java
int visit;
visit = 1 << map[x][y]; //map[x][y]를 방문 표시.
if(visit & (1 << map[dx][dy]) == 0) //0이면 map[dx][dy]를 방문 안 함.
    visit = visit | (1 << map[dx][dy]); //visit 변수에 map[dx][dy] 방문 표시.
/*
마을이 5개가 있다고 하면,
int visit = 0 으로 선언했다고 하면, 00000으로 생각을 할 수 있다. (2진법)
5번 마을을 방문했다고 하면 visit = 1 << 5; 로 visit은 100000로 표시를 할 수 있다.
그 후, 3번 마을을 방문한다고 하면 visit = visit | (1 << 3);으로 101000으로 표시가 가능하다.
이렇게 int 형 하나만으로 31개의 마을에 대해 표시를 할 수가 있다.
*/
```