import sys
input = sys.stdin.readline


N = int(input())

def chk_line(l):
    stack = [l[0]]
    for s in l[1:]:
        if s == "(":
            stack.append("(")
        else:
            if len(stack) and stack[-1] == "(":
                stack.pop()
            else:
                return False
    if len(stack) == 0:
        return True
    else:
        return False



for _ in range(N):
    line = input().rstrip()
    if chk_line(line):
        print("YES")
    else:
        print("NO")

