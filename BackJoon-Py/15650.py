import sys

input = sys.stdin.readline
n, m = map(int,input().split())

used = [0]*(n+1)

def cal(start, cnt):
    if cnt == 0:
        for i in range(1,n+1):
            if used[i] == 1: sys.stdout.write(f'{str(i)} ')
        print()
        return
    else:
        for i in range(start, n+1):
            if used[i] == 0:
                used[i] = 1
                cal(i+1, cnt-1)
                used[i] = 0

cal(1, m)