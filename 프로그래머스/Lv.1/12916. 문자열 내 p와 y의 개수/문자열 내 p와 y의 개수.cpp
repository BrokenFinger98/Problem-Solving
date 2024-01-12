#include<bits/stdc++.h>
using namespace std;

bool solution(string s)
{   
    int pnum = 0, ynum = 0;
    for(int i = 0; i < s.length(); ++i){
        char c = s[i];
        if(c == 'p' || c == 'P')
            ++pnum;
        if(c == 'y' || c == 'Y')
            ++ynum;
    }
    if(pnum == ynum)
        return 1;
    return 0;
}