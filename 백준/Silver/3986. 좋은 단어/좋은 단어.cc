#include<bits/stdc++.h>
using namespace std; 
int N, cnt;
stack<char> st[104];
string s;
int main(){
    ios_base::sync_with_stdio();
    cin.tie(NULL); cout.tie(NULL);
    cin >> N;
    for(int i = 0; i < N; ++i){
        cin >> s;
        for(int j = 0; j < s.length(); ++j){
            if(st[i].size() && st[i].top() == s[j])
                st[i].pop();
            else
                st[i].push(s[j]);
        }
        if(st[i].size() == 0)
            ++cnt;
    }
    cout << cnt;
}