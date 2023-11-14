def dfs(index, sTaste, sKcal):
    global maxTaste
    
    # 총 칼로리를 넘으면 리턴
    if sKcal > L:
        return
        
    # taste의 합이 제일큰 taste 합보다 크면 갱신
    if maxTaste < sTaste:
        maxTaste = sTaste
        
    # 햄버거 재료 데이터를 다 돌면 리턴
    if index == N:
        return
        
    # index 파라미터를 통해 taste, kcal 대입
    taste, kcal = data[index]
    
    # 햄버거 재료 리스트에서 재료를 사용했을 때
    dfs(index + 1, sTaste + taste, sKcal + kcal)
    # 햄버거 재료 리스트에서 재료를 사용하지 않았을 때
    dfs(index + 1, sTaste, sKcal)

t = int(input())
for tc in range(1, t+1):
    # N: 햄버거 재료 수, L: 넘지 말아야 하는 칼로리 양
    N, L = map(int, input().split())
    
    # 햄버거와 칼로리 리스트 저장
    data = [list(map(int, input().split())) for _ in range(N)]
    
    maxTaste = 0
    dfs(0, 0, 0)
    
    print("#{} {}".format(tc, maxTaste))