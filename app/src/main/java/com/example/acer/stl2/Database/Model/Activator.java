package com.example.acer.stl2.Database.Model;

/**
 * Created by Acer on 6/7/17.
 */

public class Activator {

    int _id;
    String _code;
    String _activator_number;
    int _activate;

    public Activator (String code, String activator_number, int activate) {
        this._code = code;
        this._activator_number = activator_number;
        this._activate = activate;
    }

    public String getCode () {
        return this._code;
    }

    public String getActivatorNumber () {
        return this._activator_number;
    }
}
