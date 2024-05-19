T = int(input())

for t in range(1,T+1):
    N = int(input())
    lists = []
    for i in range(1, int(N**0.5) + 1):
        if N % i == 0:
            lists.append((N//i + i - 2))
    print(f"#{t} {min(lists)}")
