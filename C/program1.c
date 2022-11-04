//
// Created by 32262 on 2022/11/4.
//编程输出两个数中的较大数（要求使用选择结构实现）。
//

#include <stdio.h>

int main() {
    int a, b;
    printf("Please input first number:");
    scanf("%d", &a);
    printf("Please input second number:");
    scanf("%d", &b);
    if (a < b) {
        printf("%d", b);
    } else {
        printf("%d", a);
    }
}
