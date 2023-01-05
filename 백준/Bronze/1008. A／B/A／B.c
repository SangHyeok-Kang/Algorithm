#include <stdio.h>

int main()
{
	int a, b;
	double sum;
	scanf("%d %d", &a, &b);
	
	sum = a / (double)b;

	printf("%.10lf", sum);

	return 0;
}