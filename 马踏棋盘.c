#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int x; // 行号
    int y; // 列号
    int d[9]; // d[i]记录第i号方向是否已走过(0否, 1是)
}Spot;

typedef struct {
    Spot data[80];
    int top; // 记录栈顶的下标
} stack;

void initStack(stack **s) {
    (*s) = (stack *)malloc(sizeof(stack));
    (*s)->top = -1;
}

void push(Spot Cur, stack *s) {
    s->data[++s->top] = Cur;
}

void pop(stack *s, Spot *Cur) {
    (*Cur) = s->data[s->top--];
}

int Direction[2][9] = {
        {0, -2, -1, 1, 2, 2, 1, -1, -2},
        {0, 1, 2, 2, 1, -1, -2, -2, -1}
};

int Board[8][8] = {0}; // 棋盘

int Feasible(int x, int y) {
    if ((0 <= x) && (x < 8) && (0 <= y) && (y < 8) && (Board[x][y] == 0)) return 1;
    else return 0;
}

int Weight[8][8] = {0}; // 权值

int NextDirection(Spot Cur) {
    int MinDirection = 0;
    int MinWt = 9;
    int x, y;
    for (int k = 1; k <= 8; ++k) {
        if (Cur.d[k]) continue;
        x = Cur.x + Direction[0][k];
        y = Cur.y + Direction[1][k];
        if (Feasible(x, y) && Weight[x][y] < MinWt) {
            MinWt = Weight[x][y];
            MinDirection = k;
        }
    }
    return MinDirection;
}

void InitWeight() { // 设置初始权值
    int x, y;
    for (int i = 0; i < 8; ++i) {
        for (int j = 0; j < 8; ++j) {
            for (int k = 1; k <= 8; ++k) {
                x = i + Direction[0][k];
                y = j + Direction[1][k];
                if (Feasible(x, y)) {
                    Weight[i][j]++;
                }
            }
        }
    }
}

void SetWeight(int x, int y) { // 前进时设置权值
    int m, n;
    Weight[x][y] = 9; // 表示该位置已经被占用
    for (int k = 1; k <= 8; ++k) {
        m = x + Direction[0][k];
        n = y + Direction[1][k];
        if (Feasible(m, n)) {
            Weight[m][n]--;
        }
    }
}

void UnSetWeight(int x, int y) { // 回退时调整权值
    int m, n;
    Weight[x][y] = 0;
    for (int k = 1; k <= 8; ++k) {
        m = x + Direction[0][k];
        n = y + Direction[1][k];
        if (Feasible(m, n)) {
            Weight[x][y]++;
            Weight[m][n]++;
        }
    }
}

int main() {
    int count = 0, Step = 0;
    InitWeight();
    Spot Cur, Next;
    stack *s;
    initStack(&s);
    printf("请输入起始点的位置：");
    scanf("%d %d", &Cur.x, &Cur.y);
    for (int i = 0; i < 9; ++i) {
        Cur.d[i] = 0;
    }
    Step = 1;
    Board[Cur.x][Cur.y] = Step;
    SetWeight(Cur.x, Cur.y);
    while (Step < 64) {
        int k = NextDirection(Cur);
        if (k != 0) { // 该k方向可行
            Next.x = Cur.x + Direction[0][k];
            Next.y = Cur.y + Direction[1][k];
            for (int i = 0; i < 9; ++i) {
                Next.d[i] = 0;
            }
            Cur.d[k] = 1; // 第k方向已访问
            push(Cur, s); // Cur当前点入栈
            Cur = Next;
            Step++;
            Board[Cur.x][Cur.y] = Step;
            SetWeight(Cur.x, Cur.y);
        } else { // 没有方向可行, 回退
            Board[Cur.x][Cur.y] = 0;
            Step--;
            UnSetWeight(Cur.x, Cur.y);
            pop(s, &Cur); // Cur更新为出栈元素
            count++; // 记录回退次数
        }
    }

    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            printf("%d ", Board[i][j]);
        }
        printf("\n");
    }
    printf("回退次数:%d", count);
    return 0;
}
