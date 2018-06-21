package com.wildhogs;

public class Menu {

        private String menu;
        private String home;
        private String weeklist;
        private String kitchenBook;

        public Menu(String menu, String home, String weeklist, String kitchenBook) {
            this.menu = menu;
            this.home = home;
            this.weeklist = weeklist;
            this.kitchenBook = kitchenBook;
        }

        public void printMenu() {
            System.out.println(this.menu + "\n" + this.home + "\n" + this.weeklist + "\n" + this.kitchenBook);
        }

        public String getMenu() {
            return this.menu;
        }

        public String getHome() {
            return this.home;
        }

        public String getWeeklist() {
            return this.weeklist;
        }

        public String getKitchenBook() {
            return this.kitchenBook;
        }
    }


