import math
T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    a = int(math.sqrt(N))
    flag = 0
    for i in range(a, 0, -1):
        if N % i == 0:
            break
            
    j = N // i
    print(f"#{test_case} {i + j - 2}")
