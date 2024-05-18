T = int(input())

def check():
    for i in range(max_second):
        time[i] = K * (i // M)
    total = 0
    for i in range(N):
        total += 1
        if total > time[customer[i]]:
            return "Impossible"
    return "Possible"

for t in range(1,T+1):
    #오는 사람, 초수, 전체 붕어빵
    N, M, K = map(int, input().split())
    customer = list(map(int, input().split()))
    customer.sort()
    max_second = max(customer) + 1
    time = [0] * max_second
    answer = check()
    print(f'#{t} {answer}')
