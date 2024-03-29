package com.solvd.laba.block1.oop.model.users;

import com.solvd.laba.block1.oop.model.interfaces.AdminsPanel;

public final class AdminAccount extends AbstractAccount implements AdminsPanel {

    public AdminAccount(String name, String lastName, String email, String contactPhone, String password) {
        super(name, lastName, email, contactPhone, password);
    }

    @Override
    public void blockUser(UserAccount user) {
        user.setBlocked(true);
    }

    @Override
    public void unblockUser(UserAccount user) {
        user.setBlocked(false);
    }
}
