public class Adventure {
    private Room currentRoom;


    public void createRooms() {
        Room room1 = new Room("a classroom", "There is tables and chairs");

        Room room2 = new Room("the toilet", "There is toilets and a hand wash");

        Room room3 = new Room("the game-room", "There is table tennis");

        Room room4 = new Room("the bicycle-basement", "Its a very big room and there is a lot of bicycles");
        Room room5 = new Room("the code-lab", "There is a lot of nerds, who sitting and programming shitty program");
        Room room6 = new Room("the library", "There is bookshelves and very quiet");
        Room room7 = new Room("the canteen", "There is people sitting and eating food");
        Room room8 = new Room("the office", "There is teachers sitting and drinking coffee");
        Room room9 = new Room("the 'fredags-bar'", "There is horny girls and cheap 'buca-shots");

        room1.setEast(room2);
        room1.setNorth(null);
        room1.setWest(null);
        room2.setWest(room1);

        room2.setWest(room1);
        room2.setEast(room3);

        room3.setWest(room2);
        room3.setSouth(room6);

        room4.setNorth(room1);
        room4.setSouth(room7);

        room5.setSouth(room8);

        room6.setNorth(room3);
        room6.setSouth(room9);

        room7.setNorth(room4);
        room7.setEast(room8);

        room8.setWest(room7);
        room8.setNorth(room5);
        room8.setEast(room9);

        room9.setWest(room8);
        room9.setNorth(room6);

        currentRoom = room1;
    }


    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void goNorth() {
       currentRoom = currentRoom.getNorth();
    }

    public void goSouth() {
        if (currentRoom.getSouth() != null){
            currentRoom = currentRoom.getSouth();
            System.out.println(getCurrentRoom().getName() + getCurrentRoom().getDescription());

        }else {
            System.out.println("you cannot go that way");
        }
    }

    public void goEast() {
        if (currentRoom.getEast()!=null) {
            currentRoom = currentRoom.getEast();
            System.out.println(getCurrentRoom().getName() + getCurrentRoom().getDescription());
        } else {
            System.out.println("you can't go that way");
        }
    }

    public void goWest() {
        currentRoom = currentRoom.getWest();
    }

}
