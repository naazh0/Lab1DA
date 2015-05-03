#include <iostream>
#include <fstream>
#include <cstdlib>
#include <time.h>
using namespace std;

void bubbleSort(int arr[], int n){
	bool swapped = true;
	int j = 0;
	int tmp;
	while (swapped){
		swapped = false;
		j++;
		for (int i = 0; i < n - j; i++){
			if (arr[i] > arr[i + 1]){
				tmp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = tmp;
				swapped = true;
			}
		}
	}
}


int main(){
	string line;
	int i = 0;
	int numeros[15];
	ifstream myfile ("num.in");
	if (myfile.is_open()){
		while ( getline (myfile,line) ){
			numeros[i] = atoi(line.c_str());
			i++;
		}
	time_t startTime, endTime;
	startTime = clock();
	bubbleSort(numeros, 15);
	endTime = clock();
	int timeDiff = (int)(difftime(endTime, startTime) * 10.0);
	for(i = 0; i < 15 ; i++){
		cout << numeros[i] << '\n';
	}
	cout << "The bubble-sort algorithm took approximately " << timeDiff << " ms to execute." << endl;
	myfile.close();
	}
	else
		cout << "Unable to open file"; 
	return 0;
}