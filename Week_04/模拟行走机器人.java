/**
 * 使用两个数组表示x轴y轴方向
 * 创建Set集合存储障碍物位置
 * 遇到转向指令根据x轴y轴数组 确定前进方向
 * 前进时每次前进一格然后计算欧式距离的平方，如果前进的一格为障碍物则原地不动并执行下条指令
 * 欧式距离的平方 = x^2 + y^2
 **/
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        int direction = 0;
        int ans = 0, lx = 0, ly = 0;
        Set<Long> locationSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            locationSet.add(((long)(obstacle[0] + 30000) << 16) + (long)(obstacle[1] + 30000));
        }
        for (int command : commands) {
            if (command == -1) {
                direction = (direction + 1) % 4;
            } else if (command == -2) {
                direction = (direction + 3) % 4;
            } else {
                for (int i = 0; i < command; ++i) {
                    int nextY = dy[direction] + ly;
                    int nextX = dx[direction] + lx;
                    Long location = ((long)(nextX + 30000) << 16) + (long)(nextY + 30000);
                    if (locationSet.contains(location))
                        break;
                    ly = nextY;
                    lx = nextX;
                    ans = Math.max(ans, ly * ly + lx * lx);
                }
            }

        }
        return ans;
    }
}