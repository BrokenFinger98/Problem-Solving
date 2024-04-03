#include<bits/stdc++.h>
using namespace std;
int n, ret;
pair<int, int> p[1000000];
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL); cout.tie(NULL);
    cin >> n;
    for(int i = 0; i < n; ++i)
        cin >> p[i].first >> p[i].second;
    sort(&p[0], &p[0]+n);
    int l = p[0].first;
    int r = p[0].second;
    for(int i = 0; i < n; ++i){
        if(r < p[i].first){
            ret += r-l;
            l = p[i].first;
            r = p[i].second;
        }else if(p[i].first <= r && p[i].second >= r){
            r = p[i].second;
        }
    }
    ret += r-l;
    cout << ret << "\n";
}