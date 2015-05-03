#include <iostream>
#include <fstream>
#include <cstdlib>
#include <time.h>
using namespace std;

int getMax(int arr[], int n){
	int max = arr[0];
	for (int i = 1; i < n; i++)
		if (arr[i] > max)
			max = arr[i];
	return max;
}

void countSort(int arr[], int n, int exp){
	int output[n];
	int i, count[10] = {0};
	for (i = 0; i < n; i++)
		count[(arr[i] / exp) % 10]++;
	for (i = 1; i < 10; i++)
		count[i] += count[i - 1];
	for (i = n - 1; i >= 0; i--){
		output[count[(arr[i] / exp) % 10] - 1] = arr[i];
		count[(arr[i] / exp) % 10]--;
	}
	for (i = 0; i < n; i++)
		arr[i] = output[i];
}


void radixsort(int arr[], int n){
	int m = getMax(arr, n);
	for (int exp = 1; m / exp > 0; exp *= 10)
		countSort(arr, n, exp);
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
	radixsort(numeros, 15);
	endTime = clock();
	int timeDiff = (int)(difftime(endTime, startTime) * 10.0);
	for(i = 0; i < 15 ; i++){
		cout << numeros[i] << '\n';
	}
	cout << "The radix-sort algorithm took approximately " << timeDiff << " ms to execute." << endl;
	myfile.close();
	}
	else
		cout << "Unable to open file"; 
	return 0;
}