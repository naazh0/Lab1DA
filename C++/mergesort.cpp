#include <iostream>
#include <fstream>
#include <cstdlib>
#include <time.h>
using namespace std;
//http://en.wikibooks.org/wiki/Algorithm_Implementation/Sorting/Merge_sort
void merge(int a[], const int low, const int mid, const int high){
	int * b = new int[high+1-low];
	int h,i,j,k;
	h=low;
	i=0;
	j=mid+1;
	while((h<=mid)&&(j<=high)){
		if(a[h]<=a[j]){
			b[i]=a[h];
			h++;
		}
		else{
			b[i]=a[j];
			j++;
		}
		i++;
	}
	if(h>mid){
		for(k=j;k<=high;k++){
			b[i]=a[k];
			i++;
		}
	}
	else{
		for(k=h;k<=mid;k++){
			b[i]=a[k];
			i++;
		}
	}
	for(k=0;k<=high-low;k++){
		a[k+low]=b[k];
	}
	delete[] b;
}

void merge_sort( int a[], const int low, const int high ){
	int mid;
	if( low < high ){
		mid = ( low + high ) / 2;
		merge_sort( a, low, mid );
		merge_sort( a, mid + 1, high );
		merge( a, low, mid, high );
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
	merge_sort(numeros, 0, 15);
	endTime = clock();
	int timeDiff = (int)(difftime(endTime, startTime) * 10.0);
	for(i = 0; i < 15 ; i++){
		cout << numeros[i] << '\n';
	}
	cout << "The merge-sort algorithm took approximately " << timeDiff << " ms to execute." << endl;
	myfile.close();
	}
	else
		cout << "Unable to open file"; 
	return 0;
}