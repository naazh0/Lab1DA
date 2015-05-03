#include <iostream>
#include <fstream>
#include <cstdlib>
#include <time.h>
using namespace std;

void quickSort(int arr[], int left, int right){
	int i = left, j = right;
	int tmp;
	int pivot = arr[(left + right) / 2];
	while (i <= j){
		while (arr[i] < pivot)
			i++;
		while (arr[j] > pivot)
			j--;
		if (i <= j){
			tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			i++;
			j--;
		}
	}
	if (left < j)
		quickSort(arr, left, j);
	if (i < right)
		quickSort(arr, i, right);
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
	quickSort(numeros, 0, 15);
	endTime = clock();
	int timeDiff = (int)(difftime(endTime, startTime) * 10.0);
	for(i = 0; i < 15 ; i++){
		cout << numeros[i] << '\n';
	}
	cout << "The quick-sort algorithm took approximately " << timeDiff << " ms to execute." << endl;
	myfile.close();
	}
	else
		cout << "Unable to open file"; 
	return 0;
}