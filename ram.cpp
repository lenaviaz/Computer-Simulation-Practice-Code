class ram {
#include <string>

    public:
      int* capacity;
        ram(int size){
        capacity = new int[size];
        }


int read(int adress){
 // int arr[] = {1,2,3,4};
    //int toReturn = arr[adress];
    int a = capacity[adress];

}

void write(int adress, int x){

    capacity[adress] = x;

}

void initialize(int adress, String a){
//starting from int adress, fill the array with each character from a

for(int i = 0; i < a.length(); i++){
    char myChar = a[i];
    capacity[adress] = myChar;
}
}

int main() {

}



};