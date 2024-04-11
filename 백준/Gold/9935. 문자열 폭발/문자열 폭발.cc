#include<bits/stdc++.h>
using namespace std;
string s, t, ret;
stack<char> st;
int main(){
    cin >> s >> t;
    for(char a : s){
        st.push(a);
        if(st.size() >= t.size() && st.top() == t[t.size()-1]){
            string tmp = "";
            for(char c : t){
                tmp += st.top();
                st.pop();
            }
            reverse(tmp.begin(), tmp.end());
            if(tmp != t){
                for(char c : tmp)
                    st.push(c);
            }
        }
    }
    if(st.size() == 0){
        cout << "FRULA" << "\n";
    }else{
        while (st.size()){
            ret += st.top(); st.pop();
        }
        reverse(ret.begin(), ret.end());
        cout << ret << "\n";
    }
    return 0;
}

