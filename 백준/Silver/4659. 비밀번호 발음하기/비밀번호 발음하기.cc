#include<bits/stdc++.h>
using namespace std;
string s;
int cnt;
bool isVowel(char a){
    if(a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u')
        return 1;
    return 0;
}
bool check1(){
    int i;
    for(i = 0; i < s.size(); ++i){
        if(isVowel(s[i]))
            break;
    }
    if(i == s.size())
        return 0;
    return 1;
}
bool check2(){
    if(s.length() < 3)
        return 1;
    for(int i = 0; i < s.length()-2; ++i){
        if(isVowel(s[i]) && isVowel(s[i+1]) && isVowel(s[i+2]))
            return 0;
        if(!isVowel(s[i]) && !isVowel(s[i+1]) && !isVowel(s[i+2]))
            return 0;
    }
    return 1;
}
bool check3(){
    if(s.length() < 2)
        return 1;
    for(int i = 0; i < s.size()-1; ++i){
        if(s[i] == s[i+1] && s[i] != 'e' && s[i] != 'o')
            return 0;
    }
    return 1;
}
int main(){
    while (1){
        cin >> s;
        if(s == "end")
            return 0;
        if(check1() == 0){
            cout << "<" << s << "> is not acceptable.\n";
            continue;
        }
        if(check2() == 0){
            cout << "<" << s << "> is not acceptable.\n";
            continue;
        }
        if(check3() == 0){
            cout << "<" << s << "> is not acceptable.\n";
            continue;
        }
        cout << "<" << s << "> is acceptable.\n";
    }
}