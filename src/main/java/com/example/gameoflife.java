package com.example;

public class gameoflife {
        public static void main(String[] args) {
            
            /*if (args.length != 2) {
                System.err.println("We need two command line arguments");
                System.exit(1);
            }

            int numCells = Integer.parseInt(args[0]);
            int numCopies = Integer.parseInt(args[1]);*/

            int numCells = 100;
            int numCopies = 20;

            if (numCells < 0 || numCopies < 0) {
                System.err.println("The number of cells and copies must be positive");
                System.exit(1);
            }

            StdDraw.setCanvasSize(700, 700);
            StdDraw.setScale(0, numCells-1);
            StdDraw.enableDoubleBuffering();

            int [][] state = new int [numCells][numCells];

            for(int x=0; x < numCopies; x++) {
                blinker(state, (int)(Math.random() * numCells), (int)(Math.random() * numCells));
                glider(state, (int)(Math.random() * numCells), (int)(Math.random() * numCells));
                beehive(state, (int)(Math.random() * numCells), (int)(Math.random() * numCells));
                pulsar(state, (int)(Math.random() * numCells), (int)(Math.random() * numCells));
            }
            draw(state);

            while(true){
                state=updateState(state);
                draw(state);
            }
        }

        public static void draw(int [][]state){
            StdDraw.clear(StdDraw.BLACK);
            for (int y = 0; y < state.length; y++) {
                for (int x = 0; x < state.length; x++) {
                    if (state[x][y] == 0) {
                        StdDraw.setPenColor(StdDraw.BLACK);
                    } else {
                        StdDraw.setPenColor(StdDraw.BLUE);
                    }
                    StdDraw.filledSquare(x, y, 0.5);
                }
            }
            StdDraw.show();
            StdDraw.pause(100);
        }

        //blinker
        public static void blinker(int [][] state, int c, int r){
            state[c][r]=1;
            state[c][(r+1) % state.length]=1;
            state[c][(state.length + (r-1)) % state.length]=1;
        }

        //glider
        public static void glider(int [][] state, int c, int r){
            state[c][r]=1;
            state[(c+1) % state.length][r]=1;
            state[(c+1) % state.length][(r+1) % state.length]=1;
            state[c][(state.length + (r-1)) % state.length]=1;
            state[(state.length + (c-1)) % state.length][(r+1) % state.length]=1;
        }

        //beehive
        public static void beehive(int [][] state, int c, int r){
            state[c][r]=1;
            state[(c+1) % state.length][(r+1) % state.length]=1;
            state[(c+2) % state.length][(r+1) % state.length]=1;
            state[(c+3) % state.length][r]=1;
            state[(c+1) % state.length][(state.length + (r-1)) % state.length]=1;
            state[c+2][(state.length + (r-1)) % state.length]=1;
        }

