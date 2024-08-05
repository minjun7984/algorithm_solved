import java.util.*;

public class Main {
    public static class Player implements Comparable<Player> {
        int level;
        String id;
        boolean check;

        Player(int level, String id, boolean check) {
            this.level = level;
            this.id = id;
            this.check = check;
        }

        @Override
        public int compareTo(Player p) {
            return id.compareTo(p.id);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int p = in.nextInt();
        int m = in.nextInt();
        Player[] players = new Player[p];

        for (int i = 0; i < p; i++) {
            int lv = in.nextInt();
            String id = in.next();
            players[i] = new Player(lv, id, false);
        }

        for (int i = 0; i < p; i++) {
            ArrayList<Player> room = new ArrayList<>();
            if (!players[i].check) {
                room.add(players[i]);
                players[i].check = true;
                for (int j = i; j < p; j++) {
                    if (room.size() == m) {
                        break;
                    }
                    int firstPlayerLevel = players[i].level;
                    if (!players[j].check && players[j].level >= firstPlayerLevel - 10 && players[j].level <= firstPlayerLevel + 10) {
                        players[j].check = true;
                        room.add(players[j]);
                    }
                }
                Collections.sort(room);
                if (room.size() == m) {
                    System.out.println("Started!");
                } else {
                    System.out.println("Waiting!");
                }
                for (Player player : room) {
                    System.out.println(player.level + " " + player.id);
                }
            }
        }
    }
}