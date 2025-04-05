# 算法第四版

## chapter2 排序

### 算法对比

| 名称 | 时间 | 空间   | 特色     |
|----|----|------|:-------|
| 选择排序| O(N<sup>2</sup>)| O(1) | 比较次数少，运行时间和输入无关 |
| 插入排序| O(N<sup>2</sup>)| O(1) | 所需的时间取决于输入中元素的初始顺序       |
| 希尔排序|O(N<sup>2</sup>)| O(1) | 希尔排序更高效的原因是它权衡了子数组的规模和有序性       |

### 选择排序


### 练习
#### 按照算法 2.1 所示轨迹的格式给出选择排序是如何将数组 E A S Y Q U E S T I O N 排序的。

[E, A, S, Y, Q, U, E, S, T, I, O, N]</br>
[A, E, S, Y, Q, U, E, S, T, I, O, N]</br>
[A, E, S, Y, Q, U, E, S, T, I, O, N]</br>
[A, E, E, Y, Q, U, S, S, T, I, O, N]</br>
[A, E, E, I, Q, U, S, S, T, Y, O, N]</br>
[A, E, E, I, N, U, S, S, T, Y, O, Q]</br>
[A, E, E, I, N, O, S, S, T, Y, U, Q]</br>
[A, E, E, I, N, O, Q, S, T, Y, U, S]</br>
[A, E, E, I, N, O, Q, S, T, Y, U, S]</br>
[A, E, E, I, N, O, Q, S, S, Y, U, T]</br>
[A, E, E, I, N, O, Q, S, S, T, U, Y]</br>
[A, E, E, I, N, O, Q, S, S, T, U, Y]</br>
[A, E, E, I, N, O, Q, S, S, T, U, Y]</br>

#### 2.1.2 在选择排序中,一个元素最多可能会被交换多少次?平均可能会被交换多少次?

最多 被交换N-1次 【5,1,2,3,4】

平均 N<sup>2</sup>/4次


