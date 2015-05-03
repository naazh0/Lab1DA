#include <iostream>
#include <fstream>
#include <cstdlib>
#include <time.h>
using namespace std;

void bucketSort (int arr[], int n){
	int m = 16;
	int buckets[m];
	for (int i = 0; i < m; ++i)
		buckets[i] = 0;
	for (int i = 0; i < n; ++i)
		++buckets[arr[i]];
	for (int i = 0, j = 0; j < m; ++j)
		for (int k = buckets[j]; k > 0; --k)
			arr[i++] = j;
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
	bucketSort(numeros, 15);
	endTime = clock();
	int timeDiff = (int)(difftime(endTime, startTime) * 10.0);
	for(i = 0; i < 15 ; i++){
		cout << numeros[i] << '\n';
	}
	cout << "The bucket-sort algorithm took approximately " << timeDiff << " ms to execute." << endl;
	myfile.close();
	}
	else
		cout << "Unable to open file"; 
	return 0;
}