T = int(input())

def make_list():
    answer = ""
    for i in range(len(l)):
        answer += l[i]
        if i % 10 == 9:
            answer += "\n"

    return answer

for t in range(1,T+1):
    #숫자 갯수
    N = int(input())
    l = []
    for _ in range(N):
        alph, n = input().split()
        n = int(n)
        for _ in range(n):
            l.append(alph)
    answer = make_list()
    print(f"#{t}")
    print(answer)