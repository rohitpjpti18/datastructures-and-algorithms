/*
Given a distance ‘dist, count total number of ways to cover the distance with 1, 2 and 3 steps.
*/
#include<iostream>
#include<vector>
using namespace std;

int waysToCoverDistance(int dist){
    vector<int> ways(dist+1, 0);

    ways[0] = 0;
    ways[1] = 1;
    ways[2] = 2;
    ways[3] = 4;

    for(int i = 4; i<dist+1; i++){
        ways[i] = ways[i-1] + ways[i-2] + ways[i-3];
    }

    return ways[dist];
}

void testWaysToCoverDistance(){
    int result;
    bool output=true;

    result = waysToCoverDistance(4);
    if(result != 7){
        cout<<"Failed: for dist = 4 expected 7 but got " << result <<endl;
        output = false;
    }

    if(output){
        cout<<"OK.... passed all cases"<< endl;
    }
}

int main(){
    testWaysToCoverDistance();

    return 0;
}
