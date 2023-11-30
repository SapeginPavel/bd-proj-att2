package ru.vsu.cs.sapegin.bd_proj_att2.app.exception;

public class NotFoundClientExc extends NotFoundException {

    public NotFoundClientExc() {
        super("Client with this id not found");
    }
}
