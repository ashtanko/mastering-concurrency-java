# Mastering concurrency in Java

Content:

# concepts
1. Java Memory Model
2. Monitor
3. Atomic field assignment
4. Race condition
5. Data race
6. Safe publication
7. Final fields
8. TODO

## Deadlock
Deadlock occurs when multiple threads need the same locks but obtain them in different order.

## Livelock
Livelock is another concurrency problem and is similar to deadlock. 
In livelock, two or more threads keep on transferring states between one another instead of waiting infinitely.
