#include<bits/stdc++.h>
using namespace std;
string s;
stack<char> st;
int main(){
    while (1){
        getline(cin, s);
        if(s == ".")
            return 0;
        for(int i = 0; i < s.size(); ++i){
            if(s[i] == '('){
                st.push(s[i]);
            }else if(s[i] == '['){
                st.push(s[i]);
            }else if(s[i] == ')'){
                if(st.size() == 0){
                    st.push(s[i]);
                    break;
                }else{
                    if(st.top() == '(')
                        st.pop();
                    else
                        break;
                }
            }else if(s[i] == ']'){
                if(st.size() == 0){
                    st.push(s[i]);
                    break;
                }else{
                    if(st.top() == '[')
                        st.pop();
                    else
                        break;
                }
            }
        }
        if(st.size()) cout << "no" << "\n";
        else cout << "yes" << "\n";
        while (st.size()){
            st.pop();
        }
    }
    return 0;
}
