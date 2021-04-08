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

    public void execute(String msgCmd) {
        HashMap<String, Command> tempCmd = (HashMap<String, Command>) commands.clone();

        Command command = tempCmd.get(msgCmd);
        int i = 1;

        int undoCount = 0;
        if (msgCmd == "undo")
        {

            //System.out.println("i = " + i);
            //System.out.println("j = " + j);
            Command teste = this.history.get(history.size() - 1);
            remove();
            System.out.println(teste.getClass().getName());
            if (teste.getClass().getName().contains("regOP")) {
                get("regOP").undo();

            } else if (teste.getClass().getName().contains("Plus") || teste.getClass().getName().contains("Minus") || teste.getClass().getName().contains("Times") || teste.getClass().getName().contains("Divide")) {
                teste.undo();

            } else {
                //remove();

            }

        }else {
            if (command == null) {
                throw new IllegalStateException("no command registered" + msgCmd);
            }
            command.execute();
            if(!command.getClass().getName().contains("retOP")) {
                if(command.getClass().getName().contains("Plus") || command.getClass().getName().contains("Minus") || command.getClass().getName().contains("Times") || command.getClass().getName().contains("Divide") ){
                    apOP tmp = (apOP) tempCmd.get(msgCmd);
                    apOP tm = null;
                    try {
                        tm = (apOP) ((apOP) tempCmd.get(msgCmd)).clone();
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    this.history.add(tm);
                }else {
                    regOP tmp = (regOP) tempCmd.get(msgCmd);
                    regOP tm = null;
                    try {
                        tm = (regOP) tmp.clone();
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }

                    this.history.add(tm);
                }
            }
        }

    }

    public void remove(){
        this.history.remove(history.size()-1);
    }

    public void modify(String name,String avr,Command cmd){
        HashMap<String,Command> tempCmd = (HashMap<String, Command>) commands.clone();
        Command a = tempCmd.get(name);
        a.modify(avr);
        commands.remove(name);
        commands.put(name, a);
    }

    public Command get(String name){
        return this.commands.get(name);
    }


}
