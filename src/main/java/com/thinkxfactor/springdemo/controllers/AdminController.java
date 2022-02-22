package com.thinkxfactor.springdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

import com.thinkxfactor.springdemo.entity.Admin;

@RestController
@RequestMapping("/admins")
public class AdminController {
    private static ArrayList<HashMap> admins = generateAdmins();

    private static ArrayList<HashMap> generateAdmins() {
        ArrayList<HashMap> admins = new ArrayList<HashMap>();
        admins.add(new Admin("Admin A", "AdminA", "12345").getData());
        admins.add(new Admin("Admin B", "AdminB", "12345").getData());
        admins.add(new Admin("Admin C", "AdminC", "12345").getData());
        return admins;
    }

    @GetMapping("get-all-admins")
    public ArrayList<HashMap> getAllAdmins() {
        return admins;
    }

    @GetMapping("get-by-username/{username}")
    public HashMap getByUsername(@PathVariable String username) {
        for (HashMap admin : admins) {
            if (admin.get("username").equals(username)) {
                return admin;
            }
        }
        return null;
    }

    @PostMapping("add-admin")
    public HashMap addAdmin(@RequestBody Admin admin) {
        admins.add(admin.getData());
        return admin.getData();
    }

    @GetMapping("delete-by-username/{username}")
    public HashMap deleteByUsername(@PathVariable String username) {
        for (HashMap admin : admins) {
            if (admin.get("username").equals(username)) {
                admins.remove(admin);
                return admin;
            }
        }
        return null;
    }
}
