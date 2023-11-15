package com.solvd.laba.block1.oop.model.interfaces;

import com.solvd.laba.block1.oop.model.users.UserAccount;

public interface AdminsPanel {
    void blockUser(UserAccount user);
    void unblockUser(UserAccount user);
}
