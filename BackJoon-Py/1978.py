import math

n = int(input())
list = list(map(int,input().split()))
cnt = 0
def is_prime(x):
    if x == 1:
        return False
    for i in range(2, int(math.sqrt(x)+1)):
        if x%i == 0:
            return False
    return True
for i in list:
    if is_prime(i):
        cnt += 1
print(cnt)