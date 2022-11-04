#include <stdio.h>

int search(int a[], int n) {
    int i, min;
    min = 0;
    for (i = 0; i < n; i++) {
        if (a[i] < a[min]) {
            min = i;
        }
    }
    return min;
}

int main() {
//    int i, j, k;
//    k = 1; /*ERROR*/
//    for (i = 1; i <= 4; i++) {
//        for (j = 1; j <= 4 - i; j++) {
//            printf(" ");
//        }
//        j = 1; /*ERROR*/
//        while (j <= i) {
//            printf("%d", k);
//            k = (k + 1) % 10;
//            j++;
//        }
//        printf("\n"); /*ERROR*/
//    }
//    char str1[100], str2[30], str[200];
//    int i, j;
//    printf("Enter the first string:");
//    gets(str1);
//    printf("Enter the second string:");
//    gets(str2);
//    for (i = 0; str1[i] != '\0'; i++)
//        str[i] = str1[i];
//    j = 0;
//    while (str2[j] != '\0') {
//        str[i++] = str2[j];
//        j++; /*ERROR*/
//    }
//    str[i+1] = "\0"; /*ERROR*/
//    printf("%s\n", str); /*ERROR*/
    int a[10] = {13, 1, -5, 4, 9, 0, -8, 7, -6, 2};
    int min;
    min = search(a, 10);
    printf("min=%d,address=%d\n", a[min], min);
    return 0;
}