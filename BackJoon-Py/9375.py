import sys

input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    count = 1
    clothes = {}
    for i in range(n):
        name, category = input().split()
        if category not in clothes:
            clothes[category] = 1
        else:
            clothes[category] += 1

    for i in clothes:
        count *= (clothes[i]+1)
    print(count-1)