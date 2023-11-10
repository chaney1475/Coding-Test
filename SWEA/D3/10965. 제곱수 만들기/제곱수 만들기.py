T = int(input())

# 소수 구하기
max_n = int((10 ** 7) ** 0.5)
array = [True for _ in range(max_n + 1)]

for i in range(2, int(max_n ** 0.5) + 1):
    if array[i]:
        j = 2
        while i * j <= max_n:
            array[i * j] = False
            j += 1

prime = []

for i in range(2, len(array)):
    if array[i]:
        prime.append(i)

result = []

for t in range(1, T + 1):
    n = int(input())
    answer = 1

    if n ** 0.5 != int(n ** 0.5):
        for p in prime:
            count = 0
            while n % p == 0:
                n //= p
                count += 1
            if count % 2 != 0:
                answer *= p
            if n == 1 or p > n:
                break
        if n > 1:
            answer *= n

    result.append(answer)

for t in range(1, T + 1):
    print("#{} {}".format(t, result[t - 1]))