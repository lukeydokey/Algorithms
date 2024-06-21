import sys
input = sys.stdin.readline

n = int(input())

scores = list(map(int, input().split()))

result = float(0)
scores.sort()
for score in scores:
    result += score/scores[-1]*100

print(result / n)