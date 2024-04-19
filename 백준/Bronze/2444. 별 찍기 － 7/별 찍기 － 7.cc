#include <bits/stdc++.h>
using namespace std;
int n;
int main(){
    cin >> n;
    // 위쪽 삼각형 출력
    for (int i = 1; i <= n; i++) {
        // 공백 출력
        for (int j = 1; j <= n - i; j++) {
            cout << ' ';
        }
        // 별 출력
        for (int j = 1; j <= 2 * i - 1; j++) {
            cout << '*';
        }
        cout << endl;
    }

    // 아래쪽 삼각형 출력
    for (int i = n - 1; i >= 1; i--) {
        // 공백 출력
        for (int j = 1; j <= n - i; j++) {
            cout << ' ';
        }
        // 별 출력
        for (int j = 1; j <= 2 * i - 1; j++) {
            cout << '*';
        }
        cout << endl;
    }
    return 0;
}