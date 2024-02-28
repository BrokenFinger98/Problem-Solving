#include<bits/stdc++.h>
using namespace std;
int M;
int a[21], e, ret;
string s;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> M;
    for(int i = 0; i < M; ++i){
        cin >> s;
        if(s == "all"){
            fill(&a[0], &a[21], 1);
        }else if(s == "empty"){
            memset(a, 0, sizeof(a));
        }else{
            cin >> e;
            if(s == "add" && a[e] == 0){
                a[e] = 1;
            }else if(s == "remove" && a[e] == 1){
                a[e] = 0;
            }else if(s == "check"){
                if(a[e] == 1)
                    cout << 1 << "\n";
                else 
                    cout << 0 << "\n";
            }else if(s == "toggle"){
                if(a[e] == 1)
                    a[e] = 0;
                else 
                    a[e] = 1;
            }
        }
    }
}
