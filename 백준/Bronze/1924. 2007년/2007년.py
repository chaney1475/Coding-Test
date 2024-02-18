import sys
input = sys.stdin.readline

cal = [0,31,28,31,30,31,30,31,31,30,31,30,31]
day = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"]

total_D = [0] * 13

for i in range(1,13):
    total_D[i] = total_D[i-1] + cal[i]

M, D = map(int, input().split())
temp = total_D[M-1] + D

print(day[temp % 7])