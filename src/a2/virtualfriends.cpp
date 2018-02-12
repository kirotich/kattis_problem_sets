#include<bits/stdc++.h> 
using namespace std; 
#define MAXSIZE 100000 

vector<int>G[MAXSIZE]; 

int parent[MAXSIZE]; 
int noOfFriends[MAXSIZE];
int _rank[MAXSIZE]; 

//recursively find representative of the set
int _findSet(int elem){ 
if(elem==parent[elem]) return elem;
     
      return parent[elem]=_findSet(parent[elem]);
} 

int _union (int user1,int user2) { 
    user1 = _findSet(user1); 
    user2 = _findSet(user2); 

    int ans=0; 

    if(user1 != user2){ 
        
        if( _rank[user1] > _rank[user2] ){ 
            parent[user2]=user1; 
            noOfFriends[user1]+=noOfFriends[user2]; 
            
        } else { 
            parent[user1]=user2; 
            noOfFriends[user2]+=noOfFriends[user1];
            
        } 
        
        if( _rank[user2] == _rank[user2] ){ 
            ++_rank[user1]; 
            noOfFriends[user1]++; 
   
        } 

    } 

    return max(noOfFriends[user1],noOfFriends[user2]); 

} 

int main() { 
    int testCases; 

    scanf("%d",&testCases); 

    while(testCases--) { 
        int friendShips; 
        scanf("%d",&friendShips); 
        int count=0; 
        map<string,int>myMap; 

    for(int i=0;i<=friendShips;i++)parent[i]=i,_rank[i]=0,noOfFriends[i]=1; 
    
    for(int i=0;i<friendShips;i++){ 

    char user1[25],user2[25]; 

    scanf("%s",user1);
    scanf("%s",user2); 

    if(!myMap[user1])myMap[user1]=++count; 

    if(!myMap[user2])myMap[user2]=++count; 

    int friends= _union(myMap[user1],myMap[user2]); 
    printf("%d\n",friends); 
    }

    } 
return 0; 

}



