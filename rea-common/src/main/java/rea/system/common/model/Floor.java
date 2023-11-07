package rea.system.common.model;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Floor {

    ZERO("0"),
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

    private final static Map<String, Floor> floorMap;

    static {
        floorMap = Arrays.stream(Floor.values()).collect(Collectors.toMap(Floor::getFloorNumber, floor -> floor));
    }

    private final String floorNumber;

    Floor(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public static Floor getFloorNum(String roomNumber) {
        return floorMap.getOrDefault(roomNumber, Floor.NO_INFORMATION);
    }

}
