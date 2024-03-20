#include<bits/stdc++.h>
using namespace std;
int a[1000000];
int ret[1000000];
int n;
stack<int> s;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(NULL); cout.tie(NULL);
    memset(ret, -1, sizeof(ret));
    cin >> n;
    for(int i = 0; i < n; ++i){
        cin >> a[i];
        while (s.size() && a[s.top()] < a[i]){
            ret[s.top()] = a[i]; s.pop();
        }
        s.push(i);
    }
    for(int i = 0; i < n; ++i)
        cout << ret[i] << " ";
}
