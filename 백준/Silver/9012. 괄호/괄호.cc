#include<bits/stdc++.h>
using namespace std;
int t;
char c;
string s;
stack<char> st;
string checkVPS(string a){
    for(int i = 0; i < a.size(); ++i){
        c = a[i];
        if(c == '(')
            st.push(c);
        else{
            if(st.size()){
                if(st.top() == '(')
                    st.pop();
            }else return "NO";
        }
    }
    if(st.size()) return "NO";
    return "YES";
}
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);
    cin >> t;
    for(int i = 0; i < t; ++i){
        cin >> s;
        cout << checkVPS(s) << "\n";
        while(st.size())
            st.pop();
    }
}