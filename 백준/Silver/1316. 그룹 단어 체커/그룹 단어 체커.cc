#include <iostream>

using namespace std;

int main() {

  int n;
  string s;
  cin >> n;

  bool flag;
  int ans = 0;
  while(n--) {
    cin >> s;

    bool isUsed[26] = { false, };
    isUsed[s[0] - 'a'] = true;
    flag = true;

    for(int i = 1; i < s.length(); i++) {
      if(s[i] == s[i - 1]) continue;

      if(isUsed[s[i] - 'a']) flag = false;

      isUsed[s[i] - 'a'] = true;
    }

    if(flag) ans++;
  }

  cout << ans;

  return 0;
}