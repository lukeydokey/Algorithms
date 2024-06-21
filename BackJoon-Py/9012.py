import sys

input = sys.stdin.readline

n = int(input())

for i in range(n):
    ps = input()
    tmp = ''
    flag = True
    for c in ps:
        if len(tmp) == 0:
            if c == ')':
                flag = False
                break
            elif c == '(':
                tmp += c
        else:
            if c == ')':
                tmp = tmp[:-1]
            elif c == '(':
                tmp += c
    if flag and len(tmp) == 0:
        print("YES")
    else:
        print("NO")
