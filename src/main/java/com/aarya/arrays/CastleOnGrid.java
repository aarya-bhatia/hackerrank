package com.aarya.arrays;

import java.util.*;

public class CastleOnGrid {
    int n;
    Location[][] grid;

    public CastleOnGrid(int _n, char[][] map) {
        n = _n;
        grid = new Location[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Location L = new Location(i,j,map[i][j]);
                grid[i][j] = L;
            }
        }
    }

    public Location getLocation(int r, int c) {
        return grid[r][c];
    }

    static class Location {
        int row;
        int col;
        char val;
        boolean visited;

        public Location(int r, int c, char v) {
            row = r;
            col = c;
            val = v;
            visited = false;
        }

        boolean valid(){ return val == '.'; }
        void print(){ System.out.printf("row: %d, col: %d \n", row, col); }
    }

    public int solve(Location start, Location end) {
        System.out.println("Breadth first search....");
        Location[][] prev = new Location[n][n];
        Queue<Location> queue = new LinkedList<>();
        start.visited = true;
        queue.add(start);

        int r,c;

        while(!queue.isEmpty()) {
            Location L = queue.poll();

            System.out.println("Current location in queue is " + L.row + ", " + L.col);

            if(L.row == end.row && L.col == end.col) {
                break;
            }

            // find left neighbour
            r = L.row-1;
            c = L.col;

            while(r >= 0 && grid[r][c].valid()) {
                r--;
            }

            r++;

            if(r >= 0 && r < L.row && !grid[r][c].visited) {
                visit(grid[r][c], queue, prev, L);
            }

            // find right neighbour
            r = L.row + 1;
            while(r < n && grid[r][c].valid()) {
                r++;
            }

            r--;

            if(r < n && r > L.row && !grid[r][c].visited) {
                visit(grid[r][c], queue, prev, L);
            }

            // find top neighbour

            r = L.row;
            c = L.col - 1;
            while(c >= 0 && grid[r][c].valid()) {
                c--;
            }

            c++;

            if(c >= 0 && c < L.col && !grid[r][c].visited) {
                visit(grid[r][c], queue, prev, L);
            }

            // find bottom neighbour

            c = L.col + 1;
            while(c < n && grid[r][c].valid()) {
                c++;
            }

            c--;

            if(c < n && c > L.col && !grid[r][c].visited) {
                visit(grid[r][c], queue, prev, L);
            }
            
        }

        System.out.println("path->");
        Location crawl = end;
        int moves = 0;
        while(crawl != null) {
            crawl.print();
            crawl = prev[crawl.row][crawl.col];
            if(crawl != null) moves++;
        }
        return moves;
    }

    void visit(Location L, Queue<Location> q, Location[][] prev, Location current){
        q.add(L);
        L.visited = true;
        prev[L.row][L.col] = current;
    }

    public static void main(String args[]) {
        System.out.println("Hello, " + args[0].toLowerCase());
    }
}