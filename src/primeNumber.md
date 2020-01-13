# 소수 찾기

#### 소수란, 1과 자기 자신 이외의 자연수로 나눌 수 없는 1보다 큰 수 (2, 3, 5, 7, ...) 



**[방법 1] 자신보다 작은 모든 자연수로 나누어 떨어지는지 확인한다.**  
자기 자신보다 작은 자연수로 나누어봐서, 1 이외의 다른 수로 나누어지면 소수가 아니다.


```$xslt
public static boolean isPrimeNumber(int val) {
    if (val == 1) return false;
    for (int i = 2; i < val; i++) {
        if (val % i == 0) {
            return false;
        }
    }
    return true;
}
```

**[방법 2] 구하고 싶은 수 까지의 수의 배열을 만든 후 **  
어떠한 수의 배수는 소수가 될 수 없다.  
즉, 2는 소수이고, 2의 배수인 4, 6, 8, ...은 소수가 될 수 없다.  
3은 소수이고, 3의 배수인 3, 6, 9, ...은 소수가 될 수 없다.
5는 소수이고, 5의 배수인 5, 10, 15, ...은 소수가 될 수 없다.

```$xslt
public static boolean isPrimeNumber2(int val) {
    boolean[] isPrime = new boolean[1001];
    Arrays.fill(isPrime, true); // isPrime 배열을 true로 초기화
    isPrime[0] = isPrime[1] = false;
    for(int i = 2; i < isPrime.length; i++) {
        if (isPrime[i]) {
            int j = i+i;
            while (j <= 1000) { // 소수 i의 배수는 소수가 아니다
                isPrime[j] = false;
                j += i;
            }
        }
    }
    return isPrime[val];
}
```





------

관련 문제

1. [백준 1978번](https://www.acmicpc.net/problem/1978)