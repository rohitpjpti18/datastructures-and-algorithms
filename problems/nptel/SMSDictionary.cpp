#include <iostream>
#include <vector>
#include <map>
using namespace std;

int generateCode(string word){
    map<char, int> keypad_code;

    keypad_code['a'] = 2;
    keypad_code['b'] = 2;
    keypad_code['c'] = 2;

    keypad_code['d'] = 3;
    keypad_code['e'] = 3;
    keypad_code['f'] = 3;

    keypad_code['g'] = 4;
    keypad_code['h'] = 4;
    keypad_code['i'] = 4;

    keypad_code['j'] = 5;
    keypad_code['k'] = 5;
    keypad_code['l'] = 5;

    keypad_code['m'] = 6;
    keypad_code['n'] = 6;
    keypad_code['o'] = 6;

    keypad_code['p'] = 7;
    keypad_code['q'] = 7;
    keypad_code['r'] = 7;
    keypad_code['s'] = 7;

    keypad_code['t'] = 8;
    keypad_code['u'] = 8;
    keypad_code['v'] = 8;

    keypad_code['w'] = 9;
    keypad_code['x'] = 9;
    keypad_code['y'] = 9;
    keypad_code['z'] = 9;

    int final_word = 0;
    int digit_weight = 1;
    for(int i = word.size()-1; i>-1; i--){
        final_word += keypad_code[word[i]]*digit_weight;
        digit_weight *= 10;
    }

    return final_word;
}

int main(){
    int n;
    int temp;

    map<int, int> input_sequence_freq;


    cin>> n;
    for(int i = 0; i<n; i++){
        string temp; 
        cin>> temp;
        int code = generateCode(temp);
        if(input_sequence_freq.find(code) == input_sequence_freq.end()){
            input_sequence_freq.insert(pair<int, int>(code, 1));
        }else{
            input_sequence_freq[code]++;
        }
    }

    int max = 0;
    int max_word;
    for(auto a : input_sequence_freq){
        if(a.second > max){
            max_word = a.first;
            max = a.second;
        }
    }

    cout<< max_word;

    return 0;
}