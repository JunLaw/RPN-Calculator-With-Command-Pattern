package fr.uvsq.poo.RPN;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Invoker {
    private HashMap<String,Command> commands = new HashMap<>();
    private List<Command> history = new ArrayList<Command>();

    public void register(String msgCmd,Command cmd){
        commands.put(msgCmd,cmd);
    }



    public void execute(String msgCmd){
        Command command = commands.get(msgCmd);
        int i = 1;
        int j = 0;
        if(msgCmd == "undo"){
        while(i == 1){
            System.out.println("i = " + i);
            System.out.println("j = " + j);
            Command teste = this.history.get(history.size()-1-j);
            //System.out.println(teste.getClass().getName());
            if (teste.getClass().getName().contains("regOP")) {
                get("regOP").undo();
                i = 0;
            } else if (teste.getClass().getName().contains("apOP")) {
                Command cmd1 = this.history.get(history.size()-2-j);
                Command cmd2 = this.history.get(history.size()-3-j);
                System.out.println(cmd1.getClass().getName());
                System.out.println(cmd2.getClass().getName());
                regOP cmd11 = (regOP) cmd1;
                regOP cmd22 = (regOP) cmd2;
                int nbr1 = cmd11.getNum();
                int nbr2 = cmd22.getNum();
                System.out.println("gathered 1 = " + nbr1);
                System.out.println("gathered 2 = " + nbr2);
                apOP ap = (apOP) get("apOP");
                ap.modify(nbr1,nbr2);
                ap.undo();
                i = 0;
            } else {
                i = 1;
                j++;
            }
        }
            j = 0;
        }else {
            if (command == null) {
                throw new IllegalStateException("no command registered" + msgCmd);
            }
            if(!command.getClass().getName().contains("retOP")) {

                this.history.add(command);
            }
            command.execute();
        }
    }

    public void remove(){

        this.history.remove(history.size()-1);
    }



    public Command get(){
       return this.history.get(history.size()-1);
    }

    public Command get(String name){
        return this.commands.get(name);
    }

    public void modify(String name,String avr,Command cmd){
        Command a = commands.get(name);
        a.modify(avr);
        commands.remove(name);
        commands.put(name, a);
    }



}
