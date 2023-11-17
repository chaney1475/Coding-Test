t = int(input())


def find(x):

    for i in range(1, x+1):
        if x - i <= 0:
            break
        else:
            x -= i
    b = i
    a = 1
    for _ in range(x - 1):
        b -= 1
        a += 1

    return a, b

def get(x, y):
    total = (x+y-1) * (x + y - 2) // 2
    total += x
    return total

for test_case in range(1, t + 1):

    # 첫번째 수, 두번째 수
    N,M = map(int, input().split())

    q, w = find(N)
    e, r = find(M)
    answer = get(q+e, w+r)

    print(f"#{test_case} {answer}")
