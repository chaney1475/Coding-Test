import sys
input = sys.stdin.readline

line = input().rstrip()

num = []
cal = []
number = 0


for l in line:
    if l == "-" or l == "+":
        num.append(number)
        number = 0
        cal.append(l)
    else:
        number = number * 10 + int(l)
num.append(number)


total = num[0]
before = False
for i in range(len(cal)):
    if not before and cal[i] == '+':
        total += num[i+1]
    else:
        if cal[i] == '-':
            before = True
        total -= num[i+1]

print(total)