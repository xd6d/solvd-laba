package com.solvd.laba.block1.oop.model.users;

public final class AdminAccount extends AbstractAccount implements AdminsPanel {

    public AdminAccount(String name, String lastName, String email, String contactPhone, String password) {
        super(name, lastName, email, contactPhone, password);
    }

    public void blockUser(UserAccount user) {
        user.setBlocked(true);
    }

    public void unblockUser(UserAccount user) {
        user.setBlocked(false);
    }
}
