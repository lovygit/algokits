public class FindMazePath{
    private static class Step{
        private int x;
        private int y;
        private Move move;
        public Step(int x,int y,Move move){
            this.x=x;
            this.y=y;
            this.move=move;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Move getMove() {
            return move;
        }

        public void setMove(Move move) {
            this.move = move;
        }

        @Override
        public String toString(){
            return "("+x+","+y+")";
        }
    }

    private static enum Move{
        NORTH(0,-1,0),SOUTH(1,1,0),EAST(2,0,1),WEST(3,0,-1),
        WEST_NORTH(4,-1,-1),WEST_SOUTH(5,1,-1),EAST_NORTH(6,-1,1),EAST_SOUTH(7,1,1);
        private int dx;
        private int dy;
        private int val;
        private Move(int val,int dx,int dy){
            this.val=val;
            this.dx=dx;
            this.dy=dy;
        }

        public int getDx() {
            return dx;
        }

        public int getDy() {
            return dy;
        }

        public int getVal() {
            return val;
        }
    }

    private static int[][] maze={
            {1,1,1,1,1,1,1,1,1},
            {1,0,0,0,0,1,1,1,1},
            {1,1,1,0,0,0,0,1,1},
            {1,0,0,0,1,1,1,1,1},
            {1,1,0,1,1,0,1,0,1},
            {1,1,0,0,1,0,1,0,1},
            {1,1,0,1,0,0,0,0,1},
            {1,1,0,0,0,0,1,1,1},
            {1,1,1,1,1,1,1,1,1},

    };
    private static void findPath(int[][] maze,int startX,int startY,int targetX,int targetY){
        if(startX==targetX&&startY==targetY){
            System.out.println("You have been at the target point...");
        }
        boolean[][] mark=new boolean[maze.length][maze[0].length];
        for(int i=0;i<maze[0].length;i++){
            mark[0][i]=mark[mark.length-1][i]=true;
        }
        for(int i=0;i<maze.length;i++){
            mark[i][0]=mark[i][mark[0].length-1]=true;
        }

        List<Step> stepStack=new ArrayList<>();
        stepStack.add(new Step(startX,startY,Move.WEST));
        Step step;
        int dx,dy,x,y;
        boolean finded=false;
        boolean changed=false;
        do{
            step=stepStack.remove(stepStack.size()-1);
            while(!finded){
                changed=false;
                x=step.getX();
                y=step.getY();
                for(Move move:Move.values()){
                    dx=move.getDx();
                    dy=move.getDy();
                    if(maze[x+dx][y+dy]==0&&!mark[x+dx][y+dy]){
                        mark[x+dx][y+dy]=true;
                        changed=true;
                        if(x+dx==targetX&&y+dy==targetY){
                            finded=true;
                        }
                        stepStack.add(new Step(x+dx,y+dy,move));
                        step.setX(x+dx);
                        step.setY(y+dy);
                        step.setMove(move);
                        break;
                    }
                }
                if(!changed)
                    break;
            }
        }while(!finded&&stepStack.size()>0);

        System.out.print("("+startX+","+startY+")->");
        for(Step oneStep:stepStack){
            System.out.print("("+oneStep.getX()+","+oneStep.getY()+")->");
        }
        System.out.println("Stop!!!");
    }
 }
