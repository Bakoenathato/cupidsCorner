package za.ac.cput.factory;


import za.ac.cput.domain.Block;
public class BlockFactory {

    public static Block createBlock(String blocker, String blocked, String timestamp) {

        if (blocker == null || blocker.isEmpty()) {
            throw new IllegalArgumentException("Blocker cannot be null or empty");
        }
        if (blocked == null || blocked.isEmpty()) {
            throw new IllegalArgumentException("Blocked cannot be null or empty");
        }
        if (timestamp == null || timestamp.isEmpty()) {
            throw new IllegalArgumentException("Timestamp cannot be null or empty");
        }


        return new Block.Builder()
                .setBlocker(blocker)
                .setBlocked(blocked)
                .setTimestamp(timestamp)
                .build();
    }
}

