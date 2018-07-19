# Jingchi Coding Excercise--Jingwei

Java solutions for Jingchi coding excercise Q1 and Q2

## Requirements

- JRE: 1.8.0

## Introduction

### Q1
In Q1, I mainly use the idea of DFS to solve the question.
At first, given an input map, I at first find out and save the positions of the start place and all the checkpoints, and labled each checkpoint by the traversing order. Then from the start place, I traverse the map recursively and in each step, record the status of which chechpoints have already been treversed and how many steps have been took so far. Every time when we reached the goal place and find out that all the checkpoints also have been reached, then an available path was found. Among all the available paths, we keep maintain the one with shortest steps.

### Q2
In the first part of Q2, the task is find out the convex hull for a given set of points. The idea here is that we at first find out the left most point p, which must be a part of the convex hull, then we look for another point q, such that for any other point x, the orientation of p->q->x is always counterclockwise, and based on this q, we keep finding another q'...until we find the left most point p again, and now all the points we found so far can form the expected convex hull.

In the second part of Q2, the task is given a polygon and a point, determine whether this point locates inside the polygon. The idea here is that we try the line passes p and be horizontal with x-axis, if this line intersects with the polygon with odd intersect points, then it means p locates inside the polygon, otherwise p is in the outside of the this polygon

## Running

1. Clone [openpose repo](https://github.com/CMU-Perceptual-Computing-Lab/openpose)
2. Navigate to your openpose folder
3. Check the detailed usage instruction by the following scripts:

```
#for teacher behavior recognition
python behavior_recog_drawing_teacher.py -h

#for student behavior recognition
python behavior_recog_drawing_student.py -h
```

