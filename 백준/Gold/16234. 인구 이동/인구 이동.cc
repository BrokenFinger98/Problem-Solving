#include<bits/stdc++.h>
using namespace std;
int n, L, R, cnt, sum;
int mp[50][50];
int visited[50][50];
vector<pair<int, int>> v;
int dy[4] = {1, 0, -1, 0};
int dx[4] = {0, 1, 0, -1};
void dfs(int y, int x, vector<pair<int, int>> &v){
    for(int i = 0; i < 4; ++i){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
        if(L <= abs(mp[y][x]-mp[ny][nx]) && R >= abs(mp[y][x]-mp[ny][nx]) && !visited[ny][nx]){
            visited[ny][nx] = 1;
            v.push_back({ny, nx});
            sum += mp[ny][nx];
            dfs(ny, nx, v);
        }
    }
    return;
}
void go(){
    int flag = 0;
    memset(visited, 0, sizeof(visited));
    for(int i = 0; i < n; ++i){
        for(int j = 0; j < n; ++j){
            if(!visited[i][j]){
                v.clear();
                visited[i][j] = 1;
                v.push_back({i, j});
                sum = mp[i][j];
                dfs(i, j, v);
                if(v.size() > 1){
                    flag = 1;
                    int avg = sum/v.size();
                    for(pair<int, int> a : v){
                        mp[a.first][a.second] = avg;
                    }
                }
            }
        }
    }
    if(flag == 0){
        cout << cnt << "\n";
        exit(0);
    }
    ++cnt;
}
int main(){
    cin >> n >> L >> R;
    for(int i = 0; i < n; ++i){
        for(int j = 0; j < n; ++j){
            cin >> mp[i][j];
        }
    }
    while (true){
        go();
    }
    return 0;
}