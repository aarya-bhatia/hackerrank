package com.aarya.arrays;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CastleOnGridSolution {

    static int minimumMoves(String[] lines, int startX, int startY, int goalX, int goalY) {
        int n = lines.length;
        char map[][] = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = lines[i].charAt(j);
            }
        }
        CastleOnGrid cg = new CastleOnGrid(n, map);
        int moves = cg.solve(cg.getLocation(startX, startY), cg.getLocation(goalX, goalY));
        System.out.println("Moves " + moves);
        return moves;
    }

    public static void main(String args[]) throws IOException {
        String filename = args[0];
        System.out.println(filename);
        File f = new File(filename);
        Scanner scan = new Scanner(f, StandardCharsets.UTF_8.name());
        try {
            int n = scan.nextInt();
            System.out.println("n = " + n);
            String lines[] = new String[n];
            for(int i = 0; i < n; i++) {
                lines[i] = scan.next();
                System.out.println("Line: " + lines[i]);
            }
            int startX = scan.nextInt();
            int startY = scan.nextInt();
            int goalX = scan.nextInt();
            int goalY = scan.nextInt();
            int moves = minimumMoves(lines, startX, startY, goalX, goalY);
            System.out.println("Total moves = " + moves);
        }
        catch(Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        scan.close();
    }
}