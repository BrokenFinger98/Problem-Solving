#include<bits/stdc++.h>
using namespace std;
string s;
int flag = 0, i;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    while (1){
        cin >> s;
        flag = 0;
        if(s == "end")
            return 0;
        for(i = 0; i < s.length(); ++i){
            if(s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u')
                break;
        }
        if(i == s.length()){
            cout << "<" << s << "> is not acceptable.\n";
            continue;
        }
        for(i = 2; i < s.length(); ++i){
            if((s[i-2] == 'a' || s[i-2] == 'e' || s[i-2] == 'i' || s[i-2] == 'o' || s[i-2] == 'u') &&
                (s[i-1] == 'a' || s[i-1] == 'e' || s[i-1] == 'i' || s[i-1] == 'o' || s[i-1] == 'u') &&
                (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u')){
                cout << "<" << s << "> is not acceptable.\n";
                flag = 1;
                break;
            }else if((s[i-2] != 'a' && s[i-2] != 'e' && s[i-2] != 'i' && s[i-2] != 'o' && s[i-2] != 'u') &&
                (s[i-1] != 'a' && s[i-1] != 'e' && s[i-1] != 'i' && s[i-1] != 'o' && s[i-1] != 'u') &&
                (s[i] != 'a' && s[i] != 'e' && s[i] != 'i' && s[i] != 'o' && s[i] != 'u')){
                    cout << "<" << s << "> is not acceptable.\n";
                    flag = 1;
                    break;
            }
        }
        if(!flag){
            for(i = 0; i < s.length()-1; ++i){
                char c1, c2;
                c1 = s[i];
                c2 = s[i+1];
                if(c1 == c2){
                    if(c1 == 'e' || c1 == 'o')
                        continue;
                    else{
                        cout << "<" << s << "> is not acceptable.\n";
                        break;
                    }
                }
            }
            if(i == s.length()-1)
                cout << "<" << s << "> is acceptable.\n";
        } 
    }
}