#include<bits/stdc++.h>
using namespace std;
int n, m, sx, sy, ex, ey, cnt;
int visited[300][300];
char a[300][300];
int dy[4] = {1, 0, -1, 0};
int dx[4] = {0, 1, 0, -1};
queue<int> q, temp;
int main(){
    cin >> n >> m;
    cin >> sy >> sx >> ey >> ex;
    sy--; sx--; ey--; ex--;
    for(int i = 0; i < n; ++i){
        cin >> a[i];
    }
    q.push(1000*sy + sx);
    visited[sy][sx] = 1;
    while (a[ey][ex] != '0'){
        ++cnt;
        while (q.size()){
            int y = q.front() / 1000;
            int x = q.front() % 1000;
            q.pop();
            for(int i = 0; i < 4; ++i){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || ny >=n || nx < 0 || nx >= m || visited[ny][nx]) continue;
                visited[ny][nx] = cnt;
                if(a[ny][nx] != '0'){
                    a[ny][nx] = '0';
                    temp.push(1000 * ny + nx);
                }else q.push(1000 * ny + nx);
            }
        }
        q = temp;
    }
    cout << visited[ey][ex] << "\n";
    return 0;
}

