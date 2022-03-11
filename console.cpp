#include <iostream>
using namespace std;

class console {

void write(int a){
 
 char c = (char)a;
std::cout << c <<std::endl;

}

int main() {
 
   char input;
   cout << "Enter a character: ";
   cin>>input;
  // std::cout << input <<std::endl;
  cout << "ASCII value is: " << int(input);

  // write(35);
    return 0;
}


};


