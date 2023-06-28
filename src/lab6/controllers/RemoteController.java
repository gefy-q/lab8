package lab6.controllers;

import lab6.model.Dragon;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import lab6.Main;
import lab6.model.User;
import lab6.udp.ServerCommand;
import lab6.udp.ServerCommandType;
import lab6.udp.Utils;

public class RemoteController implements CollectionController {
    private ArrayList<Dragon> dragons = new ArrayList<>();
    
    public void updateCollection() {
        ServerCommand response = Main.getUdpManager().send(new ServerCommand(ServerCommandType.UPDATE_DATA, null));
        dragons = (ArrayList<Dragon>)Utils.deserializeObject(response.data);
    }
    private int findIndexById(Integer id) {
        ServerCommand response = Main.getUdpManager().send(new ServerCommand(ServerCommandType.FIND_INDEX, Utils.intToBytes(id)));
        return Utils.fromByteArray(response.data);
    }

    private int getIndexById(Integer id) {
        ServerCommand response = Main.getUdpManager().send(new ServerCommand(ServerCommandType.GET_INDEX, Utils.intToBytes(id)));
        return Utils.fromByteArray(response.data);
    }

    @Override
    public LocalDateTime getInitTime() {
        ServerCommand response = Main.getUdpManager().send(new ServerCommand(ServerCommandType.GET_INIT, null));
        return (LocalDateTime)Utils.deserializeObject(response.data);
    }

    @Override
    public int size() {
        ServerCommand response = Main.getUdpManager().send(new ServerCommand(ServerCommandType.SIZE, null));
        return Utils.fromByteArray(response.data);
    }

    @Override
    public void add(Dragon dragon) {
        Main.getUdpManager().send(new ServerCommand(ServerCommandType.ADD, Utils.serializeObject(dragon)));
    }

    @Override
    public boolean containsId(Integer id) {
        return findIndexById(id) != -1;
    }

    @Override
    public boolean isEmpty() {
        ServerCommand response = Main.getUdpManager().send(new ServerCommand(ServerCommandType.IS_EMPTY, null));
        return response.data[0] == 1;
    }

    @Override
    public void updateById(Integer id, Dragon dragon) {
        ArrayList<Object> args = new ArrayList<>();
        args.add(id);
        args.add(dragon);
        Main.getUdpManager().send(new ServerCommand(ServerCommandType.UPDATE, Utils.serializeObject(args)));
    }

    @Override
    public void removeById(Integer id) {
        Main.getUdpManager().send(new ServerCommand(ServerCommandType.REMOVE, Utils.intToBytes(id)));
    }

    @Override
    public void clear() {
        Main.getUdpManager().send(new ServerCommand(ServerCommandType.CLEAR, null));
    }

    @Override
    public void addIfMax(Dragon dragon) {
        Main.getUdpManager().send(new ServerCommand(ServerCommandType.ADD_IF_MAX, Utils.serializeObject(dragon)));
    }

    @Override
    public void removeGreater(Dragon dragon) {
        Main.getUdpManager().send(new ServerCommand(ServerCommandType.REMOVE_GREATER, Utils.serializeObject(dragon)));
    }

    @Override
    public int countByAge(Integer age) {
        ServerCommand response = Main.getUdpManager().send(new ServerCommand(ServerCommandType.COUNT_BY_AGE, Utils.intToBytes(age)));
        return Utils.fromByteArray(response.data);
    }

    @Override
    public int countLessThanWingspan(Double wingspan) {
        ServerCommand response = Main.getUdpManager().send(new ServerCommand(ServerCommandType.COUNT_LESS_THAN_WINGSPAN, Utils.serializeObject(wingspan)));
        return Utils.fromByteArray(response.data);
    }

    @Override
    public Iterator<Dragon> iterator() {
        updateCollection();
        return dragons.iterator();
    }

    @Override
    public User getOwner(Integer id) {
        updateCollection();
        int index = findIndexById(id);
        if(index < 0) return null;
        return dragons.get(index).getOwner();
    }

    @Override
    public Object toList() {
        return new ArrayList<>(dragons);
    }

    @Override
    public Dragon getById(Integer id) {
        updateCollection();
        for(Dragon d : dragons) {
            if(Objects.equals(d.getId(), id)) return d;
        }
        return null;
    }
}
