import sys

n = int(sys.stdin.readline())

arr = []
for _ in range(n):
    start_m, start_d, end_m, end_d = map(int, sys.stdin.readline().split())
    arr.append([start_m * 100 + start_d, end_m * 100 + end_d])

arr.sort()

end_date = 301
count = 0

while arr:
    if end_date >= 1201 or arr[0][0] > end_date:
        break

    temp_end_date = -1

    for _ in range(len(arr)):
        if arr[0][0] <= end_date:
            if temp_end_date <= arr[0][1]:
                temp_end_date = arr[0][1]

            arr.remove(arr[0])
        else:
            break

    end_date = temp_end_date
    count += 1

if end_date < 1201:
    print(0)
else:
    print(count)
