#include<bits/stdc++.h>
using namespace std;
int r, c, y, x, ret;
const int INF = 987654321;
char mp[1000][1000];
int visitedj[1000][1000], visitedf[1000][1000];
int dy[4] = {1, 0, -1, 0};
int dx[4] = {0, 1, 0, -1};
pair<int, int> J;
queue<pair<int, int>> q;
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0); 
    cin >> r >> c;
    fill(&visitedf[0][0], &visitedf[0][0] + 1000*1000, INF);
    for(int i = 0; i <r; ++i){
        for(int j = 0; j < c; ++j){
            cin >> mp[i][j];
            if(mp[i][j] == 'J')
                J = {i, j};    
            else if(mp[i][j] == 'F'){
                visitedf[i][j] = 1;
                q.push({i, j});
            } 
        }
    }

    while (q.size()){
        tie(y, x) = q.front();
        q.pop();
        for(int i = 0; i < 4; ++i){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
            if(mp[ny][nx] == '#') continue;
            if(visitedf[ny][nx] != INF) continue;
            visitedf[ny][nx] = visitedf[y][x] + 1;
            q.push({ny, nx});
        }
    }
    
    visitedj[J.first][J.second] = 1;
    q.push(J);
    while (q.size()){
        tie(y, x) = q.front();
        q.pop();
        if(y == r-1 || x == c-1 || y == 0 || x == 0){
            ret = visitedj[y][x];
            break;
        }
        for(int i = 0; i < 4; ++i){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
            if(mp[ny][nx] == '#') continue;
            if(visitedj[ny][nx]) continue;
            if(visitedj[y][x] + 1 >= visitedf[ny][nx]) continue;
            visitedj[ny][nx] = visitedj[y][x] + 1;
            q.push({ny, nx});
        }
    }

    if(ret) cout << ret << "\n";
    else cout << "IMPOSSIBLE" << "\n";
    return 0;
}