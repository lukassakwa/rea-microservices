package rea.system.common.model.offer;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Room {

    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    NO_INFORMATION("");

    private final static Map<String, Room> roomMap;

    static {
        roomMap = Arrays.stream(Room.values()).collect(Collectors.toMap(Room::getRoomNumber, room -> room));
    }

    private final String roomNumber;

    Room(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public static Room getRoom(String roomNumber) {
        return roomMap.getOrDefault(roomNumber, Room.NO_INFORMATION);
    }

}
