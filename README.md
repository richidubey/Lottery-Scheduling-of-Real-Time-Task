# Lottery-Scheduling-of-Real-Time-Task
This project aims to implement Lottery Scheduling of Real Time Tasks using Cheddar, an open source scheduler. 

**What is Lottery Scheduler?**    

In this scheduler, every task have some tickets and scheduler picks a random ticket
and task having that ticket is the winner and it is executed for a time slice and then
another ticket is picked by the scheduler. These tickets represent the share of tasks. A
task having a higher number of tickets give it more chance to get chosen for execution.


**How to write a user-defined scheduler for Cheddar simulations?**    

The user-defined schedulers are written in ADA Language for Cheddar. They have the
.sc extension. For reference, you can look into the other predefined codes available in
the library. There are various sections like start_section, priority_section and
election_section.    

*start_section*: This is basically the constructor, i.e., the first section which runs during
the start and it runs only one time. It is usually used for initializing the variables and
the piece of code which will run only once throughout the simulation.    

*priority_section*: This is the section which is called every time when a scheduling
decision has to be made. (For, the preemptive system this section is called at every
instance of time. For, non-preemptive system this section is called after it completes
the execution of the currently running task.)   

*election_section*: This section returns the index of the task which should get the
scheduler time for the current instance of time. This section should return only one
value.   

You can access various variables for writing the user-defined schedulers. You can get a
list of these variables in this [link](http://beru.univ-brest.fr/~singhoff/cheddar/ug/ug_v3/cheddar-r3.html#Ref6.5).




1. **About Source Code**:

The source file is named : meme.sc

To implement the lottery scheduler we had to give more tickets to jobs having less capacity(execution time).

I did this by dividing the LCM of capacity of all tasks by the capacity of the current task(which we are calculating the tickets for). 
This works as smaller number has to have more multiples of it to reach the LCM compared with the larger numbers.

I have also commented the code wherever necessary and as much as possible for good readability.


2. **Task sets**:

There are 3 project files named Example1,Example2,Example3 with their corresponding .png snapshot of its schedule. 

The tasks for each file is :

Example 1:

T1 - (10,3,10)
T2 - (10,2,10)
T3 - (15,5,15)


Example 2:

T1 - (20,5,20)
T2 - (20,10,20)
T3 - (20,5,20)

This example has 100% and utilization is still schedulable. But we can not infer anything from this. This scheduler resembles **shortest job first scheduler** whose schedulable utilization is not 100%!!

Example 3:

T1 - (20,5,20)
T2 - (20,4,20)
T3 - (20,5,20)
T4 - (2,8,1,5)
T5 - (3,8,2,8)


3. **Assumptions made**:

> Based on the total number of tickets and all the tasks which are in the ready
queue, you have to distribute the ticket number range to these tasks.
> The allotment of the number of tickets should be such that the task contributing
more to the utilization factor of the processor gets less number of tickets.
> All tasks will be periodic tasks.
> All tasks will have a capacity (execution time) greater than zero.
> It is a pre-emptive scheduler.
> It is a unicore processor.











