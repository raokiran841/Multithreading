# Multithreading
when 2 threads try to access data from same memory many issues occur:
1. deadlock
2. race condition
3. congetion
4. visibility problem etc..

# Virtual Threads
-> Virtual Threads in java 21 typically have a shallow call stack, performaing as few as 
single http client call or single JDBC call.

-> single JVM might support millions of VT

-> VTs are not intended for long running CPU intensive operations

-> VTs can be used for high-throughput application, specially those that consists of
a great no of a great no of concurrent tasks that spend much of their time waiting.

-> VTs are not faster threads, they provide scale not speed.

# Java Executor service
-> high level concurrency utility that provides a way to manage and execute tasks Asychronuously in a pool of threads.

-> Executor service abstracts away the complexity of thread management.

Diff types:
1. Single Thread Executor
2. Fixed Thread Executor
3. Cached Thread Executor
4. Scheduled Thread Executor

# Producer consumer problem

-> when producer is producing fast and consumer is not able to consume in same pace then buffer will overflow.

-> when consumer is fast but producer can only produce so little in the buffer then the consumer is read empty buffer

-> In Java we can use BlockingQueue to solve this problem as put and take methods of blockingQueue take care of this issue. if the buffer is empty it doesn't allow reading and when the buffer reaches the max limit it doesn't allow a producer to put data.

-> If we don't want to use a blocking Queue then we can implement the same using synchronized, wait, and notifyAll methods of multithreading.
