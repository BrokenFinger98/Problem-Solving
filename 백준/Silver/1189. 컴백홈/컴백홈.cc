#include <bits/stdc++.h>
using namespace std;
int r, c, k, ret;
char a[5][5];
int visited[5][5];
int dy[4] = {1, 0, -1, 0};
int dx[4] = {0, 1, 0, -1};
void go(int y, int x, int cnt){
    if(y == 0 && x == c - 1 && cnt == k){
        ++ret;
        return;
    }
    if(cnt >= k) return;
    for(int i = 0; i < 4; ++i){
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || ny >= r || nx < 0 || nx >= c || visited[ny][nx]) continue;
        if(a[ny][nx] == 'T') continue;
        visited[ny][nx] = 1;
        go(ny, nx, cnt+1);
        visited[ny][nx] = 0;
    }
    return;
}
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL); cout.tie(NULL);
    cin >> r >> c >> k;
    for(int i = 0; i < r; ++i){
        for(int j = 0; j < c; ++j)
            cin >> a[i][j];
    }
    visited[r-1][0] = 1;
    go(r-1, 0, 1);
    cout << ret << "\n";
    return 0;
}