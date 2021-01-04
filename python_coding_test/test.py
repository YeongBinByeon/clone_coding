money = int(560)

obak = money // 500
money = money % 500

bak = money // 100
money = money % 100

osip = money // 50
money = money % 50

sip = money // 10

print("반환해야할 동전 갯수 : {}".format(obak+bak+osip+sip) )


n = 1260
count = 0
coin_types = [500,100,50,10]

for coin in coin_types:
    count += n // coin
    n %= coin
print(count)


N=17
K=4

cnt = 0
while N>1:
    if N % K == 0:
        N = N / K
        cnt += 1
    else:
        N -= 1
        cnt += 1

print(cnt) 


dx = [-1,0,1,0]
dy = [0,1,0,-1]
start = [0,0]

map_size = int(5) #int(input())
command = ["R","R","R","U","D","D"] #input().split()
map =  [ [0] * map_size  for _ in range(map_size)]
print(map)
print(command)

for dir in command:
    if dir == "R":
        if start[1] + dy[1] >=5:
            continue
        start[1] += dy[1]
    elif dir == "L":
        if start[1] + dy[3] < 0 :
            continue
        start[1] += dy[3]
    elif dir == "U":
        if start[0] + dx[0] < 0:
            continue
        start[0] += dx[0]
    elif dir == "D":
        if start[0] + dx[2] >=5:
            continue
        start[0] += dx[2]
    else:
        print("raise input Exception")
start[0] += 1
start[1] += 1
print("{} {}".format(start[0], start[1]))


n = int(5)
x, y = 1, 1
plans = ["R", "R", "R", "U", "D", "D"]

dx = [0,0,-1,1]
dy = [-1,1,0,0]
move_types = ['L','R','U','D']

for plan in plans:
    for i in range(len(move_types)):
        if move_types[i] == plan:
            nx = x + dx[i]
            ny = y + dy[i]
    if nx > n or nx < 1 or ny > n or ny < 1:
        continue
    x = nx
    y = ny
print(x,y)


h = int(5)

count = 0
for i in range(h+1):
    for j in range(60):
        for k in range(60):
            if '3' in str(i)+str(j)+str(k):
                count += 1
print(count)



stack = []
stack.append(1)
stack.append(2)
stack.append(3)
stack.append(4)
stack.pop()
stack.append(5)
stack.append(6)
stack.pop()

print(stack)
print(stack[::-1])

from collections import deque

queue = deque()

queue.append(1)
queue.append(2)
queue.append(3)
queue.append(4)
queue.popleft()
queue.append(5)
queue.append(6)
queue.popleft()
print(queue)
queue.pop()
print(queue)
queue.reverse()
print(queue)
print(list(queue))

graph = [ [] for _ in range(3) ]
print(graph)


# DFS 예제
def dfs(graph, v, visited):
    # 현재 노드를 방문 처리
    visited[v] = True
    print(v, end=' ')
    # 현재 노드와 연결된 다른 노드를 재귀적으로 방문
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

# 각 노드가 연결된 정보를 리스트 자료형으로 표현(2차원 리스트)
graph = [
    [],
    [2,3,8],
    [1,7],
    [1,4,5],
    [3,5],
    [3,4],
    [7],
    [2,6,8],
    [1,7],
]

# 각 노드가 방문된 정보를 리스트 자료형으로 표현(1차원 리스트)
visited = [False] * 9
dfs(graph, 1, visited)



print()

from collections import deque

#BFS 메서드 정의
def bfs(graph, start, visitd):
    # 큐(Queue) 구현을 위해 deque 라이브러리 사용
    queue = deque([start])
    # 현재 노드를 방문 처리
    visited[start] = True
    # 큐가 빌 때까지 반복
    while queue:
        # 큐에서 하나의 원소를 뽑아 출력
        v = queue.popleft()
        print(v, end=' ')
        # 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

# 각 노드가 연결된 정보를 리스트 자료형으로 표현(2차원 리스트)
graph = [
    [],
    [2,3,8],
    [1,7],
    [1,4,5],
    [3,5],
    [3,4],
    [7],
    [2,6,8],
    [1,7],
]

# 각 노드가 방문된 정보를 리스트 자료형으로 표현(1차원 리스트)
visited = [False] * 9
# 정의된 BFS 함수 호출
bfs(graph, 1, visited)

print()

#이진 탐색 소스코드 구현(반복문)
def binary_search(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        # 찾은 경우 중간점 인덱스 반환
        if array[mid] == target:
            return mid
        # 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
        elif array[mid] > target:
            end = mid - 1
        # 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
        else:
            start = mid + 1
    return None

# n(원소의 개수)과 target(찾고자 하는 문자열)을 입력받기
#n, target = list(map(int,input().split()))
n, target = [12,7]
# 전체 원소 입력받기
#array = list(map(int, input().split()))
array = [1,3,5,7,9,11,13,15,17,19]

# 이진 탐색 수행 결과 출력
result = binary_search(array, target, 0, n-1)
if result == None:
    print("원소가 존재하지 않습니다.")
else:
    print(result+1)