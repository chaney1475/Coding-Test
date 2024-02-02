import sys
input = sys.stdin.readline


#문자열
string = input().rstrip()
#단어
word = input().rstrip()
l = len(word)



a = []
for i in string:
    a.append(i)
    if "".join(a[-l:]) == word:
        for _ in range(l):
            a.pop(-1)

if len(a) == 0:
    print("FRULA")
else:
    print("".join(a))