  #include <stdio.h>
  #include <string.h>
  #include <stdlib.h>

  int cmpfunc(const void* a, const void* b){
      return *((int*)b) - *((int*)a);
  }

  int main(){
      int clients, totalTime;
      scanf("%d %d",&n,&totalTime);


      int curr[totalTime + 1];
      size_t lengths[totalTime + 1];
      memset(lengths, 0, (totalTime+1) * sizeof(size_t));
      memset(curr, 0, (totalTime+1) * sizeof(int));
      int cash[totalTime + 1][n];

      for (int i = 0; i < n; i++){
          int deposit,userTime;
          scanf("%d %d",&deposit,&userTime);
          cash[userTime][lengths[userTime]++] = deposit;

      }

      for (int i = 0; i <= totalTime; i++){
          if (lengths[i] > 1) qsort(cash[i], lengths[i], sizeof(int), cmpfunc);
      }

      int sum = 0;
      for (int i = totalTime; i >= 0; i--){
          int maximum = -1;
          int curr_max = -1;

          for (int j = i; j <= totalTime; j++){

              if (lengths[j] && cash[j][curr[j]] > maximum){
                  maximum = cash[j][curr[j]];
                  curr_max = j;
              }
          }
          if (curr_max != -1){
              sum += cash[curr_max][curr[curr_max]];
              curr[curr_max]++;
              lengths[curr_max]--;
          }
      }

      printf("%d\n",sum);
      return 0;
  }
