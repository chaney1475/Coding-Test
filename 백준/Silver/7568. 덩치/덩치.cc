#include <stdio.h>
typedef struct pare {
	int x;
	int y;
	int rank;
} pare;
pare p[50];
void ranking(int n)
{
	int i, j;
	for (i = 0; i < n; i++) 
		p[i].rank = 1;

	for (i = 0; i < n; i++) {
		for (j = i + 1; j < n; j++) {
			if (p[i].x < p[j].x && p[i].y < p[j].y)
				p[i].rank++;
			else if (p[i].x > p[j].x && p[i].y > p[j].y)
				p[j].rank++;
		}
	}
	for (i = 0; i < n; i++)
		printf("%d ", p[i].rank);
}
int main(void)
{
	int n;
	int i;
	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		scanf("%d%d", &p[i].x, &p[i].y);
	}

	ranking(n);
}