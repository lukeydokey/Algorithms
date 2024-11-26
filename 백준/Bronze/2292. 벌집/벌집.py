n = int(input())
cnt = 1
numMax = 1
while n > numMax:
    numMax += 6 * cnt
    cnt += 1
print(cnt)