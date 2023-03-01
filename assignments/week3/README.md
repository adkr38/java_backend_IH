# Week 3 Assignemnt

### When to use IntArrayList vs IntVector

**IntArrayList** is set up to have a smaller capacity by default & whenever it's exceeded it'll increase by 50%, so you should use IntArrayList when working with a small set of integers

` myIntArrayList = new IntArrayList(); for (int i = 0; i<20; i++){ myIntArrayList.add(i); }`
This will make the array create a copy of itself & increase its capacity twice (from 10 to 15 & from 15 to 30).

On the other hand, if you apply the same code to an IntVector

`myIntVector = new IntVecor(); for (int i = 0; i<20; i++){ myIntArrayList.add(i); }`

As the default capacity is 20, the vector will not be copied & will be faster as a result.
