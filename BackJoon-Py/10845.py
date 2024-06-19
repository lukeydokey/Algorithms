import sys
input = sys.stdin.readline

n = int(input())
q=[]

for _ in range(n):
    command = input()
    match command[:2]:
        case 'pu':
            q.append(int(command.split()[1]))
        case 'po':
            print(q.pop(0) if q else -1)
        case 'si':
            print(len(q))
        case 'em':
            print(0 if q else 1)
        case 'fr':
            print(q[0] if q else -1)
        case 'ba':
            print(q[-1] if q else -1)