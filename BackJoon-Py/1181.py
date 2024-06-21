import sys

input = sys.stdin.readline

n = int(input())

list = []
for i in range(n):
    list.append(input().rstrip())
list = set(list)
for i in sorted(list, key=lambda x: (len(x), x)):
    print(i)