        //pulsar
        public static void pulsar(int [][] state, int c, int r){
            state[c][r]=1;
            state[c][(state.length + (r-1)) % state.length]=1;
            state[c][(state.length + (r-2)) % state.length]=1;

            state[(c+2) % state.length][(r+2) % state.length]=1;
            state[(c+3) % state.length][(r+2) % state.length]=1;
            state[(c+4) % state.length][(r+2) % state.length]=1;

            state[(c+5) % state.length][r]=1;
            state[(c+5) % state.length][(state.length + (r-1)) % state.length]=1;
            state[(c+5) % state.length][(state.length + (r-2)) % state.length]=1;

            state[(c+2) % state.length][(state.length + (r-3)) % state.length]=1;
            state[(c+3) % state.length][(state.length + (r-3)) % state.length]=1;
            state[(c+4) % state.length][(state.length + (r-3)) % state.length]=1;

            //
            state[(c+7) % state.length][r]=1;
            state[(c+7) % state.length][(state.length + (r-1)) % state.length]=1;
            state[(c+7) % state.length][(state.length + (r-2)) % state.length]=1;

            state[(c+8) % state.length][r+2]=1;
            state[(c+9) % state.length][r+2]=1;
            state[(c+10) % state.length][r+2]=1;

            state[(c+12) % state.length][r]=1;
            state[(c+12) % state.length][(state.length + (r-1)) % state.length]=1;
            state[(c+12) % state.length][(state.length + (r-2)) % state.length]=1;

            state[(c+8) % state.length][(state.length + (r-3)) % state.length]=1;
            state[(c+9) % state.length][(state.length + (r-3)) % state.length]=1;
            state[(c+10) % state.length][(state.length + (r-3)) % state.length]=1;

            //
            state[c][(state.length + (r-6)) % state.length]=1;
            state[c][(state.length + (r-7)) % state.length]=1;
            state[c][(state.length + (r-8)) % state.length]=1;

            state[(c+2) % state.length][(state.length + (r-5)) % state.length]=1;
            state[(c+3) % state.length][(state.length + (r-5)) % state.length]=1;
            state[(c+4) % state.length][(state.length + (r-5)) % state.length]=1;

            state[(c+5) % state.length][(state.length + (r-6)) % state.length]=1;
            state[(c+5) % state.length][(state.length + (r-7)) % state.length]=1;
            state[(c+5) % state.length][(state.length + (r-8)) % state.length]=1;

            state[(c+2) % state.length][(state.length + (r-10)) % state.length]=1;
            state[(c+3) % state.length][(state.length + (r-10)) % state.length]=1;
            state[(c+4) % state.length][(state.length + (r-10)) % state.length]=1;

            //
            state[(c+7) % state.length][(state.length + (r-6)) % state.length]=1;
            state[(c+7) % state.length][(state.length + (r-7)) % state.length]=1;
            state[(c+7) % state.length][(state.length + (r-8)) % state.length]=1;

            state[(c+8) % state.length][(state.length + (r-5)) % state.length]=1;
            state[(c+9) % state.length][(state.length + (r-5)) % state.length]=1;
            state[(c+10) % state.length][(state.length + (r-5)) % state.length]=1;

            state[(c+12) % state.length][(state.length + (r-6)) % state.length]=1;
            state[(c+12) % state.length][(state.length + (r-7)) % state.length]=1;
            state[(c+12) % state.length][(state.length + (r-8)) % state.length]=1;

            state[(c+8) % state.length][(state.length + (r-10)) % state.length]=1;
            state[(c+9) % state.length][(state.length + (r-10)) % state.length]=1;
            state[(c+10) % state.length][(state.length + (r-10)) % state.length]=1;
        }

        public static int aliveNeighbors(int [][] state, int c, int r){
            int count=0;

            count+=state[(state.length + (c-1)) % state.length][r];
            count+=state[(c+1) % state.length][r];

            count+=state[(state.length + (c-1)) % state.length][(r+1) % state.length];
            count+=state[c][(r+1) % state.length];
            count+=state[(c+1) % state.length][(r+1) % state.length];

            count+=state[(state.length + (c-1)) % state.length][(state.length + (r-1)) % state.length];
            count+=state[c][(state.length + (r-1)) % state.length];
            count+=state[(c+1) % state.length][(state.length + (r-1)) % state.length];

            return count;
    }

    public static int[][] updateState(int [][] state){
        int[][] updatedState = new int[state.length][state.length];

        for(int y=0; y < state.length; y++){
            for(int x=0; x<state.length; x++){
                int aliveneighbors=aliveNeighbors(state,x,y);

                if (state[x][y] == 1){
                    if (aliveneighbors < 2){
                        updatedState[x][y]=0;
                    }

                    else if(aliveneighbors == 2 || aliveneighbors == 3){
                        updatedState[x][y]=1;
                    }

                    else if(aliveneighbors > 3){
                        updatedState[x][y]=0;
                    }
                }

                else if(aliveneighbors == 3){
                    updatedState[x][y]=1;
                }
            }
        }
        return updatedState;
    }
}
