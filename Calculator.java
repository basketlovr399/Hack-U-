abstract class Calories {
  int total = 0;
//   カロリーの合計
  int sum_calories(int array[]){
    for (int i = 0; i <= array.length; i++){
        total += array[i];
    }
    return total;
  } 
  
//   出力
  void show_food(String array[]){
    for (i = 0; i <= array.length; i++){
      System.out.print(array[i]);
    }
  }
  
  void show_calories(){
    for (i = 0; i
}
