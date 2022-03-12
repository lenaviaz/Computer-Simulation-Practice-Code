#include <iostream>
using namespace std;
class console {

public:

//byte (using int for now) to char
void write(int a){
    char c = char(a);
    cout << c;
}

// read char from keyboard and returns the ASCII value
void read(){
     char input;
     cout << "Enter a character: ";
     cin>>input;
     cout << "ASCII value is:  " << int(input);

}

};

int main(){
    console c1;
    //c1.read();
    c1.write(33); // should output "!"

}