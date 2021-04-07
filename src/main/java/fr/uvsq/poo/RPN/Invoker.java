package fr.uvsq.poo.RPN;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Invoker {
    private HashMap<String,Command> commands = new HashMap<>();
    private List<Command> history = new ArrayList<>();

    public void register(String msgCmd,Command cmd){
        commands.put(msgCmd,cmd);
    }

    public void execute(String msgCmd){
        HashMap<String, Command> tempCmd = (HashMap<String, Command>) commands.clone();
        Command command = tempCmd.get(msgCmd);

        if (command == null) {
            throw new IllegalStateException("no command registered" + msgCmd);
        }else{
            command.execute();
            this.history.add(command);
        }

    }

    public void remove(){
        this.history.remove(history.size()-1);
    }



    public Command get(String name){
        return this.commands.get(name);
    }


}
