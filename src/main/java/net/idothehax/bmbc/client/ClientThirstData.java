package net.matty.bmbc.client;

public class ClientThirstData {
    private static int playerThirst;

    public static void set(int thirst) {
        ClientThirstData.playerThirst = thirst;
    }

    public static int getPlayerThirst() {
        return playerThirst;
    }
}
