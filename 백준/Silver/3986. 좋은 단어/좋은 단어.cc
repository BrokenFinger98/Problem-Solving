#include<bits/stdc++.h>
using namespace std;
int N, cnt;
string s;
stack<char> k[101];
int main(){
    cin >> N;
    for(int i = 0; i < N; ++i){
        cin >> s;
        for(int j = 0; j < s.length();++j){
            if(k[i].empty() || k[i].top() != s[j])
                k[i].push(s[j]);
            else
                k[i].pop();
        }
        if(k[i].empty())
            ++cnt;
    }
    cout << cnt;
}