'''
4 7
1 2 4
1 4 6
2 1 3
2 3 7
3 1 5
3 4 4
4 3 2


'''

n, m = map(int, input().split())
INF = 10e9
cost_table = [[INF]*(n+1) for _ in range(n+1)]





def inputDistance():
    for i in range(m):
        snode, enode, dist = map(int, input().split())
        
        cost_table[snode][enode] = dist
    for i in range(n+1):
        cost_table[i][i] = 0

inputDistance()    



for k in range(1, n+1):
    for i in range(1, n+1):
        for j in range(1, n+1):
            cost_table[i][j] = min(cost_table[i][j], cost_table[i][k]+cost_table[k][j])
       
# 수행된 결과 출력         
for a in range(1, n+1):
    for b in range(1, n+1):
        if cost_table[a][b] ==INF:
            print("INF", end=' ')
        else:
            print(cost_table[a][b], end=' ')
    print()