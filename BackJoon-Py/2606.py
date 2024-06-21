import sys

input = sys.stdin.readline
cnt = 0
def dfs(n):
    visited[n]=1
    global cnt
    for i in computer[n]:
        if visited[i]==0:
            dfs(i)
            cnt+=1

n = int(input())

computer = [[]*(n+1) for _ in range(n+1)]
visited = [0]*(n+1)

t = int(input())
for i in range(t):
    a, b = list(map(int, input().split()))
    computer[a].append(b)
    computer[b].append(a)

dfs(1)

print(cnt)