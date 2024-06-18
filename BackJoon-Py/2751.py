import sys
input = sys.stdin.readline
print = sys.stdout.write

n = int(input())
list = []
for i in range(n):
    list.append(int(input()))

for i in sorted(list):
    print(str(i)+'\n')