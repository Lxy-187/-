package com.lzw.studentschedule.utils;

import com.lzw.studentschedule.domain.Activity;

public class IntervalTree<N extends Comparable, T> {
    private IntervalNode<N,T> root;

    class Interval<N extends Comparable, T>{
        private N start;
        private N end;
        private T data;
        public Interval(N start, N end, T data) {
            this.start = start;
            this.end = end;
            this.data = data;
        }
    }
    class IntervalNode<N extends Comparable,T>{
        private Interval<N,T> interval;
        private IntervalNode<N,T> left;
        private IntervalNode<N,T> right;
        private int maxEnd;
        public IntervalNode(Interval<N,T> interval) {
            this.interval = interval;
        }
    }
}
class IntervalTreeTest{
    public static void main(String[] args) {
        IntervalTree<Time, Activity> intervalTree = new IntervalTree<>();
    }
}
