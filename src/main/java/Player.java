public class Player {
    private Map map = new Map();
    private Room currentRoom;

    Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
    public boolean move(String direction) {
        Room requestedRoom = null;
        if (direction.charAt(0) == 'n') {
            requestedRoom = currentRoom.getNorth();
        } else if(direction.charAt(0) == 'e') {
            requestedRoom = currentRoom.getEast();
        } else if(direction.charAt(0) == 'w') {
            requestedRoom = currentRoom.getWest();
        } else if(direction.charAt(0) == 's') {
            requestedRoom = currentRoom.getSouth();
        }

        if (requestedRoom != null) {
            currentRoom = requestedRoom;
            return true;
        }else{
            return false;
        }
    }
}
