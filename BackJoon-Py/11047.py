import sys

input = sys.stdin.readline

n, k = map(int, input().split())

coin = []
for i in range(n):
    coin.append(int(input()))


result = 0
for c in reversed(coin):
    if k >= c:
        result += k // c
        k %= c
        if k <= 0:
            break

print(result)
