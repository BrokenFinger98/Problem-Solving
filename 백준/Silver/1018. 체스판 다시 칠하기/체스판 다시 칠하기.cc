#include<bits/stdc++.h>
using namespace std;
int N, M, minVal = 65;
string s;
string a[50];
string b[8] = {
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB"
};
string c[8] = {
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW"
};
int check(int i, int j){
    int cnt1 = 0;
    int cnt2 = 0;
    for(int k = i; k < i + 8; ++k){
        for(int l = j; l < j + 8; ++l){
            if(a[k][l] != b[k-i][l-j])
                ++cnt1;
            if(a[k][l] != c[k-i][l-j])
                ++cnt2;    
        }
    }
    return min(cnt1, cnt2);
}
int main(){
    int cnt = 0;
    cin >> N >> M;
    getchar();
    for(int i = 0; i < N; ++i){
        getline(cin, a[i]);
    }
    for(int i = 0; i < N - 7; ++i){
        for(int j = 0; j < M - 7; ++j){
            cnt = check(i ,j);
            if(cnt < minVal) minVal = cnt;
        }
    }
    cout << minVal << "\n";
    return 0;
}
