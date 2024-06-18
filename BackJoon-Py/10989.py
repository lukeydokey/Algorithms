import sys
input = sys.stdin.readline
printf = sys.stdout.write

n = int(input())
cnt = [0] * 10001
for i in range(n):
    cnt[int(input())] += 1
for i in range(10001):
    if cnt[i] != 0:
        for j in range(cnt[i]):
            printf(f'{i}\n')