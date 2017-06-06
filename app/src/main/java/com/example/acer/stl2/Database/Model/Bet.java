package com.example.acer.stl2.Database.Model;

/**
 * Created by reyanthonyaleonar on 6/7/17.
 */

public class Bet {

    int _id;
    int _combination_number;
    int _amount;
    int _number_recipient;
    String _type;

    public Bet () {

    }

    public Bet (int combination_number, int amount, int number_recipient, String type) {
        this._combination_number = combination_number;
        this._amount = amount;
        this._number_recipient = number_recipient;
        this._type = type;
    }
}
