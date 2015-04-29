#!/usr/bin/python

def radixSort(a,n,maxLen):
    for x in range(maxLen):
        bins = [[] for i in range(n)]
        for y in a:
            bins[(y/10**x)%n].append(y)
        a=[]
        for section in bins:
            a.extend(section)
    return a


f = open('num.in', 'r')
list1 = []
for line in f:
		list1.append(line)
print list1
print (list1[0] + list1[2])